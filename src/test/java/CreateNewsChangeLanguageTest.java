import com.pageObject.ChangeLanguageComponent;
import com.pageObject.CreateNewsPO;
import com.pageObject.EcoNewsPO;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Properties;

public class CreateNewsChangeLanguageTest extends BasicTest {

    private CreateNewsPO createNewsPage;
    Locale rus = new Locale("ru", "RU");
    Locale uk = new Locale("uk", "UA");

    public String getCurrentDate(String pattern,Locale locale) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern, locale);
        LocalDate localDate = LocalDate.now();
        return dtf.format(localDate);
    }

    public String getTranslation(String key, String language) {
        Properties prop = new Properties();
        FileInputStream input = null;
        try {
            input = new FileInputStream("src/main/resources/languages/" + language + ".properties");
            prop.load(new InputStreamReader(input, StandardCharsets.UTF_8));
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }

    @BeforeMethod
    public void beforeMethod() {
        createNewsPage = new EcoNewsPO(webDriver)
                .getHeaderComponent()
                .clickEcoNews()
                .clickCreateNewsBtn();
    }

    @DataProvider(name = "dates")
    public Object[][] dates() {
        return new Object[][]{
                {"ua","dd MMM yyyy р.", uk},
                {"en","dd MMM, yyyy", Locale.ENGLISH},
                {"ru","dd MMM. yyyy г.", rus}
        };
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
    public void verifyCreateNewsPageUaEnRuTranslation(String language) {
        createNewsPage.setLanguage(language);

        SoftAssert softAssertCreateNews = new SoftAssert();

        softAssertCreateNews.assertEquals(createNewsPage.getTitlePageLabel().getText(), getTranslation("PAGE_TITLE", language),"The translation of page title is not correct");
        softAssertCreateNews.assertEquals(createNewsPage.getAdditionalLabel().getText(), getTranslation("ADDITIONAL", language),"The translation of additional text under page title is not correct");
        softAssertCreateNews.assertEquals(createNewsPage.getTitleNewsLabel().getText(), getTranslation("NEWS_TITLE", language),"The translation of news title is not correct");
        softAssertCreateNews.assertEquals(createNewsPage.getPictureLabel().getText(), getTranslation("PICTURE", language),"The translation of news title is not correct");
        softAssertCreateNews.assertEquals(createNewsPage.getChoosePictureLabel().getText(), getTranslation("CHOOSE_PICTURE", language),"The translation of news title is not correct");
        softAssertCreateNews.assertEquals(createNewsPage.getSourceLabel().getText(), getTranslation("SOURCE", language),"The translation of 'Source' label is not correct");
        softAssertCreateNews.assertEquals(createNewsPage.getContentLabel().getText(), getTranslation("CONTENT", language),"The translation of 'Content' label is not correct");
        softAssertCreateNews.assertEquals(createNewsPage.getDateLabel().getText(), getTranslation("DATE", language),"The translation of 'Date:' label is not correct");
        softAssertCreateNews.assertEquals(createNewsPage.getAuthorLabel().getText(), getTranslation("AUTHOR", language),"The translation of 'Author:' label is not correct");
        softAssertCreateNews.assertEquals(createNewsPage.getChooseTagsLabel().getText(), getTranslation("CHOOSE_TAGS", language),"The translation of 'Choose tags' message is not correct");
        softAssertCreateNews.assertEquals(createNewsPage.getTags().getNewsTagButton().getText(), getTranslation("NEWS_TAG", language),"The translation of 'News' tag is not correct");
        softAssertCreateNews.assertEquals(createNewsPage.getTags().getAdsTagButton().getText(), getTranslation("ADS_TAG", language),"The translation of 'Ads' tag is not correct");
        softAssertCreateNews.assertEquals(createNewsPage.getTags().getEventsTagButton().getText(), getTranslation("EVENTS_TAG", language),"The translation of 'Events' tag is not correct");
        softAssertCreateNews.assertEquals(createNewsPage.getTags().getInitiativesTagButton().getText(), getTranslation("INITIATIVES_TAG", language),"The translation of 'Initiatives' tag is not correct");
        softAssertCreateNews.assertEquals(createNewsPage.getTags().getEducationsTagButton().getText(), getTranslation("EDUCATION_TAG", language),"The translation of 'Education' tag is not correct");
        softAssertCreateNews.assertEquals(createNewsPage.getCancelButton().getText(), getTranslation("CANCEL", language),"The translation of 'cancel' button is not correct");
        softAssertCreateNews.assertEquals(createNewsPage.getPublishButton().getText(), getTranslation("PUBLISH", language),"The translation of 'publish' button is not correct");
        softAssertCreateNews.assertEquals(createNewsPage.getPreviewButton().getText(), getTranslation("PREVIEW", language),"The translation of 'preview' button is not correct");
        softAssertCreateNews.assertAll();
    }

    @Test(dataProvider = "languages")
    public void verifyDateAndAuthorLabelPositionUnderForm(String language) {
        createNewsPage.setLanguage(language);

        int theLowestLabelOnTheForm = createNewsPage.getContentMassegeLabel().getLocation().getY();

        Assert.assertTrue(createNewsPage.getDateAndAuthorAreaLabel().getLocation().getY() > theLowestLabelOnTheForm,"The date and author aren't under the form 'Create news'");
    }

    @Test(dataProvider = "dates")
    public void verifyCurrentDateAndCreateNewsDate(String language,String pattern,Locale locale) {
        createNewsPage.setLanguage(language);

        Assert.assertEquals(createNewsPage.getCurrentDateLabel().getText(), getCurrentDate(pattern,locale),"The date of creating news and today's date aren't the same");
    }

    @Test(dataProvider = "languages")
    public void verifyUserNameAndAuthorLabel(String language) {
        createNewsPage.setLanguage(language);

        Assert.assertEquals(createNewsPage.getAuthorNameLabel().getText(), createNewsPage.getHeaderComponent().getUserName().getText(),"The author of news and User Name aren't the same");
    }
}

