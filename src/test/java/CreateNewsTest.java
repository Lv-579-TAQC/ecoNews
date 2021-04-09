import com.pageObject.CreateNewsPO;
import com.pageObject.EcoNewsPO;
import com.pageObject.TagComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class CreateNewsTest {
    private static WebDriver webDriver;
    final String TITLE = "Створити новину";
    final String ADDITIONAL = "Будь ласка, надайте якомога більше деталей - час та місце події, мета зборів тощо. Ви можете повернутись та оновити новину в будь-який час після публікації.";
    final String NEWS_TITLE ="Назва";
    final String SOURCE = "Джерело (не обов'язково)";
    final String CONTENT = "Зміст";
    final String DATE = "Дата:";
    final String AUTHOR = "Автор:";
    final String NEWS_TAG = "Події";


    @BeforeClass
    public void setUpClass() {

        String WebDriverPath = System.getenv("WebDrivers");
        System.setProperty("webdriver.chrome.driver", WebDriverPath + "\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://ita-social-projects.github.io/GreenCityClient/#/");
        webDriver.findElement(By.xpath("//a[@role='sign in']")).click();
        webDriver.findElement(By.id("email")).sendKeys("amelyanovich11@gmail.com");
        webDriver.findElement(By.id("password")).sendKeys("Qwerty123_");
        webDriver.findElement(By.xpath("//button[contains(@class, 'primary-global-button') and @type='submit']")).click();
    }

    @AfterClass
    public void tearDownClass(){
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
        softAssertCreateNews.assertEquals(createNewsPage.getTitlePageLabel().getText(), TITLE);
        softAssertCreateNews.assertEquals(createNewsPage.getAdditionalLabel().getText(), ADDITIONAL);
        softAssertCreateNews.assertEquals(createNewsPage.getTitleNewsLabel().getText(), NEWS_TITLE);
        softAssertCreateNews.assertEquals(createNewsPage.getTags().getNewsTagButton().getText(), NEWS_TAG);
        softAssertCreateNews.assertEquals(createNewsPage.getSourceFieldLabel().getText(), SOURCE);
        softAssertCreateNews.assertEquals(createNewsPage.getContentFieldLabel().getText(), CONTENT);
        softAssertCreateNews.assertEquals(createNewsPage.getDateLabel().getText(), DATE);
        softAssertCreateNews.assertEquals(createNewsPage.getAuthorLabel().getText(), AUTHOR);

        softAssertCreateNews.assertAll();

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
}
