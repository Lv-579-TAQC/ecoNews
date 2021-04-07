import com.elements.LabelElement;
import com.pageObject.*;
import org.openqa.selenium.WebDriver;
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
        TagComponent tagComponent = new TagComponent(webDriver);
        PreviewPO previewPO = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setTitle(title)
                .clickTagNews()
                .setContent(content)
                .clickPreviewButton();
        LabelElement textTitle = previewPO.getTitleLabel();
        LabelElement textContent = previewPO.getContentLabel();


        Assert.assertEquals(textTitle.getText(), title, "Input and viewed titles should be the same");
        Assert.assertEquals(textContent.getText().trim(), content.trim());
        Assert.assertTrue(previewPO.isPublishButtonExists());
    }

    @Test(dataProvider = "correctDataForNews")
    public void verifyEditingNewsAfterClickBack(String title, String content){
        PreviewPO previewPO = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn()
                .clickPreviewButton();

        Assert.assertTrue(previewPO.isPublishButtonExists());

        previewPO.clickBackToEditingButton()
                .setTitle(title)
                .clickTagNews()
                .setContent(content)
                .clickPreviewButton();

        Assert.assertEquals(previewPO.getTitleLabel().getText(), title, "Input and viewed titles should be the same");
        Assert.assertEquals(previewPO.getContentLabel().getText().trim(), content.trim());
        Assert.assertTrue(previewPO.isPublishButtonExists());
    }

}
