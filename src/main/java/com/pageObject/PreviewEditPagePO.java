package com.pageObject;

import com.elements.ButtonElement;
import com.elements.LabelElement;
import com.locators.PreviewEditPageLocators;
import org.openqa.selenium.WebDriver;

public class PreviewEditPagePO extends BasePage {

    private ButtonElement editButton;
    private LabelElement titleLabel;
    private LabelElement contentLabel;

    public PreviewEditPagePO(WebDriver driver) {
        super(driver);
    }

    public EcoNewsPO clickEditButtonOnPreviewEditPage() {
        if (editButton == null) {
            editButton = new ButtonElement(this.driver, PreviewEditPageLocators.EDIT_BUTTON_ON_PREVIEW_EDIT_PAGE);
        }
        editButton.click();
        return new EcoNewsPO(driver);
    }

    public LabelElement getTitleLabelOnPreviewEditPage() {
        if (titleLabel == null) {
            titleLabel = new LabelElement(this.driver, PreviewEditPageLocators.TITLE_ON_PREVIEW_EDIT_PAGE);
        }
        return titleLabel;
    }

    public LabelElement getContentLabelOnPreviewEditPage(){
        if (contentLabel == null){
            contentLabel = new LabelElement(this.driver, PreviewEditPageLocators.CONTENT_ON_PREVIEW_EDIT_PAGE);
        }
        return contentLabel;
    }
}



