import com.elements.LabelElement;
import com.pageObject.*;
import com.tools.WaitsSwitcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class PreviewPageTest extends BasicTest{
//    private static WebDriver webDriver;
//    private static final String EMAIL = "lizochka1211@gmail.com";
//    private static final String PASSWORD = "eAZAaq4X7KQQ6f6~";
//
//    @BeforeClass
//    public void setUpClass() {
//        String WebDriverPath = System.getenv("WebDrivers");
//        String os = System.getProperty("os.name");
//        if (os.startsWith("Windows")) {
//            WebDriverPath += "\\chromedriver.exe";
//        } else {
//            WebDriverPath += "/chromedriver";
//        }
//
//        System.setProperty("webdriver.chrome.driver", WebDriverPath);
//
//        webDriver = new ChromeDriver();
//        webDriver.get("https://ita-social-projects.github.io/GreenCityClient/#/");
//        webDriver.manage().window().maximize();
//        LogInPO logInPO = new LogInPO(webDriver)
//                .clickSignInMenuButton()
//                .setEmail(EMAIL)
//                .setPassword(PASSWORD)
//                .clickSignInButton();
//    }
//
//    @AfterClass
//    public void tearDownClass(){
//        webDriver.quit();
//    }

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
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setTitle(title)
                .clickTagNews()
                .setContent(content)
                .clickPreviewButton();

        String expectedAuthor = "by " + previewPO.getHeaderComponent().getUserName().getText();

        Assert.assertEquals(previewPO.getAuthorLabel().getText(), expectedAuthor, "Usernames must be the same");
        Assert.assertEquals(previewPO.getTitleLabel().getText(), title, "Input and viewed titles should be the same.");
        Assert.assertEquals(previewPO.getContentLabel().getText().trim(), content.trim(), "Input and viewed content should be the same.");
        Assert.assertTrue(previewPO.isPublishButtonExists(), "Publish button should exist if correct data are entered.");
    }

    @Test(dataProvider = "incorrectDataForNews")
    public void verifyPublishButtonNotExistsWithIncorrectData(String title, String content){
        PreviewPO previewPO = new EcoNewsPO(webDriver)
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
}
