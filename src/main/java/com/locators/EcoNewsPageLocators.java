package com.locators;

import org.openqa.selenium.By;

public enum EcoNewsPageLocators implements BaseLocator {
    CREATE_NEWS(By.id("create-button")),
    ECO_NEWS_MENU_BUTTON(By.xpath("//li[1]/a[@routerlinkactive='active-link']")),
//    FIRST_NEWS_ON_ECONEWS_PAGE(By.xpath("//*[@id='main-content']/div/div[4]/ul/li[1]")),
    LAST_NEWS_ON_ECONEWS_PAGE_BY_TESTUSER(By.xpath("((//p[.=' TestUser '])[1])"));

    private By path;
    EcoNewsPageLocators (By path){
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}
