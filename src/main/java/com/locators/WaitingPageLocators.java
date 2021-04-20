package com.locators;

import org.openqa.selenium.By;

public enum WaitingPageLocators implements BaseLocator{
    MAIN_LABEL_ON_WAITING_PAGE(By.xpath("//p[@class='header']")),
    INFORMATION_LABEL_ON_WAITING_PAGE(By.xpath("//p[@class='description']"));

    private By path;
    WaitingPageLocators (By path){
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}
