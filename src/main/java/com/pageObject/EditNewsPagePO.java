package com.pageObject;

import com.elements.ButtonElement;
import com.elements.FieldElement;
import com.locators.EditDonePageLocators;
import org.openqa.selenium.WebDriver;

public class EditNewsPagePO extends BasePage{

    private FieldElement titleField;
    private FieldElement contentField;
    private ButtonElement editButton;
    private FieldElement clearTitleField;
    private FieldElement clearContentField;
    private ButtonElement previewButton;
    private ButtonElement cancelButton;

    public EditNewsPagePO(WebDriver driver) {
        super(driver);
    }

    public EditNewsPagePO setContentOnEditPage(String content) {
        if (contentField == null) {
            contentField = new FieldElement(this.driver, EditDonePageLocators.CONTENT_FIELD);
        }
        contentField.sendKeys(content);
        return this;
    }

    public EditNewsPagePO clearContentOnEditPage(String content) {
        if (clearContentField == null) {
            clearContentField = new FieldElement(this.driver, EditDonePageLocators.CONTENT_FIELD);
        }
        clearContentField.sendKeys(content);
        return this;
    }

    public EditNewsPagePO setTitleOnEditPage(String content) {
        if (titleField == null) {
            titleField = new FieldElement(this.driver, EditDonePageLocators.TITLE_FIELD);
        }
        titleField.sendKeys(content);
        return this;
    }

    public EditNewsPagePO clearTitleFieldOnEditPage(String content){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (clearTitleField == null) {
            clearTitleField = new FieldElement(this.driver, EditDonePageLocators.TITLE_FIELD);
        }

        clearTitleField.sendKeys(content);
        return this;
    }

    public EcoNewsPO clickEditButton() {
        if (editButton == null) {
            editButton = new ButtonElement(this.driver, EditDonePageLocators.EDIT_BUTTON);
        }
        editButton.click();
        return new EcoNewsPO(driver);
    }

    public PreviewEditPagePO clickPreviewButtonOnEditNewsPage() {
        if (previewButton == null) {
            previewButton = new ButtonElement(this.driver, EditDonePageLocators.PREVIEW_BUTTON_ON_EDIT_NEWS_PAGE);
        }
        previewButton.click();
        return new PreviewEditPagePO(driver);
    }

    public EcoNewsPO clickCancelButtonOnEditNewsPage() {
        if (cancelButton == null) {
            cancelButton = new ButtonElement(this.driver, EditDonePageLocators.CANCEL_BUTTON_ON_EDIT_NEWS_PAGE);
        }
        cancelButton.click();
        return new EcoNewsPO(driver);
    }
}