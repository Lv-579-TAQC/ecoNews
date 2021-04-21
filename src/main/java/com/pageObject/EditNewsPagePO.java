package com.pageObject;

import com.elements.ButtonElement;
import com.elements.FieldElement;
import com.locators.EditDonePageLocators;
import com.tools.WaitsSwitcher;
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
            contentField = new FieldElement(this.driver, EditDonePageLocators.CONTENT_FIELD_ON_EDIT_NEWS_PAGE);
        }
        contentField.sendKeys(content);
        return this;
    }

    public EditNewsPagePO clearContentOnEditPage() {
        if (clearContentField == null) {
            clearContentField = new FieldElement(this.driver, EditDonePageLocators.CONTENT_FIELD_ON_EDIT_NEWS_PAGE);
        }
        clearContentField.clear();
        return this;
    }

    public EditNewsPagePO setTitleOnEditPage(String content) {
        if (titleField == null) {
            titleField = new FieldElement(this.driver, EditDonePageLocators.TITLE_FIELD_ON_EDIT_NEWS_PAGE);
        }
        titleField.sendKeys(content);
        return this;
    }

    public EditNewsPagePO clearTitleFieldOnEditPage(){
        WaitsSwitcher.sleep(3000);
        if (clearTitleField == null) {
            clearTitleField = new FieldElement(this.driver, EditDonePageLocators.TITLE_FIELD_ON_EDIT_NEWS_PAGE);
        }
        clearTitleField.clear();
        return new EditNewsPagePO(driver);
    }

    public EcoNewsPO clickEditButton() {
        if (editButton == null) {
            editButton = new ButtonElement(this.driver, EditDonePageLocators.EDIT_BUTTON_ON_EDIT_NEWS_PAGE);
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