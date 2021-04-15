package com.locators;

import org.openqa.selenium.By;

public enum EcoNewsPageLocators implements BaseLocator {
    CREATE_NEWS(By.id("create-button")),
    ECO_NEWS_MENU_BUTTON(By.xpath("//li[@role='eco-news']"));

    private By path;
    EcoNewsPageLocators (By path){
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}
