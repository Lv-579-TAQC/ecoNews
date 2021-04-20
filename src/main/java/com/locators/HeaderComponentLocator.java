package com.locators;

import org.openqa.selenium.By;

public enum HeaderComponentLocator implements BaseLocator{

    ECO_NEWS_BUTTON(By.xpath("//nav[@class='header_navigation-menu-left']/ul/li[1]/a")),
    TIPS_TRICKS_BUTTON(By.xpath("//nav[@class='header_navigation-menu-left']/ul/li[2]/a")),
    PLACES_BUTTON(By.xpath("//nav[@class='header_navigation-menu-left']/ul/li[3]/a")),
    ABOUT_BUTTON(By.xpath("//nav[@class='header_navigation-menu-left']/ul/li[4]/a")),
    HABITS_BUTTON(By.xpath("//nav[@class='header_navigation-menu-left']/ul/li[5]/a")),
    UBS_BUTTON(By.xpath("//nav[@class='header_navigation-menu-left']/ul/li[6]/a")),

    SEARCH_BUTTON(By.xpath("//li[@class = 'search-icon ng-star-inserted']")),

    CHANGE_LANGUAGE_DROPDOWN(By.xpath("//ul[@class='header_lang-switcher-wrp header_navigation-menu-right-list']")),
    EN_BUTTON(By.xpath("//span[text()='En']")),
    UA_BUTTON(By.xpath("//span[text()='Ua']")),
    RU_BUTTON(By.xpath("//span[text()='Ru']")),

    USER_MENU_DROPDOWN(By.cssSelector("#header_user-wrp")),
    USERNAME(By.xpath("//a[@class='header_user-name']/span")),
    USER_SETTINGS(By.xpath("//li[@aria-label='settings']/a")),
    USER_SIGN_OUT(By.xpath("//li[@aria-label='sign-out']/a")),

    MENU_DROPDOWN(By.cssSelector(".menu-icon-wrapper"))
    ;

    private By path;
    HeaderComponentLocator(By path) {
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}
