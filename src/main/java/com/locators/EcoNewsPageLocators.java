package com.locators;

import org.openqa.selenium.By;

public enum EcoNewsPageLocators implements BaseLocator {
    CREATENEWS(By.id("create-button")),
    ECO_NEWS_MENU_BUTTON(By.xpath("//li[@role='eco-news']")),
    LIST_VIEW_XP(By.xpath("//li[contains(@class, 'list-view')]"));

    private By path;
    EcoNewsPageLocators (By path){
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}
