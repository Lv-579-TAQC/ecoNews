import com.pageObject.CreateNewsPO;
import com.pageObject.EcoNewsPO;
import com.pageObject.LogInPO;
import com.pageObject.PreviewPO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.w3c.dom.ls.LSOutput;

import javax.xml.ws.WebEndpoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class TitleFieldTest extends BasicTest {

//    @AfterTest
//    public void refreshPage() {
//        webDriver.navigate().refresh();
//    }

    @Test
    public void isTittleMandatoryFieldOnCreateNewsPage() {
        CreateNewsPO createNewsPO = new PreviewPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn()
                .clickTagNews()
                .setContent("Some news, some news, some news");
        Assert.assertFalse(createNewsPO.isPublishButtonIsActive());
    }

    @Test(dataProvider = "setOfTags")
    public void isTitleMandatoryFieldOnPreviewPage(PreviewPO obj) {
//        obj.();
    }

    @DataProvider
    public Object[][] setOfTags() {
        CreateNewsPO createNewsPO = new CreateNewsPO(webDriver);
        return new Object[][]{
                {createNewsPO.clickEcoNews().clickCreateNewsBtn().clickTagNews()},
                {createNewsPO.clickEcoNews().clickCreateNewsBtn().clickTagAds()},
                {createNewsPO.clickEcoNews().clickCreateNewsBtn().clickEventsTag()},
                {createNewsPO.clickEcoNews().clickCreateNewsBtn().clickInitiativesTag()},
                {createNewsPO.clickEcoNews().clickCreateNewsBtn().clickEducationTag()},
                {createNewsPO.clickEcoNews().clickCreateNewsBtn().clickEventsTag().clickInitiativesTag()},
                {createNewsPO.clickEcoNews().clickCreateNewsBtn().clickEducationTag().clickEducationTag()},
                {createNewsPO.clickEcoNews().clickCreateNewsBtn().clickTagNews().clickTagAds().clickEventsTag()},
                {createNewsPO.clickEcoNews().clickCreateNewsBtn().clickTagNews().clickInitiativesTag().clickEducationTag()},
                {createNewsPO.clickEcoNews().clickCreateNewsBtn().clickTagAds().clickInitiativesTag().clickEducationTag()}
        };
    }

    @Test(dataProvider = "fieldDataAndAppropriateHeight")
    public void isTitleFieldAutoResizable(String titleContent, String expectedTitleFieldHeight) {
        CreateNewsPO createNewsPO = new CreateNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setTitle(titleContent);
        String actualTitleFieldHeight = createNewsPO.getTitleFieldHeight();
        Assert.assertEquals(actualTitleFieldHeight, expectedTitleFieldHeight);
        webDriver.navigate().refresh();
        webDriver.navigate().refresh();
    }

    @DataProvider
    public Object[][] fieldDataAndAppropriateHeight() {
        return new Object[][]{
                {"Some Text", "height: 48px;"},
                {"Some Text\nSome Text", "height: 72px;"},
                {"Some Text\nSome Text\nSome Text\nSome Text", "height: 120px;"}
        };
    }

    @Test(dataProvider = "titleFieldData")
    public void ifTitleFieldCanContainMoreTha170Symbols(String fieldContent, String expectedMessage) {
        CreateNewsPO createNewsPO = new CreateNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setTitle(fieldContent);
        String checkForErrorMessage = createNewsPO.getTitleFieldErrorMessage();
        Assert.assertEquals(checkForErrorMessage, expectedMessage);
    }

    @DataProvider
    public Object[][] titleFieldData() {
        return new Object[][]{

                {"NotWalidAmountNotWalidAmountNotWalidAmountNotWalidAmountNotWalidAmountNotWalidAmountNotWalidAmount" + //171 symbols
                        "NotWalidAmountNotWalidAmountNotWalidAmountNotWalidAmountNotWalidAmountNot", "ng-invalid"},
                {"WalidAmountWalidAmountWalidAmountWalidAmountWalidAmountWalidAmountWalidAmountWalidAmountWalidAmount" +    //170 symbols
                        "WalidAmountWalidAmountWalidAmountWalidAmountWalidAmountWalidAmountWalid", "ng-valid"}

        };
    }
}