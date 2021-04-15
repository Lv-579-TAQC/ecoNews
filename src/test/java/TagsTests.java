import com.locators.CreateNewsPageLocators;
import com.locators.TagComponentLocators;
import com.pageObject.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TagsTests {
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

//    @AfterClass
//    public void tearDownClass(){
//        webDriver.quit();
//    }

    @Test
    public void verifyWeCannotUseMoreThanThreeTags(){

        String  NEWS_TAGBUTTON = "//button[contains(@class, 'ng')][1]";
        String      ADS_TAGBUTTON="//button[contains(@class, 'ng')][2]";
                String      EVENTS_TAGBUTTON="//button[contains(@class, 'ng')][3]";
                String      INITIATIVES_TAGBUTTON="//button[contains(@class, 'ng')][4]";
                String     EDUCATION_TAGBUTTON="//button[contains(@class, 'ng')][5]";
        CreateNewsPO warning = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn()
                .clickTagNews()
                .clickTagAds()
                .clickInitiativesTag()
                .clickEducationTag()
                .clickEventsTag();




        SoftAssert asert = new SoftAssert();
        asert.assertEquals(warning.isNewsTagIsActive(), true,"News");
        asert.assertEquals(warning.isEducationTagIsActive(), false,"Education");
        asert.assertEquals(warning.isInitiativesTagIsActive(), true,"Initiative");
        asert.assertEquals(warning.isAdsTagIsActive(), true,"Ads");
        asert.assertEquals(warning.isEventsTagIsActive(), false,"Ads");
        asert.assertEquals(warning.isSignUnderTagsMakingWarning(),true,"Warning");
        asert.assertAll();





    }
}
