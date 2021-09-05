package com.pageObject;

import com.elements.ButtonElement;
import com.elements.LabelElement;
import com.locators.PreviewPageLocators;
import com.tools.WaitsSwitcher;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class PreviewPO extends BasePage{
    private ButtonElement backToEditingButton;
    private ButtonElement publishNewsButton;
    private LabelElement newsTitleLabel;
    private LabelElement newsContentLabel;
    private LabelElement titleBackLabel;
    private WaitsSwitcher waitsSwitcher;
    private LabelElement dateLabel;
    private LabelElement authorLabel;


    public PreviewPO(WebDriver driver) {
        super(driver);
        waitsSwitcher = new WaitsSwitcher(driver);
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

    public LabelElement getDateLabel(){
        if(dateLabel == null){
            dateLabel = new LabelElement(this.driver, PreviewPageLocators.DATE_LABEL);
        }
        return dateLabel;
    }

    public LabelElement getAuthorLabel(){
        if(authorLabel == null){
            authorLabel = new LabelElement(this.driver, PreviewPageLocators.AUTHOR_LABEL);
        }
        return authorLabel;
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

    public EcoNewsPO clickPublishButtonFromPreviewPage(){
        if(publishNewsButton == null){
            publishNewsButton = new ButtonElement(this.driver, PreviewPageLocators.PUBLISH_BUTTON);
        }
        publishNewsButton.click();
        waitsSwitcher.setImplicitWaits(35);
        return new EcoNewsPO(driver);
    }
}
