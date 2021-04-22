import com.elements.LabelElement;
import com.pageObject.CreateNewsPO;
import com.pageObject.PreviewPO;
import com.pageObject.WaitingPagePO;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pageObject.EcoNewsPO;

public class CreateNewsSourceFieldTest extends BasicTest {
    @AfterMethod
    void finishUp() {
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

        String actualTextOfMainLabelOnWaitingPage = createNewsWithCorrectLinkInSourceField.getMainLabel().getText();
        String expectedTextOfMainLabelOnWaitingPage = "Please wait while loading...";
        Assert.assertEquals(actualTextOfMainLabelOnWaitingPage, expectedTextOfMainLabelOnWaitingPage, "Failed, can`t find label with 'Please wait while loading...' text");

        String actualTextOfInformationLabelOnWaitingPage = createNewsWithCorrectLinkInSourceField.getInformationLabel().getText();
        String expectedTextOfInformationLabelOnWaitingPage = "Your news is loading to the website. Please wait until the page refreshes.";
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

    @DataProvider
    public Object[][] verifyNoAutoResizing() {
        return new Object[][]{
                {"https://ita-social-projects.github.io/GreenCityClient/#/news/create/GreenCityClient/#/" +
                        "news/create-news-news/GreenCityClient/#/news/create/GreenCityClient/#/" +
                        "news/create-news-news",
                        "height: 48px;"}
        };
    }

    @Test(dataProvider = "verifyNoAutoResizing")
    public void verifyNoAutoResizingInFieldCorrect(String source, String ExpectedFieldHeight) {
        CreateNewsPO verifyNoAutoResizing = new EcoNewsPO(webDriver)
                .getHeaderComponent()
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setSource(source);

        String actualSourceFieldHeight = verifyNoAutoResizing.getSourceFieldHeight();
        Assert.assertEquals(actualSourceFieldHeight, ExpectedFieldHeight);
    }


}






