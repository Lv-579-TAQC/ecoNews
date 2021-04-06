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
    ButtonElement newsTagButton;
    ButtonElement adsTagButton;
    ButtonElement eventsTagButton;
    ButtonElement initiativesTagButton;
    ButtonElement educationTagButton;
    FieldElement sourceField;
    ButtonElement browseButton;
    LabelElement titleLabel;

//    ButtonElement(this.driver, CreateNewsPageLocators.BROWSE_PICTURE_BUTTON);
//
//    FieldElement contentField; =new
//
//    FieldElement(this.driver, CreateNewsPageLocators.CONTENT_FIELD);
//
//    ButtonElement cancelButton; =new
//
//    ButtonElement(this.driver, CreateNewsPageLocators.CANCEL_BUTTON);
//
//    ButtonElement previewButton; =new
//
//    ButtonElement(this.driver, CreateNewsPageLocators.PREVIEW_BUTTON);
//
//    ButtonElement publishButton; =new
//
//    ButtonElement(this.driver, CreateNewsPageLocators.PUBLISH_BUTTON);

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

    public LabelElement getTitleLabel() {
        if (titleLabel == null) {
            titleLabel = new LabelElement(this.driver, CreateNewsPageLocators.TITLE_LABEL);
        }
        return titleLabel;

    }

    public CreateNewsPO chooseNewsTag() {
        if (newsTagButton == null) {
            newsTagButton = new ButtonElement(this.driver, CreateNewsPageLocators.NEWS_TAGBUTTON);
        }
        newsTagButton.click();

        return this;
    }

    public CreateNewsPO chooseAdsTag() {
        if (adsTagButton == null) {
            adsTagButton = new ButtonElement(this.driver, CreateNewsPageLocators.ADS_TAGBUTTON);
        }
        adsTagButton.click();

        return this;
    }

    public CreateNewsPO chooseEventsTag() {
        if (eventsTagButton == null) {
            eventsTagButton = new ButtonElement(this.driver, CreateNewsPageLocators.EVENTS_TAGBUTTON);
        }
        eventsTagButton.click();

        return this;
    }

    public CreateNewsPO chooseInitiativesTag() {
        if (initiativesTagButton == null) {
            initiativesTagButton = new ButtonElement(this.driver, CreateNewsPageLocators.INITIATIVES_TAGBUTTON);
        }
        initiativesTagButton.click();

        return this;
    }

    public CreateNewsPO chooseEducationTag() {
        if (educationTagButton == null) {
            educationTagButton = new ButtonElement(this.driver, CreateNewsPageLocators.EDUCATION_TAGBUTTON);
        }
        educationTagButton.click();

        return this;
    }

    public CreateNewsPO setSource(String source) {
        if (sourceField == null) {
            sourceField = new FieldElement(this.driver, CreateNewsPageLocators.SOURCE_FIELD);
        }
        sourceField.sendKeys(source);

        return this;
    }
    public CreateNewsPO clickPreviewButton() {
        if (enButton == null) {
            enButton = new ButtonElement(this.driver, CreateNewsPageLocators.PREVIEWPAGEBUTTON);
        }
        enButton.click();

        return new CreateNewsPO(driver);
    }
    public LabelElement getBackToEditingButton() {
        if (titleLabel == null) {
            titleLabel = new LabelElement(this.driver, CreateNewsPageLocators.BACKTOEDITINGBUTTON);
        }
        return titleLabel;
    }

//    public CreateNewsPO setContent(String content) {
//        if (contentField == null) {
//            contentField = new FieldElement(this.driver, CreateNewsPageLocators.CONTENT_FIELD);
//        }
//        contentField.sendKeys(content);
//
//        return this;
//    }
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

    public boolean isLanguageDropdownDisplayed() {
        return languageDropdown.isDisplayed();
    }

    public boolean isUaButtonDisplayed() {
        return uaButton.isDisplayed();
    }

    public boolean isEnButtonDisplayed() {
        return enButton.isDisplayed();
    }

    public boolean isTitleFieldDisplayed() {
        return titleField.isDisplayed();
    }

    public boolean isNewsTagButtonDisplayed() {
        return newsTagButton.isDisplayed();
    }

    public boolean isAdsTagDisplayed() {
        return adsTagButton.isDisplayed();
    }

    public boolean isEventsTagDisplayed() {
        return eventsTagButton.isDisplayed();
    }

    public boolean isInitiativesTagButtonDisplayed() {
        return initiativesTagButton.isDisplayed();
    }

    public boolean isEducationTagButtonDisplayed() {
        return educationTagButton.isDisplayed();
    }

    public boolean isSourceFieldDisplayed() {
        return sourceField.isDisplayed();
    }

    public boolean isBrowseButtonDisplayed() {
        return browseButton.isDisplayed();
    }

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
