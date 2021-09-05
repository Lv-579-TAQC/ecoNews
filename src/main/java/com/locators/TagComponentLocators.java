package com.locators;

import org.openqa.selenium.By;

public enum TagComponentLocators implements BaseLocator{
    TAG_LIST(By.xpath("//*[contains(@class, 'tags')]")),
    NEWS_TAG_BUTTON(By.xpath("//button[contains(@class, 'ng')][1]")),
    ADS_TAG_BUTTON(By.xpath("//button[contains(@class, 'ng')][2]")),
    EVENTS_TAG_BUTTON(By.xpath("//button[contains(@class, 'ng')][3]")),
    INITIATIVES_TAG_BUTTON(By.xpath("//button[contains(@class, 'ng')][4]")),
    EDUCATION_TAG_BUTTON(By.xpath("//button[contains(@class, 'ng')][5]")),
    SIGN_UNDER_TAGS(By.xpath("//*[contains(@class, 'tags')]//p"));

    private By path;
    TagComponentLocators (By path){
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}
