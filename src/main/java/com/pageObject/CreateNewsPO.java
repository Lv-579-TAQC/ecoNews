package com.pageObject;

import com.elements.ButtonElement;
import com.elements.FieldElement;
import com.elements.LabelElement;
import com.locators.CreateNewsPageLocators;
import com.locators.EcoNewsPageLocators;
import com.tools.WaitsSwitcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class CreateNewsPO extends BasePage {
    private WaitsSwitcher waitsSwitcher;

    private ButtonElement languageDropdown;
    private ButtonElement uaButton;
    private ButtonElement enButton;
    private ButtonElement ruButton;

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
    private LabelElement dateLabel ;
    private LabelElement authorLabel;

    private TagComponent tags;
    private ButtonElement previewButton;

    private static final int SECONDS_FOR_WAITING_TAGS = 50;

    ButtonElement submitButton;
    ButtonElement publishButton;
    ButtonElement browseButton;




    public CreateNewsPO(WebDriver driver) {
        super(driver);
        waitsSwitcher = new WaitsSwitcher(driver);
    }

    public CreateNewsPO clickLanguageDropdown() {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        if (languageDropdown == null) {
            languageDropdown = new ButtonElement(this.driver, CreateNewsPageLocators.LANGUAGE_DROPDOWN);
        }
        languageDropdown.click();

        return this;
    }
    private void clear() {
        languageDropdown = null;
        uaButton = null;
        enButton = null;
        ruButton = null;

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
    }

    public CreateNewsPO clickUaButton() {
        if (uaButton == null) {
            uaButton = new ButtonElement(this.driver, CreateNewsPageLocators.UA_BUTTON);
        }
        uaButton.click();
        clear();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new CreateNewsPO(driver);
    }

    public CreateNewsPO clickEnButton() {
        if (enButton == null) {
            enButton = new ButtonElement(this.driver, CreateNewsPageLocators.EN_BUTTON);
        }
        enButton.click();
        clear();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new CreateNewsPO(driver);
    }

    public CreateNewsPO clickRuButton() {
        if (ruButton == null) {
            ruButton = new ButtonElement(this.driver, CreateNewsPageLocators.RU_BUTTON);
        }
        ruButton.click();
        clear();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    public CreateNewsPO clickTagNews(){
        waitsSwitcher.setImplicitWaits(SECONDS_FOR_WAITING_TAGS);
        if(tags == null){
            tags = new TagComponent(driver);
        }
        tags.clickNewsTag();
        return this;
    }

    public CreateNewsPO clickTagAds(){
        waitsSwitcher.setImplicitWaits(SECONDS_FOR_WAITING_TAGS);
        if(tags == null){
            tags = new TagComponent(driver);
        }
        tags.clickAdsTag();
        return this;
    }

    public CreateNewsPO clickEventsTag(){
        waitsSwitcher.setImplicitWaits(SECONDS_FOR_WAITING_TAGS);
        if(tags == null){
            tags = new TagComponent(driver);
        }
        tags.clickEventsTag();
        return this;
    }

    public CreateNewsPO clickInitiativesTag(){
        waitsSwitcher.setImplicitWaits(SECONDS_FOR_WAITING_TAGS);
        if(tags == null){
            tags = new TagComponent(driver);
        }
        tags.clickInitiativesTag();
        return this;
    }

    public CreateNewsPO clickEducationTag(){
        waitsSwitcher.setImplicitWaits(SECONDS_FOR_WAITING_TAGS);
        if(tags == null){
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
    public CreateNewsPO clickPublishButton() {
        waitsSwitcher.setImplicitWaits(100);
        if ( publishButton == null) {
            publishButton = new ButtonElement(this.driver, CreateNewsPageLocators.PUBLISH_BUTTON);
        }
        publishButton.click();

        return this;
    }

}