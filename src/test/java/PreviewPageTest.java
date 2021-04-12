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
    private static WebDriver webDriver;
    private static final String EMAIL = "lizochka1211@gmail.com";
    private static final String PASSWORD = "eAZAaq4X7KQQ6f6~";

    @BeforeClass
    public void setUpClass() {
        String WebDriverPath = System.getenv("WebDrivers");
        String os = System.getProperty("os.name");
        if (os.startsWith("Windows")) {
            WebDriverPath += "\\chromedriver.exe";
        } else {
            WebDriverPath += "/chromedriver";
        }

        System.setProperty("webdriver.chrome.driver", WebDriverPath);

        webDriver = new ChromeDriver();
        webDriver.get("https://ita-social-projects.github.io/GreenCityClient/#/");
        webDriver.manage().window().maximize();
        LogInPO logInPO = new LogInPO(webDriver)
                .clickSignInMenuButton()
                .setEmail(EMAIL)
                .setPassword(PASSWORD)
                .clickSignInButton();
    }

    @AfterClass
    public void tearDownClass(){
        webDriver.quit();
    }

    @DataProvider()
    public Object[][] correctDataForNews(){
        return new Object[][]{
                {"This is title",
                "This is new test content for this page!\nThis is new test content for this page!"}
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

        Assert.assertEquals(previewPO.getTitleLabel().getText(), title, "Input and viewed titles should be the same");
        Assert.assertEquals(previewPO.getContentLabel().getText().trim(), content.trim());
        Assert.assertTrue(previewPO.isPublishButtonExists());
    }

    @Test(dataProvider = "correctDataForNews")
    public void verifyEditingNewsAfterClickBack(String title, String content){
        PreviewPO previewPO = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn()
                .clickPreviewButton();

        Assert.assertFalse(previewPO.isPublishButtonExists());

        PreviewPO newPreviewPO = previewPO.clickBackToEditingButton()
                .setTitle(title)
                .setContent(content)
                .clickTagNews()
                .clickPreviewButton();

        Assert.assertEquals(newPreviewPO.getTitleLabel().getText(), title, "Input and viewed titles should be the same");
        Assert.assertEquals(newPreviewPO.getContentLabel().getText().trim(), content.trim());
        Assert.assertTrue(newPreviewPO.isPublishButtonExists());
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
                .clickPublishButton();

        WaitsSwitcher wait = new WaitsSwitcher(webDriver);
        wait.setImplicitWaits(100);

        NewsComponent firstNews = ecoNewsPO.getNewsComponentContainer(false)
                .chooseNewsByNumber(0);
        Assert.assertEquals(firstNews.getNewsTitle().getText().trim(), title.trim());

    }

    @Test(dataProvider = "correctDataForNews")
    public void verifyNewsCreated(String title, String content){
        NewsComponent firstNews = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .getNewsComponentContainer(false)
                .chooseNewsByNumber(0);

        Assert.assertEquals(firstNews.getNewsTitle().getText().trim(), title.trim());
    }
}
