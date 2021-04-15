import com.pageObject.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;

public class AddImageTest {
    private static WebDriver webDriver;
    private final String EMAIL = "amelyanovich11@gmail.com";
    private final String PASSWORD = "Qwerty123_";

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

    @Test (dataProvider  = "validValuesToCreateNews")
    public void verifyCreatingNewsWithImage(String title, String content, String tags) {
        final String urlForDefault ="https://ita-social-projects.github.io/GreenCityClient/assets/img/icon/econews/default-image-list-view.png";
        File file = new File("src/main/resources/Images/29072.png");
        final String imagePlaceOnYourComputer = file.getAbsolutePath();

        NewsComponent firstNews = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setTitle(title)
                .clickTagAds()
                .setContent(content)
                .browseImage(imagePlaceOnYourComputer)
                .clickSubmitButton()
                .clickPublishButton()
                .clickEcoNews()
                .getNewsComponentContainer(false)
                .chooseNewsByNumber(0);

        String srcOfFirstNewsImage = firstNews.getNewsImage();
        String tagsOfFirstNews = firstNews.getNewsTag().getText();
        String contentOfFistNews = firstNews.getNewsContent().getText();
        String titleOfFisrtNews = firstNews.getNewsTitle().getText();

        SoftAssert asert = new SoftAssert();
        asert.assertEquals(srcOfFirstNewsImage, urlForDefault, "Image don't match");
        asert.assertEquals(tagsOfFirstNews, tags, "Tags are not same");
        asert.assertEquals(contentOfFistNews, content, "Content don't match");
        asert.assertEquals(titleOfFisrtNews, title, "Title is not same");
        asert.assertAll();
    }
    @DataProvider()
    public Object[][] validValuesToCreateNews(){
        return new Object[][]{
                {"Wow, this is example of new news",
                        "This content for test example new news",
                        "Ads"}
        };
    }
}