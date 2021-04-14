package com.locators;

import org.openqa.selenium.By;

public enum LogInLocators implements BaseLocator {

    SIGN_IN_MENU_BUTTON(By.xpath("//a[@role='sign in']")),
    EMAIL_FIELD(By.id("email")),
    PASSWORD_FIELD(By.id("password")),
    SIGN_IN_BUTTON(By.xpath("//button[contains(@class, 'primary-global-button') and @type='submit']"));

    private By path;
    LogInLocators (By path)
    {
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}