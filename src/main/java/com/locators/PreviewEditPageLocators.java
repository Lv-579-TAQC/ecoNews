package com.locators;

import org.openqa.selenium.By;

public enum PreviewEditPageLocators implements BaseLocator{
    TITLE_ON_PREVIEW_EDIT_PAGE(By.xpath("//div[@class='news-title word-wrap']")),
    CONTENT_ON_PREVIEW_EDIT_PAGE(By.xpath("//div[@class='news-text-content word-wrap']")),
    EDIT_BUTTON_ON_PREVIEW_EDIT_PAGE(By.xpath("//button[@class='primary-global-button ng-star-inserted']"));

    private By path;
    PreviewEditPageLocators (By path){
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}
