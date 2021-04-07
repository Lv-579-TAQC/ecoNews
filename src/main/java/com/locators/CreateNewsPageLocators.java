package com.locators;

import org.openqa.selenium.By;

public enum CreateNewsPageLocators implements BaseLocator{

    TITLE_FIELD(By.xpath("//h3[text()='Title']/following-sibling::textarea")),
    NEWS_TAGBUTTON(By.xpath("//button[contains(text(),'News')]")),
    ADS_TAGBUTTON(By.xpath("//button[contains(text(),'Ads')]")),
    EVENTS_TAGBUTTON(By.xpath("//button[contains(text(),'Events')]")),
    INITIATIVES_TAGBUTTON(By.cssSelector("#main-content > div > div.form-container.ng-star-inserted > form > div.wrapper > div.left-form-column > div.tags.item-block.ng-untouched.ng-pristine.ng-valid > button:nth-child(4)")),
    EDUCATION_TAGBUTTON(By.xpath("//button[contains(text(),'Education')]")),
    SOURCE_FIELD(By.xpath("//input[@formcontrolname='source']")),
    BROWSE_PICTURE_BUTTON(By.id("upload")),
    CONTENT_FIELD(By.xpath("//textarea[@name='main-area']")),
    CANCEL_BUTTON(By.xpath("//button[@class='cancel']")),
    PREVIEW_BUTTON(By.xpath("//button[text()=' Preview ']")),
    PUBLISH_BUTTON(By.xpath("//button[@type='submit']")),
    LANGUAGE_DROPDOWN(By.xpath("//ul[@class='header_lang-switcher-wrp header_navigation-menu-right-list']")),
    EN_BUTTON(By.xpath("//li[text()=' En ']")),
    UA_BUTTON(By.xpath("//li[text()=' Ua ']")),
    TITLE_LABEL(By.xpath("//*[@id='main-content']/div/div[1]/h2")),
    TITLE_OF_NEWS_ON_PREVIEW(By.xpath("/html/body/app-root/div[3]/app-eco-news/div/app-news-preview-page/div/div[4]/div[1]/div")),
    SUBMIT_BUTTON(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[1]/div[2]/app-drag-and-drop/div/div/div/div/button[1]"));



    private By path;
    CreateNewsPageLocators (By path){
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}
