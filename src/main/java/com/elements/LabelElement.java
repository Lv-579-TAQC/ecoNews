package com.elements;

import com.locators.BaseLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class LabelElement extends BaseElement {
    public LabelElement(WebDriver driver, BaseLocator locator) {
        super(driver, locator);
    }
    public String getText(){
        return webElement.getText();
    }
    public String getColorRGB(){
        return webElement.getCssValue("color");
    }
    public String getColorHex(){
        return Color.fromString(getColorRGB()).asHex();
    }
}
