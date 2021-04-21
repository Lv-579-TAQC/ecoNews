package com.pageObject;

import com.elements.ButtonElement;
import com.elements.LabelElement;
import com.locators.CreateNewsPageLocators;
import com.locators.EcoNewsPageLocators;
import com.locators.HeaderComponentLocator;
import com.locators.LogInLocators;
import com.tools.WaitsSwitcher;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HeaderComponent extends BasePage{
    private WaitsSwitcher waitsSwitcher;
    private ButtonElement ecoNewsButton;
    private ButtonElement languageDropdown;
    private LabelElement usernameLabel;
    private ButtonElement signInMenuButton;

    public HeaderComponent(WebDriver driver) {
        super(driver);
        waitsSwitcher = new WaitsSwitcher(driver);
    }

    public EcoNewsPO clickEcoNews() {
        if (ecoNewsButton == null) {
            waitsSwitcher.sleep(7000);
            ecoNewsButton = new ButtonElement(this.driver, HeaderComponentLocator.ECO_NEWS_BUTTON);
        }
        ecoNewsButton.click();

        return new EcoNewsPO(driver);
    }

    public ChangeLanguageComponent clickLanguageDropdown() {
        driver.manage().timeouts().implicitlyWait(7000, TimeUnit.SECONDS);
        if (languageDropdown == null) {
            languageDropdown = new ButtonElement(this.driver, HeaderComponentLocator.CHANGE_LANGUAGE_DROPDOWN);
        }
        languageDropdown.click();
        return new ChangeLanguageComponent(driver);
    }

    public LabelElement getUserName(){
        if (usernameLabel == null) {
            usernameLabel = new LabelElement(this.driver, HeaderComponentLocator.USERNAME);
        }

        return usernameLabel;
    }

    public LogInPO clickSignInMenuButton() {
        if (signInMenuButton == null) {
            signInMenuButton = new ButtonElement(this.driver, LogInLocators.SIGN_IN_MENU_BUTTON);
        }
        signInMenuButton.click();

        return new LogInPO(driver);
    }
}
