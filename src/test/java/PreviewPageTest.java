import com.pageObject.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class PreviewPageTest extends BasicTest{

    @DataProvider()
    public Object[][] correctDataForNews(){
        return new Object[][]{
                {"This is title",
                "This is new test content for this page!\nThis is new test content for this page!"}
        };
    }

    @DataProvider()
    public Object[][] incorrectDataForNews(){
        return new Object[][]{
                {"This is title",
                        "Content"}
        };
    }

    @Test(dataProvider = "correctDataForNews")
    public void verifyPreviewTitleAndContent(String title, String content) {
        PreviewPO previewPO = new EcoNewsPO(webDriver)
                .getHeaderComponent()
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setTitle(title)
                .clickTagNews()
                .setContent(content)
                .clickPreviewButton();

        String expectedAuthor = "by " + previewPO.getHeaderComponent().getUserName().getText();
        String expectedDate = getCurrentDate();

        Assert.assertEquals(previewPO.getDateLabel().getText(), expectedDate, "There are should be current date");
        Assert.assertEquals(previewPO.getAuthorLabel().getText(), expectedAuthor, "Usernames must be the same");
        Assert.assertEquals(previewPO.getTitleLabel().getText(), title, "Input and viewed titles should be the same.");
        Assert.assertEquals(previewPO.getContentLabel().getText().trim(), content.trim(), "Input and viewed content should be the same.");
        Assert.assertTrue(previewPO.isPublishButtonExists(), "Publish button should exist if correct data are entered.");
    }

    @Test(dataProvider = "incorrectDataForNews")
    public void verifyPublishButtonNotExistsWithIncorrectData(String title, String content){
        PreviewPO previewPO = new EcoNewsPO(webDriver)
                .getHeaderComponent()
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setTitle(title)
                .setContent(content)
                .clickPreviewButton();

        Assert.assertEquals(previewPO.getTitleLabel().getText(), title, "Input and viewed titles should be the same.");
        Assert.assertEquals(previewPO.getContentLabel().getText().trim(), content.trim(), "Input and viewed content should be the same.");
        Assert.assertFalse(previewPO.isPublishButtonExists(), "Publish button should not exist if incorrect data are entered.");
    }

    @Test(dataProvider = "correctDataForNews")
    public void verifyEditingNewsAfterClickBack(String title, String content){
        PreviewPO previewPO = new EcoNewsPO(webDriver)
                .getHeaderComponent()
                .clickEcoNews()
                .clickCreateNewsBtn()
                .clickPreviewButton()
                .clickBackToEditingButton()
                .setTitle(title)
                .setContent(content)
                .clickTagNews()
                .clickPreviewButton();

        Assert.assertEquals(previewPO.getTitleLabel().getText(), title, "Input and viewed titles should be the same.");
        Assert.assertEquals(previewPO.getContentLabel().getText().trim(), content.trim(), "Input and viewed content should be the same.");
        Assert.assertTrue(previewPO.isPublishButtonExists(), "Publish button should exist if correct data are entered after editing.");
    }

    @Test(dataProvider = "correctDataForNews")
    public void verifyPublishButton(String title, String content){
        EcoNewsPO ecoNewsPO = new EcoNewsPO(webDriver)
                .getHeaderComponent()
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setTitle(title)
                .setContent(content)
                .clickTagNews()
                .clickPreviewButton()
                .clickPublishButtonFromPreviewPage();

        NewsComponent firstNews = ecoNewsPO.getNewsComponentContainer(false)
                .chooseNewsByNumber(0);
        Assert.assertEquals(firstNews.getNewsTitle().getText().trim(), title.trim(), "Input and published new's titles should be the same.");
        Assert.assertEquals(firstNews.getNewsContent().getText().trim(), content.trim(), "Input and published new's content should be the same.");
    }

    public String getCurrentDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH);
        LocalDate localDate = LocalDate.now();
        return dtf.format(localDate);
    }
}
