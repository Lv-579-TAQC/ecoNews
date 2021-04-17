import com.pageObject.EcoNewsPO;
import com.pageObject.EditNewsPagePO;
import com.pageObject.SomeNewsPagePO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EcoNewsEditNewsTest extends BasicTest{
    private final String TITLE = "Title field before edit";
    private final String CONTENT = "Content field before edit";
    private final String EDIT_TITLE = "Title field after edit";
    private final String EDIT_CONTENT = "Content field after edit";
    private final String CLEAR_FIELD = "\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b";

    @Test
    public void createNewNewsForEdit(){
        SomeNewsPagePO createNewsForEdit = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setTitle(TITLE)
                .setContent(CONTENT)
                .clickEducationTag()
                .clickPublishButton()
                .clickOnFirstNewsOnPage()
                .clickEditNewsButton()
                .clearTitleFieldOnEditPage(CLEAR_FIELD)
                .setTitleOnEditPage(EDIT_TITLE)
                .clearContentOnEditPage(CLEAR_FIELD)
                .setContentOnEditPage(EDIT_CONTENT)
                .clickEditButton()
                .clickOnFirstNewsOnPage();

        String actualTextTitleLabel = createNewsForEdit
                .getTitleOnNewsPage()
                .getText();
        String expectedTextTitleLabel = "Title field after edit";
        Assert.assertEquals(actualTextTitleLabel, expectedTextTitleLabel);

        String actualTextContentLabel = createNewsForEdit
                .getContentOnNewsPage()
                .getText();
        String expectedTextContentLabel = " Content field after edit ";
        Assert.assertEquals(actualTextContentLabel, expectedTextContentLabel);

    }
}
