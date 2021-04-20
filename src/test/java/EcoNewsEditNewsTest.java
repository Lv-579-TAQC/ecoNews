import com.pageObject.EcoNewsPO;
import com.pageObject.EditNewsPagePO;
import com.pageObject.PreviewEditPagePO;
import com.pageObject.SomeNewsPagePO;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EcoNewsEditNewsTest extends BasicTest {
    private final String EDIT_TITLE = "Title field after edit";
    private final String EDIT_CONTENT = "Content field after edit";
    private final String CLEAR_FIELD = "\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b";

    @BeforeMethod
    public void createNewsAndOpenEditPage() {
        String CONTENT = "Content field before edit";
        String TITLE = "Title field before edit";
        new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setTitle(TITLE)
                .setContent(CONTENT)
                .clickEducationTag()
                .clickPublishButton()
                .clickOnTheLatestNewsCreatedByTheTestUserOnTheEcoNewsPage()
                .clickEditNewsButton();
    }

    @Test
    public void verifyNewsEditing() {
        SomeNewsPagePO verifyNewsEditing = new EditNewsPagePO(webDriver)
                .clearTitleFieldOnEditPage(CLEAR_FIELD)
                .setTitleOnEditPage(EDIT_TITLE)
                .clearContentOnEditPage(CLEAR_FIELD)
                .setContentOnEditPage(EDIT_CONTENT)
                .clickEditButton()
                .clickOnTheLatestNewsCreatedByTheTestUserOnTheEcoNewsPage();

        String actualTextTitleLabel = verifyNewsEditing
                .getTitleOnNewsPage()
                .getText();
        String expectedTextTitleLabel = "Title field after edit";
        Assert.assertEquals(actualTextTitleLabel, expectedTextTitleLabel, "Verification failed, actual and expected titles do not match");

        String actualTextContentLabel = verifyNewsEditing
                .getContentOnNewsPage()
                .getText();
        String expectedTextContentLabel = " Content field after edit ";
        Assert.assertEquals(actualTextContentLabel, expectedTextContentLabel, "Verification failed, actual and expected contents do not match");

    }

    @Test
    public void verifyPreviewButtonOnEditNewsPage() {
        PreviewEditPagePO verifyPreviewButtonOnEditNewsPage = new EditNewsPagePO(webDriver)
                .clearTitleFieldOnEditPage(CLEAR_FIELD)
                .setTitleOnEditPage(EDIT_TITLE)
                .clearContentOnEditPage(CLEAR_FIELD)
                .setContentOnEditPage(EDIT_CONTENT)
                .clickPreviewButtonOnEditNewsPage();

        String actualTextTitleLabelOnPreviewEditPage = verifyPreviewButtonOnEditNewsPage
                .getTitleLabelOnPreviewEditPage()
                .getText();

        String expectedTextTitleLabelOnPreviewEditPage = "Title field after edit";
        Assert.assertEquals(actualTextTitleLabelOnPreviewEditPage, expectedTextTitleLabelOnPreviewEditPage, "Verification failed, actual and expected titles do not match");

        String actualTextContentLabelOnPreviewEditPage = verifyPreviewButtonOnEditNewsPage
                .getTitleLabelOnPreviewEditPage()
                .getText();

        String expectedTextContentLabelOnPreviewEditPage = "Title field after edit";
        Assert.assertEquals(actualTextContentLabelOnPreviewEditPage, expectedTextContentLabelOnPreviewEditPage, "Verification failed, actual and expected titles do not match");
    }

    @Test
    public void verifyEditButtonFunctionalOnPreviewEditPage() {
        SomeNewsPagePO verifyEditButtonFunctionalOnPreviewEditPage = new EditNewsPagePO(webDriver)
                .clearTitleFieldOnEditPage(CLEAR_FIELD)
                .setTitleOnEditPage(EDIT_TITLE)
                .clearContentOnEditPage(CLEAR_FIELD)
                .setContentOnEditPage(EDIT_CONTENT)
                .clickPreviewButtonOnEditNewsPage()
                .clickEditButtonOnPreviewEditPage()
                .clickOnTheLatestNewsCreatedByTheTestUserOnTheEcoNewsPage();

        String actualTextTitleLabel = verifyEditButtonFunctionalOnPreviewEditPage
                .getTitleOnNewsPage()
                .getText();
        String expectedTextTitleLabel = "Title field after edit";
        Assert.assertEquals(actualTextTitleLabel, expectedTextTitleLabel, "Verification failed, actual and expected titles do not match");

        String actualTextContentLabel = verifyEditButtonFunctionalOnPreviewEditPage
                .getContentOnNewsPage()
                .getText();
        String expectedTextContentLabel = " Content field after edit ";
        Assert.assertEquals(actualTextContentLabel, expectedTextContentLabel, "Verification failed, actual and expected contents do not match");
    }

    @Test
    public void verifyCancelButtonFunctionalWithoutChangesOnPreviewEditPage() {
        SomeNewsPagePO verifyCancelButtonFunctionalWithoutChangesOnPreviewEditPage = new EditNewsPagePO(webDriver)
                .clickCancelButtonOnEditNewsPage()
                .clickOnTheLatestNewsCreatedByTheTestUserOnTheEcoNewsPage();

        String actualTextTitleLabel = verifyCancelButtonFunctionalWithoutChangesOnPreviewEditPage
                .getTitleOnNewsPage()
                .getText();
        String expectedTextTitleLabel = "Title field before edit";
        Assert.assertEquals(actualTextTitleLabel, expectedTextTitleLabel, "Verification failed, actual and expected titles do not match");

        String actualTextContentLabel = verifyCancelButtonFunctionalWithoutChangesOnPreviewEditPage
                .getContentOnNewsPage()
                .getText();
        String expectedTextContentLabel = " Content field before edit ";
        Assert.assertEquals(actualTextContentLabel, expectedTextContentLabel, "Verification failed, actual and expected contents do not match");

    }
}

