package com.pageObject;

import com.elements.ButtonElement;
import com.locators.CreateNewsPageLocators;
import com.tools.WaitsSwitcher;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ChangeLanguageComponent {
    private ButtonElement languageDropdown;
    private ButtonElement uaButton;
    private ButtonElement enButton;
    private ButtonElement ruButton;
    private WebDriver driver;
    private WaitsSwitcher waitsSwitcher;

    public ChangeLanguageComponent(WebDriver driver) {
        this.driver = driver;
        waitsSwitcher = new WaitsSwitcher(driver);
    }

    public ChangeLanguageComponent clickLanguageDropdown() {
        waitsSwitcher.setImplicitWaits(7);
        if (languageDropdown == null) {
            languageDropdown = new ButtonElement(this.driver, CreateNewsPageLocators.LANGUAGE_DROPDOWN);
        }
        languageDropdown.click();
        return this;
    }

    public void clickUaButton() {
        if (uaButton == null) {
            uaButton = new ButtonElement(this.driver, CreateNewsPageLocators.UA_BUTTON);
        }
        uaButton.click();
        WaitsSwitcher.sleep(5000);
    }

    public void clickEnButton() {
        if (enButton == null) {
            enButton = new ButtonElement(this.driver, CreateNewsPageLocators.EN_BUTTON);
        }
        enButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickRuButton() {
        if (ruButton == null) {
            ruButton = new ButtonElement(this.driver, CreateNewsPageLocators.RU_BUTTON);
        }
        ruButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void changeLanguage(String language){
        this.clickLanguageDropdown();
        switch(language){
            case "ua":
                this.clickUaButton();
                break;
            case "en":
                this.clickEnButton();
                break;
            case "ru":
                this.clickRuButton();
                break;
        }
    }
}