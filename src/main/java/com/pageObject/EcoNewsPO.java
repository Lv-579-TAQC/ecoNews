package com.pageObject;

import com.elements.ButtonElement;
import org.openqa.selenium.WebDriver;
import com.locators.EcoNewsPageLocators;

import java.util.concurrent.TimeUnit;

public class EcoNewsPO extends BasePage{
    ButtonElement createNews;
    public EcoNewsPO(WebDriver driver)
    {
        super(driver);
    }
    public CreateNewsPO clickCreateNewsBtn(){
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        createNews = new ButtonElement(this.driver,EcoNewsPageLocators.CREATENEWS);
        createNews.click();
        return new CreateNewsPO(driver);
    }
}
