package com.pageObject;

import com.elements.ButtonElement;
import com.locators.EcoNewsPageLocators;
import org.openqa.selenium.WebDriver;
import com.locators.EcoNewsPageLocators;

public class BasePage {
    protected WebDriver driver;
    private ButtonElement ecoNewsButton;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public EcoNewsPO clickEcoNews(){
        if (ecoNewsButton == null){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ecoNewsButton = new ButtonElement(this.driver, EcoNewsPageLocators.ECONEWSMENUBUTTON);
        }
        ecoNewsButton.click();

        return new EcoNewsPO(driver);
    }
}
