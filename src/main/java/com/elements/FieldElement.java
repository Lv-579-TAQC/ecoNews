package com.elements;

import com.locators.BaseLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FieldElement extends BaseElement {

    public FieldElement(WebDriver driver, BaseLocator locator) {
        super(driver, locator);
    }

    public FieldElement(WebElement webElement, BaseLocator locator) {
        super(webElement, locator);
    }

    public void sendKeys(String keys) {
        this.webElement.sendKeys(keys);
    }

    public void clear() {
        this.webElement.clear();
    }
}
