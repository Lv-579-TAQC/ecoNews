import com.pageObject.EcoNewsPO;
import com.pageObject.WaitingPagePO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitingPageLabelsTest extends BasicTest{
    @Test
    public void openWaitingPage() {
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
        Assert.assertEquals(actualTextOfMainLabelOnWaitingPage, expectedTextOfMainLabelOnWaitingPage, "Failed, can`t find label with 'Please wait while loading...' text");

        String actualTextOfInformationLabelOnWaitingPage = openWaitingPage
                .getInformationLabel()
                .getText();
        String expectedTextOfInformationLabelOnWaitingPage = "Your news is loading to the website. Please wait until the page refreshes.";
        Assert.assertEquals(actualTextOfInformationLabelOnWaitingPage, expectedTextOfInformationLabelOnWaitingPage, "Failed, can`t find label with 'Your news is loading to the website. Please wait until the page refreshes.' text");
    }
}
