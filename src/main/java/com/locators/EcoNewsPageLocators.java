package com.locators;

import org.openqa.selenium.By;

public enum EcoNewsPageLocators implements BaseLocator {
    CREATENEWS(By.id("create-button")),
    ECONEWSMENUBUTTON(By.xpath("//li[@role='eco-news']"));

    private By path;
    EcoNewsPageLocators (By path){
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}
