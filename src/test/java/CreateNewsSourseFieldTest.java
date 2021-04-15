import com.elements.LabelElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pageObject.EcoNewsPO;
import com.pageObject.LogInPO;

public class CreateNewsSourseFieldTest {
    private final String email = "bohdan.potochniak@gmail.com";
    private final String password = "Qwertyuiop-123";
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
        webDriver.manage().window().maximize();
        LogInPO logInPO = new LogInPO(webDriver)
                .clickSignInMenuButton()
                .setEmail(email)
                .setPassword(password)
                .clickSignInButton();
    }

    @AfterClass
    public void tearDownClass() {
        webDriver.quit();
    }

    @DataProvider
    public Object[][] inCorrectDataInSourceField(){
        return new Object[][]{
                {"htps://google.com",
                        "#ff0000"}
        };
    }

    @Test(dataProvider = "inCorrectDataInSourceField")
    public void verifyThatTextInFieldCorrect(String mainText, String ExpectedColor) {
        LabelElement lb = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setSource(mainText)
                .getSourceWarningLabel();

        Assert.assertEquals(lb.getColorHex(), ExpectedColor);

    }


}






