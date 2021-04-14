package com.pageObject;

import com.locators.NewsComponentLocators;
import com.tools.WaitsSwitcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class NewsComponentContainer {
    private WebDriver driver;
    private List<NewsComponent> newsComponents;
    private boolean isVertical;
    private By items = NewsComponentLocators.NEWS_ITEMS.getPath();

    public NewsComponentContainer(WebDriver driver) {
        this.driver = driver;
        isVertical = false;
    }

    public NewsComponentContainer(WebDriver driver, boolean isVertical) {
        this.driver = driver;
        this.isVertical = isVertical;
    }

    private List<NewsComponent> getItemComponents() {
        newsComponents = new ArrayList<>();
        for (WebElement current : getItems()) {
            newsComponents.add(new NewsComponent(driver, current, isVertical));
        }
        return newsComponents;
    }

    private List<WebElement> getItems() {
        WaitsSwitcher waitsSwitcher = new WaitsSwitcher(driver);
        return waitsSwitcher.setExplicitWait(65,
                ExpectedConditions.presenceOfAllElementsLocatedBy(items));
    }

    public NewsComponent chooseNewsByNumber(int number) {
        return getItemComponents().get(number);
    }

    public int getNewsComponentSize() {
        return getItemComponents().size();
    }
}