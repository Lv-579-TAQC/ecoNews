package com.locators;

import org.openqa.selenium.By;

public enum TagComponentLocators implements BaseLocator{
    TAG_LIST(By.xpath("//*[contains(@class, 'tags')]")),
    NEWS_TAGBUTTON(By.xpath("//button[contains(@class, 'ng')][1]")),
    ADS_TAGBUTTON(By.xpath("//button[contains(@class, 'ng')][2]")),
    EVENTS_TAGBUTTON(By.xpath("//button[contains(@class, 'ng')][3]")),
    INITIATIVES_TAGBUTTON(By.xpath("//button[contains(@class, 'ng')][4]")),
    EDUCATION_TAGBUTTON(By.xpath("//button[contains(@class, 'ng')][5]"));
//    TAG_LIST(By.xpath("//*[@id='main-content']/div/div[2]/form/div[1]/div[1]/div[2]")),
//    NEWS_TAGBUTTON(By.xpath("//button[1]")),
//    ADS_TAGBUTTON(By.xpath("//button[2]")),
//    EVENTS_TAGBUTTON(By.xpath("//button[3]")),
//    INITIATIVES_TAGBUTTON(By.xpath("//button[4]")),
//    EDUCATION_TAGBUTTON(By.xpath("//button[5]"));


    private By path;
    TagComponentLocators (By path){
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}
