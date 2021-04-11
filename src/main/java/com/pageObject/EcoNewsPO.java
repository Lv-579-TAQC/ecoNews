package com.pageObject;

import com.elements.ButtonElement;
import com.elements.FieldElement;
import com.elements.LabelElement;
import com.locators.TagComponentLocators;
import org.openqa.selenium.WebDriver;
import com.locators.EcoNewsPageLocators;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class EcoNewsPO extends BasePage{
    private ButtonElement createNews;

    public EcoNewsPO(WebDriver driver) {
        super(driver);
    }

    public CreateNewsPO clickCreateNewsBtn(){
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        if(createNews == null) {
            createNews = new ButtonElement(this.driver, EcoNewsPageLocators.CREATE_NEWS);
        }
        createNews.click();
        return new CreateNewsPO(driver);
    }
}
