import com.pageObject.EcoNewsPO;
import com.pageObject.WaitingPagePO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenWaitingPageTest extends BasicTest {

    @Test
    public void verifyPublishButtonFunctional() {
        String TITLE = "Some title for test";
        String CONTENT = "Some information for test in content field";
        WaitingPagePO openWaitingPage = new EcoNewsPO(webDriver)
                .getHeaderComponent()
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setTitle(TITLE)
                .setContent(CONTENT)
                .clickInitiativesTag()
                .clickPublishButton();

        String actualTextOfMainLabelOnWaitingPage = openWaitingPage
                .getMainLabel()
                .getText();
        String expectedTextOfMainLabelOnWaitingPage = "Please wait while loading...";
        Assert.assertEquals(actualTextOfMainLabelOnWaitingPage, expectedTextOfMainLabelOnWaitingPage, "");  //TODO
    }
}
