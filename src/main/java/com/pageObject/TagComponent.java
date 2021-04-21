package com.pageObject;

import com.elements.ButtonElement;
import com.locators.TagComponentLocators;
import com.tools.WaitsSwitcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagComponent extends BasePage {
    public WebElement root;
    private ButtonElement newsTag;
    private ButtonElement adsTag;
    private ButtonElement eventsTag;
    private ButtonElement initiativesTag;
    private ButtonElement educationTag;
    private WebElement buttonIsActive;


    private WaitsSwitcher waitsSwitcher;

    private void clear() {

        newsTag = null;
        adsTag = null;
        eventsTag = null;
        initiativesTag = null;
        educationTag = null;
    }

    public TagComponent(WebDriver driver) {
        super(driver);
        root = driver.findElement(TagComponentLocators.TAG_LIST.getPath());
        waitsSwitcher = new WaitsSwitcher(driver);
    }

    public TagComponent clickNewsTag() {
        if (newsTag == null) {
            newsTag = new ButtonElement(this.root, TagComponentLocators.NEWS_TAG_BUTTON);
        }
        newsTag.waitClick(3000);
        return this;
    }

    public TagComponent clickAdsTag() {
        if (adsTag == null) {
            adsTag = new ButtonElement(this.root, TagComponentLocators.ADS_TAG_BUTTON);
        }
        adsTag.waitClick(3000);
        return this;
    }

    public TagComponent clickEventsTag() {
        if (eventsTag == null) {
            eventsTag = new ButtonElement(this.root, TagComponentLocators.EVENTS_TAG_BUTTON);
        }
        eventsTag.waitClick(3000);
        return this;
    }

    public TagComponent clickInitiativesTag() {
        if (initiativesTag == null) {
            initiativesTag = new ButtonElement(this.root, TagComponentLocators.INITIATIVES_TAG_BUTTON);
        }
        initiativesTag.waitClick(3000);
        return this;
    }

    public TagComponent clickEducationTag() {
        if (educationTag == null) {
            educationTag = new ButtonElement(this.root, TagComponentLocators.EDUCATION_TAG_BUTTON);
        }
        educationTag.waitClick(3000);
        return this;
    }

    public ButtonElement getNewsTagButton() {
        clear();
        if (newsTag == null) {
            newsTag = new ButtonElement(this.driver, TagComponentLocators.NEWS_TAG_BUTTON);
        }
        return newsTag;

    }

    public ButtonElement getAdsTagButton() {
        clear();
        if (adsTag == null) {
            adsTag = new ButtonElement(this.driver, TagComponentLocators.ADS_TAG_BUTTON);
        }
        return adsTag;

    }

    public ButtonElement getEventsTagButton() {
        clear();
        if (eventsTag == null) {
            eventsTag = new ButtonElement(this.driver, TagComponentLocators.EVENTS_TAG_BUTTON);
        }
        return eventsTag;

    }

    public ButtonElement getInitiativesTagButton() {
        clear();
        if (initiativesTag == null) {
            initiativesTag = new ButtonElement(this.driver, TagComponentLocators.INITIATIVES_TAG_BUTTON);
        }
        return initiativesTag;

    }

    public ButtonElement getEducationsTagButton() {
        clear();
        if (educationTag == null) {
            educationTag = new ButtonElement(this.driver, TagComponentLocators.EDUCATION_TAG_BUTTON);
        }
        return educationTag;
    }
}
