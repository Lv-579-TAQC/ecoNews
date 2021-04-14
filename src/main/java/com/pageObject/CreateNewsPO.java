package com.pageObject;

import com.elements.ButtonElement;
import com.elements.FieldElement;
import com.elements.LabelElement;
import com.locators.CreateNewsPageLocators;
import com.tools.WaitsSwitcher;
import org.openqa.selenium.WebDriver;


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
    private LabelElement contentLabel;
    private LabelElement dateLabel;
    private LabelElement authorLabel;

    private TagComponent tags;
    private ButtonElement previewButton;
    private ButtonElement cancelButton;
    private ButtonElement publishButton;

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

        if (chooseTagsLabel == null) {
            chooseTagsLabel = new LabelElement(this.driver, CreateNewsPageLocators.CHOOSE_TAGS_LABEL);
        }
        return chooseTagsLabel;
    }

    public LabelElement getPictureLabel() {

        if (pictureLabel == null) {
            pictureLabel = new LabelElement(this.driver, CreateNewsPageLocators.PICTURE_LABEL);
        }
        return pictureLabel;
    }

    public LabelElement getChoosePictureLabel() {

        if (choosePictureLabel == null) {
            choosePictureLabel = new LabelElement(this.driver, CreateNewsPageLocators.CHOOSE_PICTURE_LABEL);
        }
        return choosePictureLabel;
    }

    public LabelElement getSourceLabel() {

        if (sourceLabel == null) {
            sourceLabel = new LabelElement(this.driver, CreateNewsPageLocators.SOURCE_LABEL);
        }
        return sourceLabel;
    }

    public LabelElement getContentLabel() {
        if (contentLabel == null) {
            contentLabel = new LabelElement(this.driver, CreateNewsPageLocators.CONTENT_LABEL);
        }
        return contentLabel;

    }

    public LabelElement getTitleNewsLabel() {
        if (titleNewsLabel == null) {
            titleNewsLabel = new LabelElement(this.driver, CreateNewsPageLocators.TITLE_NEWS_LABEL);
        }
        return titleNewsLabel;
    }


    public LabelElement getDateLabel() {
        if (dateLabel == null) {
            dateLabel = new LabelElement(this.driver, CreateNewsPageLocators.DATE_LABEL);
        }
        return dateLabel;
    }

    public LabelElement getAuthorLabel() {
        if (authorLabel == null) {
            authorLabel = new LabelElement(this.driver, CreateNewsPageLocators.AUTHOR_LABEL);
        }
        return authorLabel;
    }

    public ButtonElement getCancelButton() {
        if (cancelButton == null) {
            cancelButton = new ButtonElement(this.driver, CreateNewsPageLocators.CANCEL_BUTTON);
        }
        return cancelButton;

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
}
