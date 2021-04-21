import com.pageObject.CreateNewsPO;
import com.pageObject.PreviewPO;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TitleFieldTest extends BasicTest {

    private String contentFieldContent = "Some text, some text, some text";

    @AfterMethod
    public void refreshPage() {
        webDriver.navigate().refresh();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isTittleMandatoryFieldOnCreateNewsPage() {
        CreateNewsPO createNewsPO = new PreviewPO(webDriver)
                .getHeaderComponent()
                .clickEcoNews()
                .clickCreateNewsBtn()
                .clickTagNews()
                .setContent(contentFieldContent);
        Assert.assertFalse(createNewsPO.isPublishButtonIsActive());
    }

    @Test
    public void isTitleMandatoryFieldOnPreviewPage() {
        PreviewPO previewPO = new CreateNewsPO(webDriver)
                .getHeaderComponent()
                .clickEcoNews()
                .clickCreateNewsBtn()
                .clickTagNews()
                .setContent(contentFieldContent)
                .clickPreviewButton();
        Assert.assertFalse(previewPO.isPublishButtonExists());
    }

    @Test(dataProvider = "fieldDataAndAppropriateHeight")
    public void isTitleFieldAutoResizable(String titleContent, String expectedTitleFieldHeight) {
        CreateNewsPO createNewsPO = new CreateNewsPO(webDriver)
                .getHeaderComponent()
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setTitle(titleContent);
        String actualTitleFieldHeight = createNewsPO.getTitleFieldHeight();
        Assert.assertEquals(actualTitleFieldHeight, expectedTitleFieldHeight);
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
                .getHeaderComponent()
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setTitle(fieldContent);
        String checkForErrorMessage = createNewsPO.getTitleFieldErrorMessage();
        Assert.assertEquals(checkForErrorMessage, expectedMessage);
        webDriver.navigate().refresh();
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