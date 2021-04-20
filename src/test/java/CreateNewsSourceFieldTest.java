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

public class CreateNewsSourceFieldTest extends BasicTest{

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






