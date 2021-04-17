package com.locators;

import org.openqa.selenium.By;

public enum EcoNewsPageLocators implements BaseLocator {
    CREATE_NEWS(By.id("create-button-text")),
    ECO_NEWS_MENU_BUTTON(By.xpath("//li[1]/a[@routerlinkactive='active-link']"));

    private By path;
    EcoNewsPageLocators (By path){
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}
