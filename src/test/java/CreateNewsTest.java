import com.locators.CreateNewsPageLocators;
import com.pageObject.CreateNewsPO;
import com.pageObject.EcoNewsPO;
import com.pageObject.LogInPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class CreateNewsTest {
    private static WebDriver webDriver;
    final String EMAIL = "bilobram.v@ukr.net";
    final String PASSWORD = "8428665Bilobramlfml.";
    CreateNewsPO createNewsPage;

    public String getTranslation(String key, String language) throws IOException {
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream("src/main/resources/languages/" + language + ".properties");
        prop.load(new InputStreamReader(input, "UTF-8"));
        input.close();
        return prop.getProperty(key);
    }

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
        LogInPO logInPO = new LogInPO(webDriver)
                .clickSignInMenuButton()
                .setEmail(EMAIL)
                .setPassword(PASSWORD)
                .clickSignInButton();

        createNewsPage = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn();
    }

    @AfterClass
    public void tearDownClass() {
        webDriver.quit();
    }

    @DataProvider(name = "languages")
    public Object[][] languages() {
        return new Object[][]{
                {"ua"},
                {"en"},
                {"ru"}
        };
    }

    @Test(dataProvider = "languages")
    public void verifyCreateNewsUaEnRuTranslation(String language) throws IOException {

        createNewsPage.setLanguage(language);

        SoftAssert softAssertCreateNews = new SoftAssert();

        softAssertCreateNews.assertEquals(createNewsPage.getTitlePageLabel().getText(), getTranslation("PAGE_TITLE", language));
        softAssertCreateNews.assertEquals(createNewsPage.getAdditionalLabel().getText(), getTranslation("ADDITIONAL", language));
        softAssertCreateNews.assertEquals(createNewsPage.getTitleNewsLabel().getText(), getTranslation("NEWS_TITLE", language));
        softAssertCreateNews.assertEquals(createNewsPage.getChooseTagsLabel().getText(), getTranslation("CHOOSE_TAGS", language));
//        softAssertCreateNews.assertEquals(createNewsPage.getTags().getNewsTagButton().getText(), getTranslation("NEWS_TAG", language));
//        softAssertCreateNews.assertEquals(createNewsPage.getTags().getAdsTagButton().getText(), getTranslation("ADS_TAG", language));
//        softAssertCreateNews.assertEquals(createNewsPage.getTags().getEventsTagButton().getText(), getTranslation("EVENTS_TAG", language));
//        softAssertCreateNews.assertEquals(createNewsPage.getTags().getInitiativesTagButton().getText(), getTranslation("INITIATIVES_TAG", language));
//        softAssertCreateNews.assertEquals(createNewsPage.getTags().getEducationsTagButton().getText(), getTranslation("EDUCATION_TAG", language));
        softAssertCreateNews.assertEquals(createNewsPage.getPictureLabel().getText(), getTranslation("PICTURE", language));
        softAssertCreateNews.assertEquals(createNewsPage.getChoosePictureLabel().getText(), getTranslation("CHOOSE_PICTURE", language));
        softAssertCreateNews.assertEquals(createNewsPage.getSourceLabel().getText(), getTranslation("SOURCE", language));
        softAssertCreateNews.assertEquals(createNewsPage.getContentLabel().getText(), getTranslation("CONTENT", language));
        softAssertCreateNews.assertEquals(createNewsPage.getDateLabel().getText(), getTranslation("DATE", language));
        softAssertCreateNews.assertEquals(createNewsPage.getAuthorLabel().getText(), getTranslation("AUTHOR", language));
        softAssertCreateNews.assertEquals(createNewsPage.getCancelButton().getText(), getTranslation("CANCEL", language));

        softAssertCreateNews.assertAll();
    }

    @Test(dataProvider = "languages")
    public void verifyDateAndAuthorUaRUEnPositionUnderForm(String language) {
        createNewsPage.setLanguage(language);

        Assert.assertTrue(createNewsPage.getDateLabel().getLocation().getY() > createNewsPage.getContentLabel().getLocation().getY());
        Assert.assertTrue(createNewsPage.getAuthorLabel().getLocation().getY() > createNewsPage.getContentLabel().getLocation().getY());
    }


//    @Test(dataProvider = "languages")
//    public void verifyCreateNewsTabulation(String language) {
//        createNewsPage.setLanguage(language);
//
//        SoftAssert softAssertCreateNews = new SoftAssert();
//
//        int expectedX = createNewsPage.getTitlePageLabel().getLocation().getX();
//
//        softAssertCreateNews.assertEquals(createNewsPage.getTitlePageLabel().getLocation().getX(), createNewsPage.getAdditionalLabel().getLocation().getX());
//        softAssertCreateNews.assertEquals(createNewsPage.getAdditionalLabel().getLocation().getX(), createNewsPage.getTitleNewsLabel().getLocation().getX());
//        softAssertCreateNews.assertEquals(createNewsPage.getTitleNewsLabel().getLocation().getX(), createNewsPage.getSourceLabel().getLocation().getX());
//        softAssertCreateNews.assertEquals(createNewsPage.getSourceLabel().getLocation().getX(), createNewsPage.getContentLabel().getLocation().getX());
//        softAssertCreateNews.assertEquals(createNewsPage.getDateLabel().getLocation().getX(), createNewsPage.getContentLabel().getLocation().getX());
//
//        softAssertCreateNews.assertAll();
//    }

}

