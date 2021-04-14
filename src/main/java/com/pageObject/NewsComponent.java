package com.pageObject;

import com.elements.BaseElement;
import com.elements.ButtonElement;
import com.elements.LabelElement;
import com.locators.NewsComponentLocators;
import com.tools.WaitsSwitcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewsComponent extends BasePage{
    private WebDriver driver;
    private WaitsSwitcher waitsSwitcher;
    private Boolean isVertical;
    private WebElement newsItem;
    private By path;

    private LabelElement newsTag;
    private LabelElement newsTitle;
    private LabelElement newsContent;
    private WebElement newsImage;

    public NewsComponent(WebDriver driver, boolean isVertical) {
        super(driver);
        this.isVertical = isVertical;
        waitsSwitcher = new WaitsSwitcher(driver);
    }
    public NewsComponent(WebDriver driver, WebElement newsItem, boolean isVertical) {
        super(driver);
        this.isVertical = isVertical;
        this.newsItem = newsItem;
        waitsSwitcher = new WaitsSwitcher(driver);
    }

    public WebElement getNewsTag(){
        if(isVertical){
            path = NewsComponentLocators.NEWS_TITLE_LIST.getPath();
        } else {
            path = NewsComponentLocators.NEWS_TITLE.getPath();
        }
        return newsItem.findElement(path);
    }

    public WebElement getNewsTitle(){
        if(isVertical){
            path = NewsComponentLocators.NEWS_TITLE_LIST.getPath();
        } else {
            path = NewsComponentLocators.NEWS_TITLE.getPath();
        }
        return newsItem.findElement(path);
    }

    public WebElement getNewsContent(){
        if(isVertical){
            path = NewsComponentLocators.NEWS_CONTENT_LIST.getPath();
        } else {
            path = NewsComponentLocators.NEWS_CONTENT.getPath();
        }
        return newsItem.findElement(path);
    }
}
