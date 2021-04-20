import com.pageObject.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TagsTests extends BasicTest{

    @Test
    public void verifyWeCannotUseMoreThanThreeTags(){
        CreateNewsPO warning = new EcoNewsPO(webDriver)
                .clickEcoNews()
                .clickCreateNewsBtn()
                .clickTagNews()
                .clickTagAds()
                .clickInitiativesTag()
                .clickEducationTag()
                .clickEventsTag();

        SoftAssert asert = new SoftAssert();
        asert.assertEquals(warning.isNewsTagIsActive(), true,"News tag is not active");
        asert.assertEquals(warning.isEducationTagIsActive(), false,"Education tag is active");
        asert.assertEquals(warning.isInitiativesTagIsActive(), true,"Initiative tag is not active");
        asert.assertEquals(warning.isAdsTagIsActive(), true,"Ads tag is not active");
        asert.assertEquals(warning.isEventsTagIsActive(), false,"Ads tag is active");
        asert.assertEquals(warning.isSignUnderTagsMakingWarning(),true,"Warning sign was not shown");
        asert.assertAll();
    }
}
