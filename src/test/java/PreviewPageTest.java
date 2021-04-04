import com.elements.FieldElement;
import com.elements.LabelElement;
import com.pageObject.CreateNewsPO;
import com.pageObject.EcoNewsPO;
import com.pageObject.PreviewPO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PreviewPageTest {
    private static WebDriver webDriver;

    @BeforeClass
    public void setUpClass() {
        String WebDriverPath = System.getenv("WebDrivers");
//        System.setProperty("webdriver.chrome.driver", WebDriverPath + "\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "D://ChromeDriver//chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://ita-social-projects.github.io/GreenCityClient/#/");
        webDriver.findElement(By.xpath("//a[@role='sign in']")).click();
        webDriver.findElement(By.id("email")).sendKeys("lizochka1211@gmail.com");
        webDriver.findElement(By.id("password")).sendKeys("eAZAaq4X7KQQ6f6~");
        webDriver.findElement(By.xpath("//button[contains(@class, 'primary-global-button') and @type='submit']")).click();
    }

    @Test
    public void verifyPreviewTitle() {
        CreateNewsPO createNewsPage = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn();

        webDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

        createNewsPage
                .setTitle("This is title")
                .chooseNewsTag()
                .setContent("This is new test content for this page!\nThis is new test content for this page!")
                .clickPreviewButton();


        PreviewPO previewPO = new PreviewPO(webDriver);
        LabelElement textTitle = previewPO.getTitleLabel();
        LabelElement textContent = previewPO.getContentLabel();



        Assert.assertEquals(textTitle.getText(),"This is title");
        Assert.assertEquals(textContent.getText().trim(), "This is new test content for this page!\nThis is new test content for this page!".trim());
        Assert.assertTrue(previewPO.isPublishButtonExists());
    }

}
