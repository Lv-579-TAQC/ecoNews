package com.pageObject;

import com.elements.ButtonElement;
import com.elements.LabelElement;
import com.locators.CreateNewsPageLocators;
import com.locators.TagComponentLocators;
import com.tools.WaitsSwitcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TagComponent extends BasePage{
    public WebElement root;
    private ButtonElement newsTag;
    private ButtonElement adsTag;
    private ButtonElement eventsTag;
    private ButtonElement initiativesTag;
    private ButtonElement educationTag;
    LabelElement newsTagLabel;

    private WaitsSwitcher waitsSwitcher;

    public TagComponent(WebDriver driver) {
        super(driver);
        root = driver.findElement(TagComponentLocators.TAG_LIST.getPath());
        waitsSwitcher = new WaitsSwitcher(driver);
    }

    public TagComponent clickNewsTag(){
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement explicitWait = wait
//                .until(ExpectedConditions.elementToBeClickable(root.findElement(TagComponentLocators.NEWS_TAGBUTTON.getPath())));
        waitsSwitcher.setImplicitWaits(80000);
        if (newsTag == null) {
            newsTag = new ButtonElement(this.root, TagComponentLocators.NEWS_TAGBUTTON);
        }
//        newsTag = new ButtonElement(explicitWait);
        newsTag.click();
        return this;
    }

    public TagComponent clickAdsTag(){
        if (adsTag == null) {
            adsTag = new ButtonElement(this.root, TagComponentLocators.ADS_TAGBUTTON);
        }
        adsTag.click();
        return this;
    }

    public TagComponent clickEventsTag(){
        if (eventsTag == null) {
            eventsTag = new ButtonElement(this.root, TagComponentLocators.EVENTS_TAGBUTTON);
        }
        eventsTag.click();
        return this;
    }

    public TagComponent clickInitiativesTag(){
        if (initiativesTag == null) {
            initiativesTag = new ButtonElement(this.root, TagComponentLocators.INITIATIVES_TAGBUTTON);
        }
        initiativesTag.click();
        return this;
    }

    public TagComponent clickEducationTag(){
        if (educationTag == null) {
            educationTag = new ButtonElement(this.root, TagComponentLocators.EDUCATION_TAGBUTTON);
        }
        educationTag.click();
        return this;
    }

    public ButtonElement getNewsTagButton() {
        if ( newsTag == null) {
            newsTag = new ButtonElement(this.driver, TagComponentLocators.NEWS_TAGBUTTON);
        }
        return newsTag;

    }
}
