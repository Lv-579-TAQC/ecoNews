package com.elements;

import com.locators.BaseLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseElement {
    protected WebDriver driver;
    public WebElement webElement;
    protected By path;

    public BaseElement(WebDriver driver, BaseLocator locator) {
        this.driver = driver;
        this.path = locator.getPath();
        webElement = driver.findElement(path);
    }


    public boolean isDisplayed() {
        return this.webElement.isDisplayed();
    }
}
