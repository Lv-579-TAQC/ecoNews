package com.pageObject;

import com.elements.ButtonElement;
import com.elements.FieldElement;
import com.elements.LabelElement;
import com.locators.TagComponentLocators;
import com.tools.WaitsSwitcher;
import org.openqa.selenium.WebDriver;
import com.locators.EcoNewsPageLocators;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class EcoNewsPO extends BasePage{
    private ButtonElement createNews;
    private NewsComponentContainer newsComponentContainer;
    private WaitsSwitcher waitsSwitcher;

    public EcoNewsPO(WebDriver driver) {

        super(driver);
        waitsSwitcher = new WaitsSwitcher(driver);
    }

    public CreateNewsPO clickCreateNewsBtn(){
        waitsSwitcher.setImplicitWaits(100);
        if(createNews == null) {
            createNews = new ButtonElement(this.driver, EcoNewsPageLocators.CREATE_NEWS);
        }
        createNews.click();
        return new CreateNewsPO(driver);
    }

    public NewsComponentContainer getNewsComponentContainer(boolean isVertical){
        newsComponentContainer = new NewsComponentContainer(driver, isVertical);
        return newsComponentContainer;
    }
}