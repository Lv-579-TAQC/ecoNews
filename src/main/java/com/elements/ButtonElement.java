package com.elements;

import com.locators.BaseLocator;
import org.openqa.selenium.WebDriver;

public class ButtonElement extends BaseElement {

    public ButtonElement(WebDriver driver, BaseLocator locator) {
        super(driver, locator);
    }
    public void click(){
        this.webElement.click();
    }
    public String getText(){
        return webElement.getText();
    }
}
