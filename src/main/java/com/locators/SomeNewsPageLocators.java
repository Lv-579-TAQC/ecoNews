package com.locators;

import org.openqa.selenium.By;

public enum SomeNewsPageLocators implements BaseLocator {
    EDIT_NEWS_BUTTON(By.xpath("//div[@class='edit-news ng-star-inserted']")),
    TITLE_LABEL_ON_DONE_PAGE(By.xpath("//div[@class='news-title word-wrap']")),
    CONTENT_LABEL_ON_DONE_PAGE(By.xpath("//div[@class='news-text-content word-wrap']"));

    private By path;

    SomeNewsPageLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}