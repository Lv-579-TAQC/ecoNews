import com.pageObject.CreateNewsPO;
import com.pageObject.EcoNewsPO;
import com.pageObject.LogInPO;
import com.pageObject.PreviewPO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.xml.ws.WebEndpoint;
import java.util.List;
import java.util.Set;

public class TitleFieldTest {
    private static WebDriver webDriver;
    private static final String EMAIL = "piliphemp@gmail.com";
    private static final String PASSWORD = "@bcD1234";

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

    @Test
    public void isTittleMandatoryFieldOnCreateNewsPage() {
        CreateNewsPO createNewsPO = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn()
                .clickTagNews()
                .setContent("Some news, some news, some news");
        Assert.assertFalse(createNewsPO.clickPreviewButton().isPublishButtonExists());
    }

    @Test
    public void isTitleMandatoryFieldOnPreviewPage() {
        PreviewPO createNewsPO = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn()
                .clickEducationTag()
                .setContent("Some news, some news, some news")
                .clickPreviewButton();
        Assert.assertFalse(createNewsPO.isPublishButtonExists());
        }
    }
