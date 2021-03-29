package com.elements;

import com.locators.BaseLocator;
import org.openqa.selenium.WebDriver;

public class FieldElement extends BaseElement {

    public FieldElement(WebDriver driver, BaseLocator locator) {
        super(driver, locator);
    }

    public void sendKeys(String keys) {
        this.webElement.sendKeys(keys);
    }
}
