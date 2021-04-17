package com.locators;

import org.openqa.selenium.By;

public enum SomeNewsPageLocators implements BaseLocator{
    EDIT_NEWS_BUTTON(By.xpath("//*[@id='main-content']/div/div[1]/a/div")),//TODO
    TITLE_LABEL_ON_DONE_PAGE(By.className("news-title word-wrap")),
    CONTENT_LABEL_ON_DONE_PAGE(By.className("news-text-content word-wrap"));

    private By path;
    SomeNewsPageLocators (By path){
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}