package com.locators;

import org.openqa.selenium.By;

public enum CreateNewsPageLocators implements BaseLocator{

    TITLE_PAGE_LABEL(By.xpath("//div[@class='title']/descendant::h2")),
    ADDITIONAL_LABEL(By.xpath("//div[@class='title']/descendant::p")),
    TITLE_NEWS_LABEL(By.xpath("//div[@class='item-block']//descendant::h3")),
    TITLE_FIELD(By.xpath("//div[@class='item-block']/descendant::textarea")),
    CHOOSE_TAGS_LABEL(By.xpath("//div[@class = 'tags item-block ng-untouched ng-pristine ng-valid']/descendant::h3")),
    PICTURE_LABEL(By.xpath("//div[@class = 'right-form-column']/descendant::h3")),
    CHOOSE_PICTURE_LABEL(By.xpath("//div[@class = 'centered']")),
    SOURCE_LABEL(By.xpath("//input[@formcontrolname='source']/preceding-sibling::h3")),
    SOURCE_FIELD(By.xpath("//input[@formcontrolname='source']")),
    SOURCE_FIELD_WARNING_LABEL(By.xpath("//span[@class=\"warning\"]")),
    BROWSE_PICTURE_BUTTON_UPLOAD(By.xpath("//*[contains(@id,'upload')]")),
    BROWSE_PICTURE_BUTTON(By.xpath("//span[text()='browse']")),
    CONTENT_LABEL(By.xpath("//div[@class='textarea-wrapper']/child::h3")),
    CONTENT_FIELD(By.xpath("//textarea[@name='main-area']")),
    CANCEL_BUTTON(By.xpath("//button[@class='cancel']")),
    PREVIEW_BUTTON(By.xpath("//div[@class='submit-buttons']//descendant::button[2]")),
    PUBLISH_BUTTON(By.xpath("//button[@type='submit']")),

    LANGUAGE_DROPDOWN(By.xpath("//ul[@class='header_lang-switcher-wrp header_navigation-menu-right-list']")),
    EN_BUTTON(By.xpath("//span[text()='En']")),
    UA_BUTTON(By.xpath("//span[text()='Ua']")),
    RU_BUTTON(By.xpath("//span[text()='Ru']")),

    DATE_LABEL(By.xpath("//div[@class='date']//descendant::span[1]")),
    CURRENT_DATE_LABEL(By.xpath("//div[@class='date']//descendant::span[2]")),
    AUTHOR_LABEL(By.xpath("//div[@class='date']//descendant::span[3]")),
    AUTHOR_NAME_LABEL(By.xpath("//div[@class='date']//descendant::span[4]")),
    BLANK_AREA(By.xpath("//*[@id='main-content']")),

    PREVIEWPAGEBUTTON(By.xpath("//*[@id='main-content']/div/div[2]/form/div[4]/button[2]")),
    BACKTOEDITINGBUTTON(By.xpath("/html/body/app-root/div[3]/app-eco-news/div/app-news-preview-page/div/div[1]/div/a/div/div[2]")),

    CONTENTFIELD_MASSEGA_LABEL(By.xpath("//*[@id='main-content']/div/div[2]/form/div[2]/p")),
    SUBMIT_BUTTON(By.xpath("//button[text() = 'Submit']"));

    private By path;

    CreateNewsPageLocators(By path) {
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}