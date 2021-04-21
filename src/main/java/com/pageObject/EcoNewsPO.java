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
    private ButtonElement firstNews;
    private NewsComponentContainer newsComponentContainer;

    public EcoNewsPO(WebDriver driver) {
        super(driver);
    }
    public CreateNewsPO clickCreateNewsBtn(){
        if(createNews == null) {
            createNews = new ButtonElement(this.driver, EcoNewsPageLocators.CREATE_NEWS);
        }
        createNews.click();
        return new CreateNewsPO(driver);
    }

    public SomeNewsPagePO clickOnTheLatestNewsCreatedByTheTestUserOnTheEcoNewsPage(){

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(firstNews == null) {
            firstNews = new ButtonElement(this.driver, EcoNewsPageLocators.LAST_NEWS_ON_ECONEWS_PAGE_BY_TESTUSER);
        }
        firstNews.click();
        return new SomeNewsPagePO(driver);
    }

    public NewsComponentContainer getNewsComponentContainer(boolean isVertical){
        newsComponentContainer = new NewsComponentContainer(driver, isVertical);
        return newsComponentContainer;
    }
}
