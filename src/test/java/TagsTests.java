import com.pageObject.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TagsTests extends BasicTest {

    @Test
    public void verifyWeCannotUseMoreThanThreeTags() {
        CreateNewsPO warning = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn()
                .clickTagNews()
                .clickTagAds()
                .clickInitiativesTag()
                .clickEducationTag()
                .clickEventsTag();

        SoftAssert asert = new SoftAssert();
        asert.assertTrue(warning.isNewsTagIsActive(), "News tag is not active, but should be");
        asert.assertFalse(warning.isEducationTagIsActive(), "Education tag is active, but should not be");
        asert.assertTrue(warning.isInitiativesTagIsActive(), "Initiative tag is not active, but should be");
        asert.assertTrue(warning.isAdsTagIsActive(), "Ads tag is not active, but should not be");
        asert.assertFalse(warning.isEventsTagIsActive(), "Ads tag is active, but should be");
        asert.assertTrue(warning.isSignUnderTagsMakingWarning(), "Warning sign was not shown");
        asert.assertAll();
    }

    @Test(dataProvider = "notValidValuesToCreateNews")
    public void verifyWeCannotCreateNewsWithoutTags(String title, String content) {
        CreateNewsPO creatingNewsWithoutTags = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setTitle(title)
                .setContent(content);

        Assert.assertFalse(creatingNewsWithoutTags.isPublishButtonIsActive(), "Publish button is active, but should not be active");
    }

    @DataProvider()
    public Object[][] notValidValuesToCreateNews() {
        return new Object[][]{
                {"Wow, this is example of new news",
                        "This content for test example new news"}
        };
    }
}
