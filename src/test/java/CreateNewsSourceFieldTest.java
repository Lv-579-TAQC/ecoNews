import com.elements.LabelElement;
import com.pageObject.CreateNewsPO;
import com.pageObject.WaitingPagePO;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pageObject.EcoNewsPO;

public class CreateNewsSourceFieldTest extends BasicTest {
    private String expectedTextOfMainLabelOnWaitingPage = "Please wait while loading...";
    private String expectedTextOfInformationLabelOnWaitingPage =
            "Your news is loading to the website. Please wait until the page refreshes.";

    @AfterMethod
    public void finishUp() {
        webDriver.navigate().refresh();
    }

    @DataProvider
    public Object[][] correctLinkInSourceField() {
        return new Object[][]{
                {"Just title",
                        "https://ita-social-projects.github.io/GreenCityClient/#/news",
                        "Please provide as many details as you can."},
                {"Just title",
                        "http://ita-social-projects.github.io/GreenCityClient/#/news",
                        "Please provide as many details as you can."}
        };
    }

    @Test(dataProvider = "correctLinkInSourceField")
    public void createNewsWithCorrectLinkInSourceField(String title, String source, String content) {
        WaitingPagePO createNewsWithCorrectLinkInSourceField = new EcoNewsPO(webDriver)
                .getHeaderComponent()
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setTitle(title)
                .clickTagNews()
                .setSource(source)
                .setContent(content)
                .clickPublishButton();

        String actualTextOfMainLabelOnWaitingPage = createNewsWithCorrectLinkInSourceField
                .getMainLabel()
                .getText();
        Assert.assertEquals(actualTextOfMainLabelOnWaitingPage, expectedTextOfMainLabelOnWaitingPage,
                "Сan`t find label with 'Please wait while loading...' text");

        String actualTextOfInformationLabelOnWaitingPage = createNewsWithCorrectLinkInSourceField
                .getInformationLabel()
                .getText();
        Assert.assertEquals(actualTextOfInformationLabelOnWaitingPage, expectedTextOfInformationLabelOnWaitingPage);
    }

    @DataProvider
    public Object[][] inCorrectLinkInSourceField() {
        return new Object[][]{
                {"Just title",
                        "ita-social-projects.github.io/GreenCityClient/#/news",
                        "Please provide as many details as you can."}
        };
    }

    @Test(dataProvider = "inCorrectLinkInSourceField")
    public void createNewsWithInCorrectLinkInSourceField(String title, String source, String content) {
        CreateNewsPO createNewsWithInCorrectLinkInSourceField = new EcoNewsPO(webDriver)
                .getHeaderComponent()
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setTitle(title)
                .clickTagNews()
                .setSource(source)
                .setContent(content);

        Assert.assertFalse(createNewsWithInCorrectLinkInSourceField.isPublishButtonIsActive(),
                "The Publish button should not exist if incorrect data is entered.");
    }

    @DataProvider
    public Object[][] createWithoutSourceField() {
        return new Object[][]{
                {"Just title",
                        "Please provide as many details as you can."}
        };
    }

    @Test(dataProvider = "createWithoutSourceField")
    public void createNewsWithoutLinkInSourceField(String title, String content) {
        WaitingPagePO createNewsWithInCorrectLinkInSourceField = new EcoNewsPO(webDriver)
                .getHeaderComponent()
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setTitle(title)
                .clickTagNews()
                .setContent(content)
                .clickPublishButton();

        String actualTextOfMainLabelOnWaitingPage = createNewsWithInCorrectLinkInSourceField
                .getMainLabel()
                .getText();
        Assert.assertEquals(actualTextOfMainLabelOnWaitingPage, expectedTextOfMainLabelOnWaitingPage,
                "Failed, can`t find label with 'Please wait while loading...' text");

        String actualTextOfInformationLabelOnWaitingPage = createNewsWithInCorrectLinkInSourceField.
                getInformationLabel().
                getText();
        Assert.assertEquals(actualTextOfInformationLabelOnWaitingPage, expectedTextOfInformationLabelOnWaitingPage,
                "can`t find label with 'Your news is loading to the website." +
                        " Please wait until the page refreshes.' text");
    }

    @DataProvider
    public Object[][] inCorrectLinkForVerifyWarningLabel() {
        return new Object[][]{
                {"google.com",
                        "#ff0000"}
        };
    }

    @Test(dataProvider = "inCorrectLinkForVerifyWarningLabel")
    public void verifyThatTextInFieldCorrect(String mainText, String ExpectedColor) {
        LabelElement lb = new EcoNewsPO(webDriver)
                .getHeaderComponent()
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setSource(mainText)
                .getSourceWarningLabel();

        Assert.assertEquals(lb.getColorHex(), ExpectedColor);
    }










//    @DataProvider
//    public Object[][] verifyNoAutoResizing() {
//        return new Object[][]{
//                {"https://ita-social-projects.github.io/GreenCityClient/#/news/create/GreenCityClient/#/",
//                        "height: 48px;"}
//        };
//    }
//
//    @Test(dataProvider = "verifyNoAutoResizing")
//    public void verifyNoAutoResizingInSourceField(String source, String ExpectedFieldHeight) {
//        CreateNewsPO verifyNoAutoResizing = new EcoNewsPO(webDriver)
//                .getHeaderComponent()
//                .clickEcoNews()
//                .clickCreateNewsBtn()
//                .setSource(source);
//
//        String actualSourceFieldHeight = verifyNoAutoResizing.getSourceFieldHeight();
//        Assert.assertEquals(actualSourceFieldHeight, ExpectedFieldHeight);
//    }


}






