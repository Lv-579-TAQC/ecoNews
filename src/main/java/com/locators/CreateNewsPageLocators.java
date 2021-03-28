package com.locators;

import org.openqa.selenium.By;

public enum CreateNewsPageLocators implements BaseLocator{

    TITLE_FIELD(By.xpath("//h3[text()='Title']/following-sibling::textarea")),
    NEWS_TAGBUTTON(By.xpath("//button[contains(text(),'News')]")),
    ADS_TAGBUTTON(By.xpath("//button[contains(text(),'Ads')]")),
    EVENTS_TAGBUTTON(By.xpath("//button[contains(text(),'Events')]")),
    INITIATIVES_TAGBUTTON(By.xpath("//button[contains(text(),'Initiatives')]")),
    EDUCATION_TAGBUTTON(By.xpath("//button[contains(text(),'Education')]")),
    SOURCE_FIELD(By.xpath("//input[@formcontrolname='source']")),
    BROWSE_PICTURE_BUTTON(By.xpath("//span[text()='browse']")),
    CONTENT_FIELD(By.xpath("//textarea[@name='main-area']")),
    CANCEL_BUTTON(By.xpath("//button[@class='cancel']")),
    PREVIEW_BUTTON(By.xpath("//button[text()=' Preview ']")),
    PUBLISH_BUTTON(By.xpath("//button[@type='submit']")),
    LANGUAGE_DROPDOWN(By.xpath("//ul[@class='header_lang-switcher-wrp header_navigation-menu-right-list']")),
    EN_BUTTON(By.xpath("//li[text()=' En ']")),
    UA_BUTTON(By.xpath("//li[text()=' Ua ']"));


    private By path;
    CreateNewsPageLocators (By path){
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}
