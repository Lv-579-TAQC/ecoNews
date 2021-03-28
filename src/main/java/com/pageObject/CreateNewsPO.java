package com.pageObject;

import com.elements.ButtonElement;
import com.elements.FieldElement;
import com.locators.CreateNewsPageLocators;
import org.openqa.selenium.WebDriver;

public class CreateNewsPO extends BasePage {

    ButtonElement languageDropdown = new ButtonElement(this.driver, CreateNewsPageLocators.LANGUAGE_DROPDOWN);
    ButtonElement uaButton = new ButtonElement(this.driver, CreateNewsPageLocators.UA_BUTTON);
    ButtonElement enButton = new ButtonElement(this.driver, CreateNewsPageLocators.EN_BUTTON);
    FieldElement titleField = new FieldElement(this.driver, CreateNewsPageLocators.TITLE_FIELD);
    ButtonElement newsTagButton = new ButtonElement(this.driver, CreateNewsPageLocators.NEWS_TAGBUTTON);
    ButtonElement adsTagButton = new ButtonElement(this.driver, CreateNewsPageLocators.ADS_TAGBUTTON);
    ButtonElement eventsTagButton = new ButtonElement(this.driver, CreateNewsPageLocators.EVENTS_TAGBUTTON);
    ButtonElement initiativesTagButton = new ButtonElement(this.driver, CreateNewsPageLocators.INITIATIVES_TAGBUTTON);
    ButtonElement educationTagButton = new ButtonElement(this.driver, CreateNewsPageLocators.EDUCATION_TAGBUTTON);
    FieldElement sourceField = new FieldElement(this.driver, CreateNewsPageLocators.SOURCE_FIELD);
    ButtonElement browseButton = new ButtonElement(this.driver, CreateNewsPageLocators.BROWSE_PICTURE_BUTTON);
    FieldElement contentField = new FieldElement(this.driver, CreateNewsPageLocators.CONTENT_FIELD);
    ButtonElement cancelButton = new ButtonElement(this.driver, CreateNewsPageLocators.CANCEL_BUTTON);
    ButtonElement previewButton = new ButtonElement(this.driver, CreateNewsPageLocators.PREVIEW_BUTTON);
    ButtonElement publishButton = new ButtonElement(this.driver, CreateNewsPageLocators.PUBLISH_BUTTON);

    public CreateNewsPO(WebDriver driver) {
        super(driver);
    }

    public CreateNewsPO clickLanguageDropdown() {
        languageDropdown.click();

        return this;
    }

    public CreateNewsPO clickUaButton() {
        uaButton.click();

        return new CreateNewsPO(driver);
    }

    public CreateNewsPO clickEnButton() {
        enButton.click();

        return new CreateNewsPO(driver);
    }

    public CreateNewsPO setTitle(String title) {
        titleField.sendKeys(title);

        return this;
    }

    public CreateNewsPO chooseNewsTag() {
        newsTagButton.click();

        return this;
    }

    public CreateNewsPO chooseAdsTag() {
        adsTagButton.click();

        return this;
    }

    public CreateNewsPO chooseEventsTag() {
        eventsTagButton.click();

        return this;
    }

    public CreateNewsPO chooseInitiativesTag() {
        initiativesTagButton.click();

        return this;
    }

    public CreateNewsPO chooseEducationTag() {
        educationTagButton.click();

        return this;
    }

    public CreateNewsPO setSource(String source) {
        sourceField.sendKeys(source);

        return this;
    }

    public CreateNewsPO setContent(String content) {
        contentField.sendKeys(content);

        return this;
    }

    public EcoNewsPO clickCancelButton() {
        cancelButton.click();

        return new EcoNewsPO(driver);
    }

    public CreateNewsPO clickPreviewButton() {
        previewButton.click();

        return new CreateNewsPO(driver);
    }

    public CreateNewsPO clickPublishButton() {
        publishButton.click();

        return this;
    }

    public boolean isLanguageDropdownDisplayed() {
        return languageDropdown.isDisplayed();
    }

   // public boolean isUaButtonDisplayed() {
     //   return uaButton.isDisplayed();
    //}

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

    public boolean isContentFieldDisplayed() {
        return contentField.isDisplayed();
    }

    public boolean isCancelButtonDisplayed() {
        return cancelButton.isDisplayed();
    }

    public boolean isPreviewButtonDisplayed() {
        return previewButton.isDisplayed();
    }

    public boolean isPublishButtonDisplayed() {
        return publishButton.isDisplayed();
    }

    public boolean isPublishButtonEnabled() {
        return publishButton.webElement.isEnabled();
    }
}
