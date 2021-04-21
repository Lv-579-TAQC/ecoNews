import com.pageObject.CreateNewsPO;
import com.pageObject.EcoNewsPO;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Properties;

public class CreateNewsChangeLanguageTest extends BasicTest {

    private CreateNewsPO createNewsPage;
    Locale rus = new Locale("ru", "RU");
    Locale uk = new Locale("uk", "UA");

    public String getCurrentDateEN() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM, yyyy", Locale.ENGLISH);
        LocalDate localDate = LocalDate.now();
        return dtf.format(localDate);
    }

    public String getCurrentDateRU() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM. yyyy г.", rus);
        LocalDate localDate = LocalDate.now();
        return dtf.format(localDate);
    }

    public String getCurrentDateUA() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy р.", uk);
        LocalDate localDate = LocalDate.now();
        return dtf.format(localDate);
    }

    public String getTranslation(String key, String language) throws IOException {
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream("src/main/resources/languages/" + language + ".properties");
        prop.load(new InputStreamReader(input, "UTF-8"));
        input.close();
        return prop.getProperty(key);
    }

    @BeforeMethod
    public void beforeMethod() {
        createNewsPage = new EcoNewsPO(webDriver)
                .getHeaderComponent()
                .clickEcoNews()
                .clickCreateNewsBtn();
    }

    @DataProvider(name = "languages")
    public Object[][] languages() {
        return new Object[][]{
                {"ua"},
                {"en"},
                {"ru"}
        };
    }

    @Test(dataProvider = "languages")
    public void verifyCreateNewsPageUaEnRuTranslation(String language) throws IOException {
        createNewsPage.setLanguage(language);

        SoftAssert softAssertCreateNews = new SoftAssert();

        softAssertCreateNews.assertEquals(createNewsPage.getTitlePageLabel().getText(), getTranslation("PAGE_TITLE", language));
        softAssertCreateNews.assertEquals(createNewsPage.getAdditionalLabel().getText(), getTranslation("ADDITIONAL", language));
        softAssertCreateNews.assertEquals(createNewsPage.getTitleNewsLabel().getText(), getTranslation("NEWS_TITLE", language));
        softAssertCreateNews.assertEquals(createNewsPage.getPictureLabel().getText(), getTranslation("PICTURE", language));
        softAssertCreateNews.assertEquals(createNewsPage.getChoosePictureLabel().getText(), getTranslation("CHOOSE_PICTURE", language));
        softAssertCreateNews.assertEquals(createNewsPage.getSourceLabel().getText(), getTranslation("SOURCE", language));
        softAssertCreateNews.assertEquals(createNewsPage.getContentLabel().getText(), getTranslation("CONTENT", language));
        softAssertCreateNews.assertEquals(createNewsPage.getDateLabel().getText(), getTranslation("DATE", language));
        softAssertCreateNews.assertEquals(createNewsPage.getAuthorLabel().getText(), getTranslation("AUTHOR", language));
        softAssertCreateNews.assertEquals(createNewsPage.getChooseTagsLabel().getText(), getTranslation("CHOOSE_TAGS", language));
        softAssertCreateNews.assertEquals(createNewsPage.getTags().getNewsTagButton().getText(), getTranslation("NEWS_TAG", language));
        softAssertCreateNews.assertEquals(createNewsPage.getTags().getAdsTagButton().getText(), getTranslation("ADS_TAG", language));
        softAssertCreateNews.assertEquals(createNewsPage.getTags().getEventsTagButton().getText(), getTranslation("EVENTS_TAG", language));
        softAssertCreateNews.assertEquals(createNewsPage.getTags().getInitiativesTagButton().getText(), getTranslation("INITIATIVES_TAG", language));
        softAssertCreateNews.assertEquals(createNewsPage.getTags().getEducationsTagButton().getText(), getTranslation("EDUCATION_TAG", language));
        softAssertCreateNews.assertEquals(createNewsPage.getCancelButton().getText(), getTranslation("CANCEL", language));
        softAssertCreateNews.assertEquals(createNewsPage.getPublishButton().getText(), getTranslation("PUBLISH", language));
        softAssertCreateNews.assertEquals(createNewsPage.getPreviewButton().getText(), getTranslation("PREVIEW", language));

        softAssertCreateNews.assertAll();
    }

    @Test(dataProvider = "languages")
    public void verifyDateAndAuthorLabelPositionUnderForm(String language) {
        createNewsPage.setLanguage(language);
        int theLowestLabelOnTheForm = createNewsPage.getContentLabel().getLocation().getY();

        Assert.assertTrue(createNewsPage.getDateLabel().getLocation().getY() > theLowestLabelOnTheForm);
        Assert.assertTrue(createNewsPage.getCurrentDateLabel().getLocation().getY() > theLowestLabelOnTheForm);
        Assert.assertTrue(createNewsPage.getAuthorLabel().getLocation().getY() > theLowestLabelOnTheForm);
        Assert.assertTrue(createNewsPage.getAuthorNameLabel().getLocation().getY() > theLowestLabelOnTheForm);
    }

    @Test
    public void verifyCurrentDateEN() {
        createNewsPage.setLanguage("en");
        Assert.assertEquals(createNewsPage.getCurrentDateLabel().getText(), getCurrentDateEN());
    }

    @Test
    public void verifyCurrentDateUA() {
        createNewsPage.setLanguage("ua");

        Assert.assertEquals(createNewsPage.getCurrentDateLabel().getText(), getCurrentDateUA());
    }

    @Test
    public void verifyCurrentDateRU() {
        createNewsPage.setLanguage("ru");

        Assert.assertEquals(createNewsPage.getCurrentDateLabel().getText(), getCurrentDateRU());
    }

    @Test(dataProvider = "languages")
    public void verifyUsernameAndAuthorLabel(String language) {
        createNewsPage.setLanguage(language);
        String expectedAuthor = createNewsPage.getHeaderComponent().getUserName().getText();

        Assert.assertEquals(createNewsPage.getAuthorNameLabel().getText(), expectedAuthor);
    }

    @Test(dataProvider = "languages")
    public void verifyCreateNewsPageMainElementsPosition(String language) {
        createNewsPage.setLanguage(language);

        SoftAssert softAssertCreateNews = new SoftAssert();

        int expectedX = createNewsPage.getTitlePageLabel().getLocation().getX();

        softAssertCreateNews.assertEquals(expectedX, createNewsPage.getAdditionalLabel().getLocation().getX());
        softAssertCreateNews.assertEquals(expectedX, createNewsPage.getTitleNewsLabel().getLocation().getX());
        softAssertCreateNews.assertEquals(expectedX, createNewsPage.getSourceLabel().getLocation().getX());
        softAssertCreateNews.assertEquals(expectedX, createNewsPage.getContentLabel().getLocation().getX());
        softAssertCreateNews.assertEquals(expectedX, createNewsPage.getContentLabel().getLocation().getX());

        softAssertCreateNews.assertAll();
    }

}

