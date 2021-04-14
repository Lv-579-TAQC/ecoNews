package com.pageObject;

import com.elements.ButtonElement;
import com.locators.EcoNewsPageLocators;
import org.openqa.selenium.WebDriver;
import com.locators.EcoNewsPageLocators;

public class BasePage {
    protected WebDriver driver;
    private ButtonElement ecoNewsButton;
    private ChangeLanguageComponent changeLanguage;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public EcoNewsPO clickEcoNews() {
        if (ecoNewsButton == null) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ecoNewsButton = new ButtonElement(this.driver, EcoNewsPageLocators.ECO_NEWS_MENU_BUTTON);
        }
        ecoNewsButton.click();

        return new EcoNewsPO(driver);
    }

    public void clickChangeLanguage(String language) {
        if (changeLanguage == null){
            changeLanguage = new ChangeLanguageComponent(this.driver);
        }
        changeLanguage.changeLanguage(language);
    }

}
