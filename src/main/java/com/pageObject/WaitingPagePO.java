package com.pageObject;

import com.elements.LabelElement;
import com.locators.WaitingPageLocators;
import org.openqa.selenium.WebDriver;

public class WaitingPagePO extends BasePage{

    private LabelElement mainLabel;
    private LabelElement informationLabel;

    public WaitingPagePO(WebDriver driver) {
        super(driver);
    }

    public EcoNewsPO waitForEcoNewsPageOpened(){
        return new EcoNewsPO(driver);
    }

    public LabelElement getMainLabel(){
        if (mainLabel == null){
            mainLabel = new LabelElement(this.driver, WaitingPageLocators.MAIN_LABEL_ON_WAITING_PAGE);
        }
        return mainLabel;
    }

    public LabelElement getInformationLabel(){
        if (informationLabel == null){
            informationLabel = new LabelElement(this.driver, WaitingPageLocators.INFORMATION_LABEL_ON_WAITING_PAGE);
        }
        return informationLabel;
    }
}
