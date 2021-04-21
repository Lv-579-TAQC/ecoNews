import com.pageObject.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;

public class AddImageTest extends BasicTest{

    @Test (dataProvider  = "validValuesToCreateNews")
    public void verifyCreatingNewsWithImage(String title, String content, String urlForDefault, String tags) {
        File file = new File("src/main/resources/Images/29072.png");
        final String imagePlaceOnYourComputer = file.getAbsolutePath();

        NewsComponent firstNews = new EcoNewsPO(webDriver)
                .getHeaderComponent()
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setTitle(title)
                .clickTagAds()
                .setContent(content)
                .browseImage(imagePlaceOnYourComputer)
                .clickSubmitButton()
                .clickPublishButton()
                .getHeaderComponent()
                .clickEcoNews()
                .getNewsComponentContainer(false)
                .chooseNewsByNumber(0);

        String srcOfFirstNewsImage = firstNews.getNewsImage();
        String tagsOfFirstNews = firstNews.getNewsTag().getText();
        String contentOfFirstNews = firstNews.getNewsContent().getText();
        String titleOfFirstNews = firstNews.getNewsTitle().getText();

        SoftAssert softAssertForImageTestValid = new SoftAssert();
        softAssertForImageTestValid.assertNotEquals(srcOfFirstNewsImage, urlForDefault, "Image of the last news matches with default image");
        softAssertForImageTestValid.assertEquals(contentOfFirstNews, content, "Content don't matches");
        softAssertForImageTestValid.assertEquals(titleOfFirstNews, title, "Title is not same");
        softAssertForImageTestValid.assertEquals(tagsOfFirstNews, tags, "Tags are not correct");
        softAssertForImageTestValid.assertAll();
    }
    @DataProvider()
    public Object[][] validValuesToCreateNews(){
        return new Object[][]{
                {"Wow, this is example of new news",
                        "This content for test example new news",
                "https://ita-social-projects.github.io/GreenCityClient/assets/img/icon/econews/default-image-list-view.png",
                "ADS"}
        };
    }
    @Test
    public void verifyWeCannotDownloadIncorrectImage(){
        File file = new File("src/main/resources/languages/en.properties");
        final String fileOnYourComputer = file.getAbsolutePath();
        CreateNewsPO warningOnImage = new EcoNewsPO(webDriver)
                .getHeaderComponent()
                .clickEcoNews()
                .clickCreateNewsBtn()
                .browseImage(fileOnYourComputer);

        SoftAssert softAssertForImageTestInvalid = new SoftAssert();
        softAssertForImageTestInvalid.assertTrue(warningOnImage.isSignOnImagePleaseAppears(), "Sign \"Image isn't uploaded\" is not appears");
        softAssertForImageTestInvalid.assertTrue(warningOnImage.isSignUnderImageMakingWarning(), "Warning in sign under image upload is not creating");
        softAssertForImageTestInvalid.assertTrue(warningOnImage.isBackGroundOnImagePlaceMakingWarning(), "Background on image place is not create warning");
        softAssertForImageTestInvalid.assertAll();
    }
}
