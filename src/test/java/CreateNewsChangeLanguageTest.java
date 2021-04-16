import com.pageObject.CreateNewsPO;
import com.pageObject.EcoNewsPO;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class CreateNewsChangeLanguageTest extends BasicTest{

    CreateNewsPO createNewsPage;

    public String getTranslation(String key, String language) throws IOException {
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream("src/main/resources/languages/" + language + ".properties");
        prop.load(new InputStreamReader(input, "UTF-8"));
        input.close();
        return prop.getProperty(key);
    }

    @BeforeMethod
    public void beforeMethod(){
        createNewsPage = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn();
    }

    @DataProvider(name = "languages")
    public Object[][] languages() {
        return new Object[][]{
                {"ua"},
                {"en"},
                {"ru"}
        };
    }

    @Test(dataProvider = "languages")
    public void verifyCreateNewsUaEnRuTranslation(String language) throws IOException {

        createNewsPage.setLanguage(language);

        SoftAssert softAssertCreateNews = new SoftAssert();

        softAssertCreateNews.assertEquals(createNewsPage.getTitlePageLabel().getText(), getTranslation("PAGE_TITLE", language));
        softAssertCreateNews.assertEquals(createNewsPage.getAdditionalLabel().getText(), getTranslation("ADDITIONAL", language));
        softAssertCreateNews.assertEquals(createNewsPage.getTitleNewsLabel().getText(), getTranslation("NEWS_TITLE", language));
        softAssertCreateNews.assertEquals(createNewsPage.getPictureLabel().getText(), getTranslation("PICTURE", language));
        softAssertCreateNews.assertEquals(createNewsPage.getChoosePictureLabel().getText(), getTranslation("CHOOSE_PICTURE", language));
        softAssertCreateNews.assertEquals(createNewsPage.getSourceLabel().getText(), getTranslation("SOURCE", language));
        softAssertCreateNews.assertEquals(createNewsPage.getContentLabel().getText(), getTranslation("CONTENT", language));
        softAssertCreateNews.assertEquals(createNewsPage.getDateLabel().getText(), getTranslation("DATE", language));
        softAssertCreateNews.assertEquals(createNewsPage.getAuthorLabel().getText(), getTranslation("AUTHOR", language));
        softAssertCreateNews.assertEquals(createNewsPage.getChooseTagsLabel().getText(), getTranslation("CHOOSE_TAGS", language));
        softAssertCreateNews.assertEquals(createNewsPage.getTags().getNewsTagButton().getText(), getTranslation("NEWS_TAG", language));
        softAssertCreateNews.assertEquals(createNewsPage.getTags().getAdsTagButton().getText(), getTranslation("ADS_TAG", language));
        softAssertCreateNews.assertEquals(createNewsPage.getTags().getEventsTagButton().getText(), getTranslation("EVENTS_TAG", language));
        softAssertCreateNews.assertEquals(createNewsPage.getTags().getInitiativesTagButton().getText(), getTranslation("INITIATIVES_TAG", language));
        softAssertCreateNews.assertEquals(createNewsPage.getTags().getEducationsTagButton().getText(), getTranslation("EDUCATION_TAG", language));
        softAssertCreateNews.assertEquals(createNewsPage.getCancelButton().getText(), getTranslation("CANCEL", language));
        softAssertCreateNews.assertEquals(createNewsPage.getPublishButton().getText(), getTranslation("PUBLISH", language));
        softAssertCreateNews.assertEquals(createNewsPage.getPreviewButton().getText(), getTranslation("PREVIEW", language));

        softAssertCreateNews.assertAll();
    }

    @Test(dataProvider = "languages")
    public void verifyDateAndAuthorUaRUEnPositionUnderForm(String language) {
        createNewsPage.setLanguage(language);
        int theLowestLabelOnThePage = createNewsPage.getContentLabel().getLocation().getY();

        Assert.assertTrue(createNewsPage.getDateLabel().getLocation().getY() > theLowestLabelOnThePage);
        Assert.assertTrue(createNewsPage.getAuthorLabel().getLocation().getY() > theLowestLabelOnThePage);
    }

    @Test(dataProvider = "languages")
    public void verifyCreateNewsPageTabulation(String language) {
        createNewsPage.setLanguage(language);

        SoftAssert softAssertCreateNews = new SoftAssert();

        int expectedX = createNewsPage.getTitlePageLabel().getLocation().getX();

        softAssertCreateNews.assertEquals(expectedX, createNewsPage.getAdditionalLabel().getLocation().getX());
        softAssertCreateNews.assertEquals(expectedX, createNewsPage.getTitleNewsLabel().getLocation().getX());
        softAssertCreateNews.assertEquals(expectedX, createNewsPage.getSourceLabel().getLocation().getX());
        softAssertCreateNews.assertEquals(expectedX, createNewsPage.getContentLabel().getLocation().getX());
        softAssertCreateNews.assertEquals(expectedX, createNewsPage.getContentLabel().getLocation().getX());

        softAssertCreateNews.assertAll();
    }

}

