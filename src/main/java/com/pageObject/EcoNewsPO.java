
package com.pageObject;

import com.elements.ButtonElement;
import com.elements.LabelElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.locators.EcoNewsPageLocators;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EcoNewsPO extends BasePage{
    public static final String LIST_VIEW_XP = "//li[contains(@class, 'list-view')]";
    ButtonElement createNews;
    List<WebElement> ecoNewsAllNews;
    public EcoNewsPO(WebDriver driver)
    {
        super(driver);
    }
    public CreateNewsPO clickCreateNewsBtn(){
        createNews = new ButtonElement(this.driver,EcoNewsPageLocators.CREATENEWS);
        createNews.click();
        return new CreateNewsPO(driver);
    }
    public String getImageUrlOfLastPost() {
        String url = "";
        ecoNewsAllNews = this.driver.findElements(By.xpath(LIST_VIEW_XP));
        if (ecoNewsAllNews != null && !ecoNewsAllNews.isEmpty()) {
            url = ecoNewsAllNews.get(0).findElement(By.xpath(".//img")).getAttribute("src");
        }
        return url;
    }
}