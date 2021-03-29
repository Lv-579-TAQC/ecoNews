package com.pageObject;

import com.elements.ButtonElement;
import com.locators.EcoNewsPageLocators;
import org.openqa.selenium.WebDriver;
import com.locators.EcoNewsPageLocators;

public class BasePage {
    protected WebDriver driver;
    private ButtonElement createNewsMenuButton;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public EcoNewsPO clickEcoNews(){
        if (createNewsMenuButton == null){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            createNewsMenuButton = new ButtonElement(this.driver, EcoNewsPageLocators.ECONEWSMENUBUTTON);
        }
        return new EcoNewsPO(driver);
    }
}
