package com.locators;

import org.openqa.selenium.By;

public enum EcoNewsPageLocators implements BaseLocator {
    CREATE_NEWS(By.xpath("//span[@id='create-button-text']")),
    ECO_NEWS_MENU_BUTTON(By.xpath("//li[1]/a[@routerlinkactive='active-link']")),
    FIRST_NEWS_ON_ECONEWS_PAGE(By.xpath("//*[@id='main-content']/div/div[4]/ul/li[1]")); //TODO

    private By path;
    EcoNewsPageLocators (By path){
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}