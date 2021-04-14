package com.pageObject;

import com.elements.ButtonElement;
import com.elements.LabelElement;
import com.locators.CreateNewsPageLocators;
import com.locators.PreviewPageLocators;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class PreviewPO extends BasePage{
    ButtonElement backToEditingButton;
    ButtonElement publishNewsButton;
    LabelElement newsTitleLabel;
    LabelElement newsContentLabel;
    LabelElement titleBackLabel;


    public PreviewPO(WebDriver driver) {
        super(driver);
    }

    public CreateNewsPO clickBackToEditingButton(){
        if(backToEditingButton == null){
            backToEditingButton = new ButtonElement(this.driver, PreviewPageLocators.BACK_TO_EDITING_BUTTON);
        }
        backToEditingButton.click();

        return new CreateNewsPO(driver);
    }

    public LabelElement getBackToEditingButton() {
        if (titleBackLabel == null) {
            titleBackLabel = new LabelElement(this.driver, PreviewPageLocators.BACK_TO_EDITING_BUTTON);
        }
        return titleBackLabel;
    }

    public LabelElement getTitleLabel(){
        if(newsTitleLabel == null){
            newsTitleLabel = new LabelElement(this.driver, PreviewPageLocators.TITLE_LABEL);
        }
        return newsTitleLabel;
    }

    public LabelElement getContentLabel(){
        if(newsContentLabel == null){
            newsContentLabel = new LabelElement(this.driver, PreviewPageLocators.TEXT_CONTENT);
        }
        return newsContentLabel;
    }

    public boolean isPublishButtonExists(){
        if(publishNewsButton == null){
            try {
                publishNewsButton = new ButtonElement(this.driver, PreviewPageLocators.PUBLISH_BUTTON);
            } catch (NoSuchElementException e){
                return false;
            }
        }
        return true;
    }

    public EcoNewsPO clickPublishButton(){
        if(publishNewsButton == null){
            publishNewsButton = new ButtonElement(this.driver, PreviewPageLocators.PUBLISH_BUTTON);
        }
        publishNewsButton.click();
        return new EcoNewsPO(driver);
    }

    public boolean isDisplayed(){
        if(publishNewsButton == null){
            publishNewsButton = new ButtonElement(this.driver, PreviewPageLocators.PUBLISH_BUTTON);
        }
        return publishNewsButton.isDisplayed();
    }
}