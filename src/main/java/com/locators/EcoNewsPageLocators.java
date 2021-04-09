package com.locators;

import org.openqa.selenium.By;

public enum EcoNewsPageLocators implements BaseLocator {
    CREATE_NEWS(By.id("create-button")),
    ECO_NEWS_MENU_BUTTON(By.xpath("//li[@role='eco-news']"));
//    NEWS_LIST(By.xpath("//div[@class='list-wrapper']"))
//    NEWS_LIST(By.cssSelector("ul[class='list ng-star-inserted']")),
//    FIRST_NEWS(By.cssSelector("li:first-child")),
//    FIRST_NEWS_TITLE(By.cssSelector("ul[class='list ng-star-inserted'] li:first-child div[class='eco-news_list-content-title one-row']"),
//    FIRST_NEWS_TITLE(By.xpath(""));

    private By path;
    EcoNewsPageLocators (By path){
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}
