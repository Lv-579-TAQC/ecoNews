package com.pageObject;

import com.elements.ButtonElement;
import com.elements.FieldElement;
import com.elements.LabelElement;
import com.locators.CreateNewsPageLocators;
import com.locators.TagComponentLocators;
import com.tools.WaitsSwitcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateNewsPO extends BasePage {



    private FieldElement titleField;
    private FieldElement sourceField;
    private FieldElement contentField;

    private LabelElement titlePageLabel;
    private LabelElement additionalLabel;
    private LabelElement titleNewsLabel;
    private LabelElement newsTagLabel;

    private LabelElement chooseTagsLabel;
    private LabelElement pictureLabel;
    private LabelElement choosePictureLabel;
    private LabelElement sourceLabel;
    private LabelElement sourceWarningLabel;
    private LabelElement contentLabel;
    private LabelElement dateLabel;
    private LabelElement authorLabel;

    private TagComponent tags;
    private ButtonElement previewButton;
    private ButtonElement cancelButton;
    private ButtonElement publishButton;
    private ButtonElement browseButton;
    private ButtonElement submitButton;


    private WaitsSwitcher waitsSwitcher;
    private static final int SECONDS_FOR_WAITING_TAGS = 50;


    public CreateNewsPO(WebDriver driver) {
        super(driver);
        waitsSwitcher = new WaitsSwitcher(driver);
    }

    private void clear() {

        titleField = null;
        sourceField = null;
        contentField = null;

        titlePageLabel = null;
        additionalLabel = null;
        titleNewsLabel = null;
        newsTagLabel = null;

        sourceLabel = null;
        contentLabel = null;
        dateLabel = null;
        authorLabel = null;

        tags = null;
        previewButton = null;
        cancelButton = null;
        publishButton = null;
    }

    public CreateNewsPO setLanguage(String language) {
        this.clickChangeLanguage(language);
        return new CreateNewsPO(driver);
    }

    public CreateNewsPO setTitle(String title) {
        if (titleField == null) {
            titleField = new FieldElement(this.driver, CreateNewsPageLocators.TITLE_FIELD);
        }
        titleField.sendKeys(title);

        return this;
    }

    public LabelElement getTitlePageLabel() {
        if (titlePageLabel == null) {
            titlePageLabel = new LabelElement(this.driver, CreateNewsPageLocators.TITLE_PAGE_LABEL);
        }
        return titlePageLabel;

    }

    public LabelElement getAdditionalLabel() {

        if (additionalLabel == null) {
            additionalLabel = new LabelElement(this.driver, CreateNewsPageLocators.ADDITIONAL_LABEL);
        }
        return additionalLabel;

    }

    public TagComponent getTags() {
        if (tags == null) {
            tags = new TagComponent(this.driver);
        }
        return tags;
    }

    public LabelElement getChooseTagsLabel() {
        clear();
        if (chooseTagsLabel == null) {
            chooseTagsLabel = new LabelElement(this.driver, CreateNewsPageLocators.CHOOSE_TAGS_LABEL);
        }
        return chooseTagsLabel;
    }

    public LabelElement getPictureLabel() {
        clear();
        if (pictureLabel == null) {
            pictureLabel = new LabelElement(this.driver, CreateNewsPageLocators.PICTURE_LABEL);
        }
        return pictureLabel;
    }

    public LabelElement getChoosePictureLabel() {
        clear();
        if (choosePictureLabel == null) {
            choosePictureLabel = new LabelElement(this.driver, CreateNewsPageLocators.CHOOSE_PICTURE_LABEL);
        }
        return choosePictureLabel;
    }

    public LabelElement getSourceLabel() {
        clear();
        if (sourceLabel == null) {
            sourceLabel = new LabelElement(this.driver, CreateNewsPageLocators.SOURCE_LABEL);
        }
        return sourceLabel;
    }

    public LabelElement getSourceWarningLabel() {

        if (sourceWarningLabel == null) {
            sourceWarningLabel = new LabelElement(this.driver, CreateNewsPageLocators.SOURCE_FIELD_WARNING_LABEL);
        }
        return sourceWarningLabel;
    }

    public LabelElement getContentLabel() {
        clear();
        if (contentLabel == null) {
            contentLabel = new LabelElement(this.driver, CreateNewsPageLocators.CONTENT_LABEL);
        }
        return contentLabel;

    }

    public LabelElement getTitleNewsLabel() {
        clear();
        if (titleNewsLabel == null) {
            titleNewsLabel = new LabelElement(this.driver, CreateNewsPageLocators.TITLE_NEWS_LABEL);
        }
        return titleNewsLabel;
    }


    public LabelElement getDateLabel() {
        clear();
        if (dateLabel == null) {
            dateLabel = new LabelElement(this.driver, CreateNewsPageLocators.DATE_LABEL);
        }
        return dateLabel;
    }

    public LabelElement getAuthorLabel() {
        clear();
        if (authorLabel == null) {
            authorLabel = new LabelElement(this.driver, CreateNewsPageLocators.AUTHOR_LABEL);
        }
        return authorLabel;
    }

    public ButtonElement getCancelButton() {
        clear();
        if (cancelButton == null) {
            cancelButton = new ButtonElement(this.driver, CreateNewsPageLocators.CANCEL_BUTTON);
        }
        return cancelButton;

    }
    public ButtonElement getPublishButton() {
        clear();
        if (publishButton == null) {
            publishButton = new ButtonElement(this.driver, CreateNewsPageLocators.PUBLISH_BUTTON);
        }
        return publishButton;
    }
    public ButtonElement getPreviewButton() {
        clear();
        if (previewButton == null) {
            previewButton = new ButtonElement(this.driver, CreateNewsPageLocators.PREVIEW_BUTTON);
        }
        return previewButton;
    }

    public CreateNewsPO setSource(String source) {
        if (sourceField == null) {
            sourceField = new FieldElement(this.driver, CreateNewsPageLocators.SOURCE_FIELD);
        }
        sourceField.sendKeys(source);

        return this;
    }

    public CreateNewsPO setContent(String content) {
        if (contentField == null) {
            contentField = new FieldElement(this.driver, CreateNewsPageLocators.CONTENT_FIELD);
        }
        contentField.sendKeys(content);

        return this;
    }

    public PreviewPO clickPreviewButton() {
        if (previewButton == null) {
            previewButton = new ButtonElement(this.driver, CreateNewsPageLocators.PREVIEW_BUTTON);
        }
        previewButton.click();

        return new PreviewPO(driver);
    }

    public CreateNewsPO clickTagNews() {
        waitsSwitcher.setImplicitWaits(SECONDS_FOR_WAITING_TAGS);
        if (tags == null) {
            tags = new TagComponent(driver);
        }
        tags.clickNewsTag();
        return this;
    }

    public CreateNewsPO clickTagAds() {
        waitsSwitcher.setImplicitWaits(SECONDS_FOR_WAITING_TAGS);
        if (tags == null) {
            tags = new TagComponent(driver);
        }
        tags.clickAdsTag();
        return this;
    }

    public CreateNewsPO clickEventsTag() {
        waitsSwitcher.setImplicitWaits(SECONDS_FOR_WAITING_TAGS);
        if (tags == null) {
            tags = new TagComponent(driver);
        }
        tags.clickEventsTag();
        return this;
    }

    public CreateNewsPO clickInitiativesTag() {
        waitsSwitcher.setImplicitWaits(SECONDS_FOR_WAITING_TAGS);
        if (tags == null) {
            tags = new TagComponent(driver);
        }
        tags.clickInitiativesTag();
        return this;
    }

    public CreateNewsPO clickEducationTag() {
        waitsSwitcher.setImplicitWaits(SECONDS_FOR_WAITING_TAGS);
        if (tags == null) {
            tags = new TagComponent(driver);
        }
        tags.clickEducationTag();
        return this;
    }
    public CreateNewsPO browseImage(String img){
        waitsSwitcher.setImplicitWaits(100);
        if (browseButton == null) {
            browseButton = new ButtonElement(this.driver, CreateNewsPageLocators.BROWSE_PICTURE_BUTTON);
        }
        browseButton.sendKeys(img);
        return this;
    }
    public CreateNewsPO clickSubmitButton() {
        waitsSwitcher.setImplicitWaits(100);
        if ( submitButton == null) {
            submitButton = new ButtonElement(this.driver, CreateNewsPageLocators.SUBMIT_BUTTON);
        }
        submitButton.click();

        return new CreateNewsPO(driver);
    }
    public EcoNewsPO clickPublishButton() {
        waitsSwitcher.setImplicitWaits(100);
        if ( publishButton == null) {
            publishButton = new ButtonElement(this.driver, CreateNewsPageLocators.PUBLISH_BUTTON);
        }
        publishButton.click();

        return new EcoNewsPO(driver);
    }
    public boolean isEventsTagIsActive(){
        return driver.findElement(TagComponentLocators.EVENTS_TAGBUTTON.getPath()).getAttribute("class").contains("filters-color");
    }
    public boolean isNewsTagIsActive(){
        return driver.findElement(TagComponentLocators.NEWS_TAGBUTTON.getPath()).getAttribute("class").contains("filters-color");
    }
    public boolean isEducationTagIsActive(){
        return driver.findElement(TagComponentLocators.EDUCATION_TAGBUTTON.getPath()).getAttribute("class").contains("filters-color");
    }
    public boolean isInitiativesTagIsActive(){
        return driver.findElement(TagComponentLocators.INITIATIVES_TAGBUTTON.getPath()).getAttribute("class").contains("filters-color");

    }
    public boolean isAdsTagIsActive(){
        return driver.findElement(TagComponentLocators.ADS_TAGBUTTON.getPath()).getAttribute("class").contains("filters-color");
    }
    public boolean isSignUnderTagsMakingWarning(){
        return driver.findElement(TagComponentLocators.SIGN_UNDER_TAGS.getPath()).getAttribute("class").contains("warning");
    }
}