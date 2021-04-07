package com.elements;

import com.locators.BaseLocator;
import org.openqa.selenium.WebDriver;

public class LabelElement extends BaseElement {
    public LabelElement(WebDriver driver, BaseLocator locator) {
        super(driver, locator);
    }
    public String getText(){
        return webElement.getText();
    }
}
