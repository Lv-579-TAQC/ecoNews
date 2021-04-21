import com.pageObject.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
                .clickEcoNews()
                .clickCreateNewsBtn()
                .setTitle(title)
                .clickTagAds()
                .setContent(content)
                .browseImage(imagePlaceOnYourComputer)
                .clickSubmitButton()
                .clickPublishButton()
                .clickEcoNews()
                .getNewsComponentContainer(false)
                .chooseNewsByNumber(0);

        String srcOfFirstNewsImage = firstNews.getNewsImage();
        String tagsOfFirstNews = firstNews.getNewsTag().getText();
        String contentOfFirstNews = firstNews.getNewsContent().getText();
        String titleOfFirstNews = firstNews.getNewsTitle().getText();

        SoftAssert softAssertForImageTest = new SoftAssert();
        softAssertForImageTest.assertNotEquals(srcOfFirstNewsImage, urlForDefault, "Image of the last news matches with default image");
        softAssertForImageTest.assertEquals(contentOfFirstNews, content, "Content don't matches");
        softAssertForImageTest.assertEquals(titleOfFirstNews, title, "Title is not same");
        softAssertForImageTest.assertEquals(tagsOfFirstNews, tags, "Tags are not correct");
        softAssertForImageTest.assertAll();
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
}
