import com.elements.LabelElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pageObject.EcoNewsPO;

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
                .getHeaderComponent()
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setSource(mainText)
                .getSourceWarningLabel();

        Assert.assertEquals(lb.getColorHex(), ExpectedColor);

    }


}






