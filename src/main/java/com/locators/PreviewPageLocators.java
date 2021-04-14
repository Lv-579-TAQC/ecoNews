package com.locators;

import org.openqa.selenium.By;

public enum PreviewPageLocators implements BaseLocator{
    BACK_TO_EDITING_BUTTON(By.xpath("//div[@class='button-text']")),
    //    PUBLISH_BUTTON(By.xpath("//button[@type='submit']")),
    PUBLISH_BUTTON(By.xpath("//form[@class='submit-form ng-untouched ng-pristine ng-valid']//button[@type='submit']")),
    TITLE_LABEL(By.xpath("//div[@class='news-title word-wrap']")),
    TEXT_CONTENT(By.xpath("//div[@class='news-text-content word-wrap']"));

    private By path;
    PreviewPageLocators (By path){
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}