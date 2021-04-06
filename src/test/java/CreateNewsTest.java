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

public class CreateNewsTest {
    private static WebDriver webDriver;

    @BeforeClass
    public void setUpClass() {

        String WebDriverPath = System.getenv("WebDrivers");
        System.setProperty("webdriver.chrome.driver", WebDriverPath + "\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "D://ChromeDriver//chromedriver.exe");
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
                .clickCreateNewsBtn();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        createNewsPage
                .clickLanguageDropdown()
                .clickUaButton();

        String textLabelUa = createNewsPage
                .getTitlePageLabel()
                .getText();

        Assert.assertEquals(textLabelUa, "Створити новину");

        String additionalLabelUa = createNewsPage
                .getAdditionalLabel()
                .getText();

        Assert.assertEquals(additionalLabelUa, "Будь ласка, надайте якомога більше деталей - час та місце події, мета зборів тощо. Ви можете повернутись та оновити новину в будь-який час після публікації.");

        String titleNewsLabelUa = createNewsPage
                .getTitleNewsLabel()
                .getText();

        Assert.assertEquals(titleNewsLabelUa, "Назва");

        createNewsPage.setTitle("Заголовок новини");


        TagComponent tagComponent = new TagComponent(webDriver);

        tagComponent.clickNewsTag();
        String newsTagLabelUa = tagComponent
                .getNewsTagLabel()
                .getText();
        Assert.assertEquals(newsTagLabelUa, "Події");


        String sourceFieldLabelUa = createNewsPage
                .getSourceFieldLabel()
                .getText();

        Assert.assertEquals(sourceFieldLabelUa, "Джерело (не обов'язково)");
        createNewsPage.setSource("https://www.pravda.com.ua/news/2021/04/5/7289119/");

        String contentFieldLabelUa = createNewsPage
                .getContentFieldLabel()
                .getText();

        Assert.assertEquals(contentFieldLabelUa, "Зміст");
        createNewsPage.setContent("У Державному департаменті США висловили занепокоєння через інформацію про стягнення Росією військ до українського кордону та запевнили, що підтримують Україну перед залякуваннями Кремля. ");

        String dateLabelUa = createNewsPage
                .getDateLabel()
                .getText();

        Assert.assertEquals(dateLabelUa, "Дата:");


        String authorLabelUa = createNewsPage
                .getAuthorLabel()
                .getText();

        Assert.assertEquals(authorLabelUa, "Автор:");



    }
}
