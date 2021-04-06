package com.pageObject;

import com.elements.ButtonElement;
import com.elements.FieldElement;
import com.elements.LabelElement;
import com.locators.CreateNewsPageLocators;
import org.openqa.selenium.WebDriver;

public class CreateNewsPO extends BasePage {

    ButtonElement languageDropdown;
    ButtonElement uaButton;
    ButtonElement enButton;

    FieldElement titleField;
    FieldElement sourceField;
    FieldElement contentField;

    LabelElement titlePageLabel;
    LabelElement additionalLabel;
    LabelElement titleNewsLabel;
    LabelElement sourceFieldLabel;
    LabelElement contentFieldLabel;
    LabelElement dateLabel;
    LabelElement authorLabel;

    TagComponent tags;


    public CreateNewsPO(WebDriver driver) {
        super(driver);
    }

    public CreateNewsPO clickLanguageDropdown() {
        if (languageDropdown == null) {
            languageDropdown = new ButtonElement(this.driver, CreateNewsPageLocators.LANGUAGE_DROPDOWN);
        }
        languageDropdown.click();

        return this;
    }

    public CreateNewsPO clickUaButton() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (uaButton == null) {
            uaButton = new ButtonElement(this.driver, CreateNewsPageLocators.UA_BUTTON);
        }
        uaButton.click();

        return new CreateNewsPO(driver);
    }

    public CreateNewsPO clickEnButton() {
        if (enButton == null) {
            enButton = new ButtonElement(this.driver, CreateNewsPageLocators.EN_BUTTON);
        }
        enButton.click();

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
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (additionalLabel == null) {
            additionalLabel = new LabelElement(this.driver, CreateNewsPageLocators.ADDITIONAL_LABEL);
        }
        return additionalLabel;

    }

    public LabelElement getSourceFieldLabel() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (sourceFieldLabel == null) {
            sourceFieldLabel = new LabelElement(this.driver, CreateNewsPageLocators.SOURCE_FIELD_LABEL);
        }
        return sourceFieldLabel;

    }

    public LabelElement getContentFieldLabel() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (contentFieldLabel == null) {
            contentFieldLabel = new LabelElement(this.driver, CreateNewsPageLocators.CONTENT_FIELD_LABEL);
        }
        return contentFieldLabel;

    }

    public LabelElement getTitleNewsLabel() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (titleNewsLabel == null) {
            titleNewsLabel = new LabelElement(this.driver, CreateNewsPageLocators.TITLE_NEWS_LABEL);
        }
        return titleNewsLabel;

    }


    public LabelElement getDateLabel() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (dateLabel == null) {
            dateLabel = new LabelElement(this.driver, CreateNewsPageLocators.DATE_LABEL);
        }
        return dateLabel;

    }

    public LabelElement getAuthorLabel() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (authorLabel == null) {
            authorLabel = new LabelElement(this.driver, CreateNewsPageLocators.AUTHOR_LABEL);
        }
        return authorLabel;

    }


    public TagComponent getTags(){
        if (tags == null) {
            tags = new TagComponent(this.driver);
        }
        return tags;
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

//
//
//    public EcoNewsPO clickCancelButton() {
//        cancelButton.click();
//
//        return new EcoNewsPO(driver);
//    }
//
//    public CreateNewsPO clickPreviewButton() {
//        previewButton.click();
//
//        return new CreateNewsPO(driver);
//    }
//
//    public CreateNewsPO clickPublishButton() {
//        publishButton.click();
//
//        return this;
//    }

//    public boolean isLanguageDropdownDisplayed() {
//        return languageDropdown.isDisplayed();
//    }
//
//    public boolean isUaButtonDisplayed() {
//        return uaButton.isDisplayed();
//    }
//
//    public boolean isEnButtonDisplayed() {
//        return enButton.isDisplayed();
//    }
//
//    public boolean isTitleFieldDisplayed() {
//        return titleField.isDisplayed();
//    }
//
//    public boolean isNewsTagButtonDisplayed() {
//        return newsTagButton.isDisplayed();
//    }
//
//    public boolean isAdsTagDisplayed() {
//        return adsTagButton.isDisplayed();
//    }
//
//    public boolean isEventsTagDisplayed() {
//        return eventsTagButton.isDisplayed();
//    }
//
//    public boolean isInitiativesTagButtonDisplayed() {
//        return initiativesTagButton.isDisplayed();
//    }
//
//    public boolean isEducationTagButtonDisplayed() {
//        return educationTagButton.isDisplayed();
//    }
//
//    public boolean isSourceFieldDisplayed() {
//        return sourceField.isDisplayed();
//    }
//
//    public boolean isBrowseButtonDisplayed() {
//        return browseButton.isDisplayed();
//    }

//    public boolean isContentFieldDisplayed() {
//        return contentField.isDisplayed();
//    }
//
//    public boolean isCancelButtonDisplayed() {
//        return cancelButton.isDisplayed();
//    }
//
//    public boolean isPreviewButtonDisplayed() {
//        return previewButton.isDisplayed();
//    }
//
//    public boolean isPublishButtonDisplayed() {
//        return publishButton.isDisplayed();
//    }
//
//    public boolean isPublishButtonEnabled() {
//        return publishButton.webElement.isEnabled();
//    }

}
