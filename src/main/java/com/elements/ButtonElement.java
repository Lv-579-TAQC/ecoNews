package com.elements;

import com.locators.BaseLocator;
import com.locators.TagComponentLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.logging.Logger;

public class ButtonElement extends BaseElement {

    private Logger log = Logger.getLogger(ButtonElement.class.getName());

    public ButtonElement(WebDriver driver, BaseLocator locator) {
        super(driver, locator);
    }

    public ButtonElement(WebElement webElement, BaseLocator locator) {
        super(webElement, locator);
    }

    public ButtonElement(WebElement webElement){
        super(webElement);
    }

    public void click(){
        this.webElement.click();
    }

    public void waitClick(int milliSeconds){
        int ms = 0;
        do{
            try {
                webElement.click();
                break;
            } catch (WebDriverException e){
                try {
                    ms += 100;
                    Thread.sleep(100);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                log.info("-");
            }
        }while (ms < milliSeconds);
    }

    public String getText(){
        return webElement.getText();
    }

    public void sendKeys(String keys) {
        this.webElement.sendKeys(keys);
    }
}
