import com.pageObject.EcoNewsPO;
import com.pageObject.PreviewPO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenPreviewPageTest extends BasicTest{

    @Test
    public void verifyButtonTextInPreviewPage() {
        PreviewPO createNewsPage = new EcoNewsPO(webDriver)
                .getHeaderComponent()
                .clickEcoNews()
                .clickCreateNewsBtn()
                .clickPreviewButton();

        String textBackToEditingButton = createNewsPage
                .getBackToEditingButton()
                .getText();
        String expectedTextBackToEditingButton = "Back to editing";
        Assert.assertEquals(textBackToEditingButton, expectedTextBackToEditingButton, "Failed, can`t find label with 'Back to editing' text");
    }
}
