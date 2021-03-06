import com.pageObject.LogInPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BasicTest {

    private final String EMAIL = "howiv47374@nenekbet.com";
    private final String PASSWORD = "Test-User123";
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
        webDriver.manage().window().maximize();
        webDriver.get("https://ita-social-projects.github.io/GreenCityClient/#/");
        new LogInPO(webDriver)
                .getHeaderComponent()
                .clickSignInMenuButton()
                .setEmail(EMAIL)
                .setPassword(PASSWORD)
                .clickSignInButton();
    }

    @AfterClass
    public void closeUp() {
        webDriver.close();
        webDriver.quit();
    }
}
