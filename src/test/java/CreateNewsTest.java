import com.locators.CreateNewsPageLocators;
import com.pageObject.CreateNewsPO;
import com.pageObject.EcoNewsPO;
import com.pageObject.LogInPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class CreateNewsTest {
    private static WebDriver webDriver;
    final String EMAIL = "bilobram.v@ukr.net";
    final String PASSWORD = "8428665Bilobramlfml.";
    final String PAGE_TITLE = "Створити новину";
    final String ADDITIONAL = "Будь ласка, надайте якомога більше деталей - час та місце події, мета зборів тощо. Ви можете повернутись та оновити новину в будь-який час після публікації.";
    final String NEWS_TITLE = "Назва";
    final String CHOOSE_TAGS = "Будь ласка, оберіть один чи більше тегів";
    final String PICTURE ="Зображення (не обов'язково)";
    final String CHOOSE_PICTURE = "Перетягніть зображення сюди або огляд";
    final String SOURCE = "Джерело (не обов'язково)";
    final String CONTENT = "Зміст";
    final String DATE = "Дата:";
    final String AUTHOR = "Автор:";
    final String NEWS_TAG = "Події";
    final String ADS_TAG = "Ініціативи";
    final String EVENTS_TAG = "Освіта";
    final String INITIATIVES_TAG = "Новини";
    final String EDUCATION_TAG = "Реклама";


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
    }

    @AfterClass
    public void tearDownClass() {
        webDriver.quit();
    }

    @Test
    public void verifyCreateNewsUAControllers() {

        CreateNewsPO createNewsPage = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn()
                .clickLanguageDropdown()
                .clickUaButton();

        SoftAssert softAssertCreateNews = new SoftAssert();

        softAssertCreateNews.assertEquals(createNewsPage.getTitlePageLabel().getText(), PAGE_TITLE);
        softAssertCreateNews.assertEquals(createNewsPage.getAdditionalLabel().getText(), ADDITIONAL);
        softAssertCreateNews.assertEquals(createNewsPage.getTitleNewsLabel().getText(), NEWS_TITLE);
        softAssertCreateNews.assertEquals(createNewsPage.getChooseTagsLabel().getText(), CHOOSE_TAGS);
        softAssertCreateNews.assertEquals(createNewsPage.getTags().getNewsTagButton().getText(), NEWS_TAG);
        softAssertCreateNews.assertEquals(createNewsPage.getTags().getAdsTagButton().getText(), ADS_TAG);
        softAssertCreateNews.assertEquals(createNewsPage.getTags().getEventsTagButton().getText(), EVENTS_TAG);
        softAssertCreateNews.assertEquals(createNewsPage.getTags().getInitiativesTagButton().getText(), INITIATIVES_TAG);
        softAssertCreateNews.assertEquals(createNewsPage.getTags().getEducationsTagButton().getText(), EDUCATION_TAG);
        softAssertCreateNews.assertEquals(createNewsPage.getPictureLabel().getText(), PICTURE);
        softAssertCreateNews.assertEquals(createNewsPage.getChoosePictureLabel().getText(), CHOOSE_PICTURE);
        softAssertCreateNews.assertEquals(createNewsPage.getSourceLabel().getText(), SOURCE);
        softAssertCreateNews.assertEquals(createNewsPage.getContentLabel().getText(), CONTENT);
        softAssertCreateNews.assertEquals(createNewsPage.getDateLabel().getText(), DATE);
        softAssertCreateNews.assertEquals(createNewsPage.getAuthorLabel().getText(), AUTHOR);


        int expectedX = createNewsPage.getTitlePageLabel().getLocation().getX();

        softAssertCreateNews.assertEquals(createNewsPage.getTitlePageLabel().getLocation().getX(), createNewsPage.getAdditionalLabel().getLocation().getX());
        softAssertCreateNews.assertEquals(createNewsPage.getAdditionalLabel().getLocation().getX(), createNewsPage.getTitleNewsLabel().getLocation().getX());
        softAssertCreateNews.assertEquals(createNewsPage.getTitleNewsLabel().getLocation().getX(), createNewsPage.getSourceLabel().getLocation().getX());
        softAssertCreateNews.assertEquals(createNewsPage.getSourceLabel().getLocation().getX(), createNewsPage.getContentLabel().getLocation().getX());
        softAssertCreateNews.assertEquals(createNewsPage.getDateLabel().getLocation().getX(), createNewsPage.getContentLabel().getLocation().getX());

        softAssertCreateNews.assertAll();
    }

    @Test
    public void verifyDateAndAuthorUaPositionUnderForm() {
        CreateNewsPO createNewsPage = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn()
                .clickLanguageDropdown()
                .clickUaButton();

        Assert.assertTrue(createNewsPage.getDateLabel().getLocation().getY() > createNewsPage.getContentLabel().getLocation().getY());
        Assert.assertTrue(createNewsPage.getAuthorLabel().getLocation().getY() > createNewsPage.getContentLabel().getLocation().getY());
    }

    @Test
    public void verifyDateAndAuthorRuPositionUnderForm() {
        CreateNewsPO createNewsPage = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn()
                .clickLanguageDropdown()
                .clickRuButton();

        Assert.assertTrue(createNewsPage.getDateLabel().getLocation().getY() > createNewsPage.getContentLabel().getLocation().getY());
        Assert.assertTrue(createNewsPage.getAuthorLabel().getLocation().getY() > createNewsPage.getContentLabel().getLocation().getY());
    }

    @Test
    public void verifyDateAndAuthorEnPositionUnderForm() {
        CreateNewsPO createNewsPage = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn()
                .clickLanguageDropdown()
                .clickEnButton();

        Assert.assertTrue(createNewsPage.getDateLabel().getLocation().getY() > createNewsPage.getContentLabel().getLocation().getY());
        Assert.assertTrue(createNewsPage.getAuthorLabel().getLocation().getY() > createNewsPage.getContentLabel().getLocation().getY());
    }


