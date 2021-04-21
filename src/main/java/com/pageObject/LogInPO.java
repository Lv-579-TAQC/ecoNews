package com.pageObject;

import com.elements.ButtonElement;
import com.elements.FieldElement;
import com.locators.CreateNewsPageLocators;
import com.locators.LogInLocators;
import org.openqa.selenium.WebDriver;

public class LogInPO extends BasePage {

    ButtonElement signInMenuButton;
    FieldElement emailField;
    FieldElement passwordField;
    ButtonElement signInButton;

    public LogInPO(WebDriver driver) {
        super(driver);
    }

    public LogInPO setEmail(String text) {
        if (emailField == null) {
            emailField = new FieldElement(this.driver, LogInLocators.EMAIL_FIELD);
        }
        emailField.sendKeys(text);

        return this;
    }

    public LogInPO setPassword(String text) {
        if (passwordField == null) {
            passwordField = new FieldElement(this.driver, LogInLocators.PASSWORD_FIELD);
        }
        passwordField.sendKeys(text);

        return this;
    }
    public LogInPO clickSignInButton() {
        if (signInButton == null) {
            signInButton = new ButtonElement(this.driver, LogInLocators.SIGN_IN_BUTTON);
        }
        signInButton.click();

        return new LogInPO(driver);
    }
}
