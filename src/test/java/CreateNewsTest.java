import com.pageObject.CreateNewsPO;
import com.pageObject.EcoNewsPO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateNewsTest {
    private static WebDriver webDriver;

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

    @Test
    public void verifyCreateNewsENControllers() {
        CreateNewsPO createNewsPage = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Assert.assertEquals(createNewsPage.isCancelButtonDisplayed(), true);
       // Assert.assertEquals(createNewsPage.isPreviewButtonDisplayed(), true);
        //Assert.assertEquals(createNewsPage.isBrowseButtonDisplayed(), true);
        createNewsPage
                .clickLanguageDropdown()
                .clickUaButton();

        String textLabelUa = createNewsPage
                .getTitleLabel()
                .getText();

                //.setTitle("This is title")
                //.chooseNewsTag()
                //.chooseAdsTag()
                //.setSource("This is Source")
                //.setContent("This is content");

        Assert.assertEquals(textLabelUa,"Створити новину");
    }
}
