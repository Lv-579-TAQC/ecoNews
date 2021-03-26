package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicTest {

    private WebDriver webDriver;
    @Test
    public void isTest(){

    }
    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://ita-social-projects.github.io/GreenCityClient/#/");
    }
//    @AfterTest
    public void cleanUp(){
    if (webDriver != null)
        webDriver.quit();
    }

    @Test
    public void loginToGreenCity(){
        webDriver.findElement(By.xpath("//a[@role='sign in']")).click();
        webDriver.findElement(By.id("email")).sendKeys("amelyanovich11@gmail.com");
        webDriver.findElement(By.id("password")).sendKeys("Qwerty123_");
        webDriver.findElement(By.xpath("//button[contains(@class, 'primary-global-button') and @type='submit']")).click();
    }
    @Test
    public void createNews(){
        webDriver.findElement(By.xpath("//li[@role='eco-news']")).click();
        Assert.assertEquals(webDriver.findElement(By.className("main-header")).getText(),"Eco news");
//        webDriver.findElement(By.id("create-button")).click();
    }
}
