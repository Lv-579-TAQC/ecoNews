import com.pageObject.EcoNewsPO;
import com.pageObject.PreviewPO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenPreviewPageTest extends BasicTest{

    @Test
    public void verifyButtonTextInPreviewPage() {
        PreviewPO createNewsPage = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn()
                .clickPreviewButton();

        String textBackToEditingButton = createNewsPage
                .getBackToEditingButton()
                .getText();
        String expectedTextBackToEditingButton = "Back to editing";
        Assert.assertEquals(textBackToEditingButton, expectedTextBackToEditingButton, "");
    }
}
