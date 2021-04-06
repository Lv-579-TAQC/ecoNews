import com.pageObject.CreateNewsPO;
import com.pageObject.EcoNewsPO;
import com.pageObject.LogInPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenPreviewPageTest {
    final String email = "amelyanovich11@gmail.com";
    final String password = "Qwerty123_";
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
        LogInPO logInPO = new LogInPO(webDriver)
                .clickSignInMenuButton()
                .setEmail(email)
                .setPassword(password)
                .clickSignInButton();
    }

    @Test
    public void verifyButtonTextInPreviewPage() {
        CreateNewsPO createNewsPage = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn()
                .clickPreviewButton();

        String textBackToEditingButton = createNewsPage
                .getBackToEditingButton()
                .getText();
        String expectedTextBackToEditingButton = "Back to editing";
        Assert.assertEquals(textBackToEditingButton, expectedTextBackToEditingButton);
    }
}
