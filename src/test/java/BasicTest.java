import com.pageObject.LogInPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BasicTest {

    final String email = "amelyanovich11@gmail.com";
    final String password = "Qwerty123_";
    protected static WebDriver webDriver;

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

    @AfterClass
    public void tearDownClass(){
        webDriver.quit();
    }
}
