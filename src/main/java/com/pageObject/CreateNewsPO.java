package com.pageObject;

import com.elements.ButtonElement;
import com.elements.FieldElement;
import com.elements.LabelElement;
import com.locators.CreateNewsPageLocators;
import com.locators.TagComponentLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CreateNewsPO extends BasePage {

    ButtonElement languageDropdown;
    ButtonElement uaButton;
    ButtonElement enButton;
    ButtonElement ruButton;

    FieldElement titleField;
    FieldElement sourceField;
    FieldElement contentField;

    LabelElement titlePageLabel;
    LabelElement additionalLabel;
    LabelElement titleNewsLabel;
    LabelElement newsTagLabel;
    LabelElement sourceFieldLabel;
    LabelElement contentFieldLabel;
    LabelElement dateLabel;
    LabelElement authorLabel;

    TagComponent tags;

    ButtonElement previewButton;


    public CreateNewsPO(WebDriver driver) {
        super(driver);
    }

    public CreateNewsPO clickLanguageDropdown() {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        if (languageDropdown == null) {
            languageDropdown = new ButtonElement(this.driver, CreateNewsPageLocators.LANGUAGE_DROPDOWN);
        }
        languageDropdown.click();

        return this;
    }

    private void clear() {
        languageDropdown = null;
        uaButton = null;
        enButton = null;
        ruButton = null;

        titleField = null;
        sourceField = null;
        contentField = null;

        titlePageLabel = null;
        additionalLabel = null;
        titleNewsLabel = null;
        newsTagLabel = null;
        sourceFieldLabel = null;
        contentFieldLabel = null;
        dateLabel = null;
        authorLabel = null;

        tags = null;

        previewButton = null;
    }

    public CreateNewsPO clickUaButton() {
        //driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        if (uaButton == null) {
            uaButton = new ButtonElement(this.driver, CreateNewsPageLocators.UA_BUTTON);
        }
        uaButton.click();
        clear();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new CreateNewsPO(driver);
    }

    public CreateNewsPO clickEnButton() {
        if (enButton == null) {
            enButton = new ButtonElement(this.driver, CreateNewsPageLocators.EN_BUTTON);
        }
        enButton.click();

        return new CreateNewsPO(driver);
    }

    public CreateNewsPO clickRuButton() {
        if (ruButton == null) {
            ruButton = new ButtonElement(this.driver, CreateNewsPageLocators.RU_BUTTON);
        }
        ruButton.click();

        return new CreateNewsPO(driver);
    }


    public CreateNewsPO setTitle(String title) {
        if (titleField == null) {
            titleField = new FieldElement(this.driver, CreateNewsPageLocators.TITLE_FIELD);
        }
        titleField.sendKeys(title);

        return this;
    }

    public LabelElement getTitlePageLabel() {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if (titlePageLabel == null) {
            titlePageLabel = new LabelElement(this.driver, CreateNewsPageLocators.TITLE_PAGE_LABEL);
        }


//        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

//        WebDriverWait wait = new WebDriverWait(driver,10);
//        WebElement explicitWait = wait
//                .until(ExpectedConditions.visibilityOfElementLocated(CreateNewsPageLocators.TITLE_PAGE_LABEL.getPath());
//        if (titlePageLabel == null) {
//            titlePageLabel = new LabelElement(this.driver, CreateNewsPageLocators.TITLE_PAGE_LABEL);
//        }
//       titlePageLabel = new LabelElement(explicitWait);
        return titlePageLabel;
    }

    public LabelElement getAdditionalLabel() {
        if (additionalLabel == null) {
            additionalLabel = new LabelElement(this.driver, CreateNewsPageLocators.ADDITIONAL_LABEL);
        }
        return additionalLabel;

    }

    public TagComponent getTags() {
        if (tags == null) {
            tags = new TagComponent(this.driver);
        }
        return tags;
    }

    public LabelElement getNewsTagLabel() {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        if (newsTagLabel == null) {
            newsTagLabel = new LabelElement(this.driver, TagComponentLocators.NEWS_TAGBUTTON);
        }
        return newsTagLabel;
    }


    public LabelElement getSourceFieldLabel() {
        if (sourceFieldLabel == null) {
            sourceFieldLabel = new LabelElement(this.driver, CreateNewsPageLocators.SOURCE_FIELD_LABEL);
        }
        return sourceFieldLabel;

    }

    public LabelElement getContentFieldLabel() {
        if (contentFieldLabel == null) {
            contentFieldLabel = new LabelElement(this.driver, CreateNewsPageLocators.CONTENT_FIELD_LABEL);
        }
        return contentFieldLabel;

    }

    public LabelElement getTitleNewsLabel() {
        if (titleNewsLabel == null) {
            titleNewsLabel = new LabelElement(this.driver, CreateNewsPageLocators.TITLE_NEWS_LABEL);
        }
        return titleNewsLabel;

    }


    public LabelElement getDateLabel() {
        if (dateLabel == null) {
            dateLabel = new LabelElement(this.driver, CreateNewsPageLocators.DATE_LABEL);
        }
        return dateLabel;

    }

    public LabelElement getAuthorLabel() {
        if (authorLabel == null) {
            authorLabel = new LabelElement(this.driver, CreateNewsPageLocators.AUTHOR_LABEL);
        }
        return authorLabel;

    }


    public CreateNewsPO setSource(String source) {
        if (sourceField == null) {
            sourceField = new FieldElement(this.driver, CreateNewsPageLocators.SOURCE_FIELD);
        }
        sourceField.sendKeys(source);

        return this;
    }

    public CreateNewsPO setContent(String content) {
        if (contentField == null) {
            contentField = new FieldElement(this.driver, CreateNewsPageLocators.CONTENT_FIELD);
        }
        contentField.sendKeys(content);

        return this;
    }

    //
//
//    public EcoNewsPO clickCancelButton() {
//        cancelButton.click();
//
//        return new EcoNewsPO(driver);
//    }
//
    public PreviewPO clickPreviewButton() {
        if (previewButton == null) {
            previewButton = new ButtonElement(this.driver, CreateNewsPageLocators.PREVIEW_BUTTON);
        }
        previewButton.click();

        return new PreviewPO(driver);
    }


}
