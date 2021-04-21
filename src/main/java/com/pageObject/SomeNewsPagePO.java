package com.pageObject;

import com.elements.ButtonElement;
import com.elements.LabelElement;
import com.locators.SomeNewsPageLocators;
import com.tools.WaitsSwitcher;
import org.openqa.selenium.WebDriver;

public class SomeNewsPagePO extends BasePage {

    private ButtonElement editNewsButton;
    private LabelElement titleLabel;
    private LabelElement contentLabel;

    public EditNewsPagePO clickEditNewsButton() {
        WaitsSwitcher.sleep(5000);
        if (editNewsButton == null) {
            editNewsButton = new ButtonElement(this.driver, SomeNewsPageLocators.EDIT_NEWS_BUTTON);
        }
        editNewsButton.click();
        return new EditNewsPagePO(driver);
    }

    public LabelElement getTitleOnNewsPage() {
        if (titleLabel == null) {
            titleLabel = new LabelElement(this.driver, SomeNewsPageLocators.TITLE_LABEL_ON_DONE_PAGE);
        }
        return titleLabel;
    }

    public LabelElement getContentOnNewsPage() {
        if (contentLabel == null) {
            contentLabel = new LabelElement(this.driver, SomeNewsPageLocators.CONTENT_LABEL_ON_DONE_PAGE);
        }
        return contentLabel;
    }

    public SomeNewsPagePO(WebDriver driver) {
        super(driver);
    }
}

