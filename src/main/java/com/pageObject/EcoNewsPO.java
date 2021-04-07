package com.pageObject;

import com.elements.ButtonElement;
import org.openqa.selenium.WebDriver;
import com.locators.EcoNewsPageLocators;

public class EcoNewsPO extends BasePage{
    ButtonElement createNews;
    public EcoNewsPO(WebDriver driver) {
        super(driver);
    }
    public CreateNewsPO clickCreateNewsBtn(){
        createNews = new ButtonElement(this.driver,EcoNewsPageLocators.CREATENEWS);
        if (createNews == null){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        createNews.click();
        return new CreateNewsPO(driver);
    }
}
