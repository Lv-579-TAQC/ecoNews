package com.pageObject;

import com.elements.ButtonElement;
import com.locators.EcoNewsPageLocators;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    private ButtonElement ecoNewsButton;
    private ChangeLanguageComponent changeLanguage;
    private HeaderComponent headerComponent;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickChangeLanguage(String language) {
        if (changeLanguage == null) {
            changeLanguage = new ChangeLanguageComponent(this.driver);
        }
        changeLanguage.changeLanguage(language);
    }

    public HeaderComponent getHeaderComponent(){
        headerComponent = new HeaderComponent(driver);
        return headerComponent;
    }
}
