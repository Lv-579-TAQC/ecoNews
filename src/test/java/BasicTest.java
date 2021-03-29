import com.pageObject.CreateNewsPO;
import com.pageObject.EcoNewsPO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.swing.*;

public class BasicTest {

    private static WebDriver webDriver;

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
    }
//    @AfterClass
//    public void tearDownClass(){
//        webDriver.close();
//        webDriver.quit();
//    }

    //    @Test
//    public void loginToGreenCity(){
//        webDriver.findElement(By.xpath("//a[@role='sign in']")).click();
//        webDriver.findElement(By.id("email")).sendKeys("amelyanovich11@gmail.com");
//        webDriver.findElement(By.id("password")).sendKeys("Qwerty123_");
//        webDriver.findElement(By.xpath("//button[contains(@class, 'primary-global-button') and @type='submit']")).click();
//    }
//    @Test
//    public void createNews(){
//        webDriver.findElement(By.xpath("//li[@role='eco-news']")).click();
//        Assert.assertEquals(webDriver.findElement(By.className("main-header")).getText(),"Eco news");
//        webDriver.findElement(By.id("create-button")).click();
//  }
    @Test
    public void goToCreateNews() {
        webDriver.findElement(By.xpath("//a[@role='sign in']")).click();
        webDriver.findElement(By.id("email")).sendKeys("amelyanovich11@gmail.com");
        webDriver.findElement(By.id("password")).sendKeys("Qwerty123_");
        webDriver.findElement(By.xpath("//button[contains(@class, 'primary-global-button') and @type='submit']")).click();
        CreateNewsPO createNewsPO = new EcoNewsPO(webDriver).clickEcoNews().clickCreateNewsBtn();
    }
}
