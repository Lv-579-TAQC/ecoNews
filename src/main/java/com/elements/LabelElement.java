package com.elements;

import com.locators.BaseLocator;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;

public class LabelElement extends BaseElement {
    public LabelElement(WebDriver driver, BaseLocator locator) {
        super(driver, locator);
    }

    public LabelElement(WebElement webElement, BaseLocator locator) {
        super(webElement, locator);
    }

    public String getText(){
        return webElement.getText();
    }

    public Point getLocation(){
        return webElement.getLocation();
    }
    public String getColorRGB(){
        return webElement.getCssValue("color");
    }
    public String getColorHex(){
        return Color.fromString(getColorRGB()).asHex();
    }
    public int getHeight(){ return webElement.getSize().getHeight();}

}