//        String textLabelUa = createNewsPage
//                .getTitlePageLabel()
//                .getText();

    //Assert.assertEquals(textLabelUa, TITLE);

//        String additionalLabelUa = createNewsPage
//                .getAdditionalLabel()
//                .getText();

    //Assert.assertEquals(additionalLabelUa, ADDITIONAL);

//        String titleNewsLabelUa = createNewsPage
//                .getTitleNewsLabel()
//                .getText();

    //Assert.assertEquals(titleNewsLabelUa, NEWS_TITLE);

    //createNewsPage.setTitle("Заголовок новини");


    //TagComponent tagComponent = new TagComponent(webDriver);

    //tagComponent.clickNewsTag();

//        String newsTagLabelUa = tagComponent
//                .getNewsTagLabel()
//                .getText();
//        Assert.assertEquals(newsTagLabelUa, NEWS_TAG);


//        String sourceFieldLabelUa = createNewsPage
//                .getSourceFieldLabel()
//                .getText();

    //Assert.assertEquals(sourceFieldLabelUa, SOURCE);
    //createNewsPage.setSource("https://www.pravda.com.ua/news/2021/04/5/7289119/");

//        String contentFieldLabelUa = createNewsPage
//                .getContentFieldLabel()
//                .getText();

    //Assert.assertEquals(contentFieldLabelUa, CONTENT);
    //createNewsPage.setContent("У Державному департаменті США висловили занепокоєння через інформацію про стягнення Росією військ до українського кордону та запевнили, що підтримують Україну перед залякуваннями Кремля. ");

//        String dateLabelUa = createNewsPage
//                .getDateLabel()
//                .getText();

    //Assert.assertEquals(dateLabelUa, DATE);

//        String authorLabelUa = createNewsPage
//                .getAuthorLabel()
//                .getText();

    //Assert.assertEquals(authorLabelUa, AUTHOR);

}

