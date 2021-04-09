package com.locators;

import org.openqa.selenium.By;

public enum CreateNewsPageLocators implements BaseLocator{

    TITLE_PAGE_LABEL(By.xpath("//div[@class='title']/descendant::h2")),//перероблений х-пас
    ADDITIONAL_LABEL(By.xpath("//div[@class='title']/descendant::p")),//перероблений х-пас
    TITLE_NEWS_LABEL(By.xpath("//div[@class='item-block']//descendant::h3")),//перероблений х-пас
    TITLE_FIELD(By.xpath("//div[@class='item-block']/descendant::textarea")),//перероблений х-пас
    SOURCE_FIELD(By.xpath("//input[@formcontrolname='source']")),//перероблений х-пас
    SOURCE_FIELD_LABEL(By.xpath("//input[@formcontrolname='source']/preceding-sibling::h3")),//перероблений х-пас
    BROWSE_PICTURE_BUTTON(By.xpath("//span[text()='browse']")),
    CONTENT_FIELD(By.xpath("//textarea[@name='main-area']")),
    CONTENT_FIELD_LABEL(By.xpath("//div[@class='textarea-wrapper']/child::h3")),
    CANCEL_BUTTON(By.xpath("//button[@class='cancel']")),
    PREVIEW_BUTTON(By.xpath("//button[text()=' Preview ']")),
    PUBLISH_BUTTON(By.xpath("//button[@type='submit']")),
    LANGUAGE_DROPDOWN(By.xpath("//ul[@class='header_lang-switcher-wrp header_navigation-menu-right-list']")),
    EN_BUTTON(By.xpath("//li[text()=' En ']")),
    UA_BUTTON(By.xpath("//li[text()=' Ua ']")),
    RU_BUTTON(By.xpath("//li[text()=' Ru ']")),
    DATE_LABEL(By.xpath("//*[@id='main-content']/div/div[2]/form/div[3]/p[1]/span[1]")),
    AUTHOR_LABEL(By.xpath("//*[@id='main-content']/div/div[2]/form/div[3]/p[2]/span[1]")),

    PREVIEWPAGEBUTTON(By.xpath("//*[@id='main-content']/div/div[2]/form/div[4]/button[2]")),
    BACKTOEDITINGBUTTON(By.xpath("/html/body/app-root/div[3]/app-eco-news/div/app-news-preview-page/div/div[1]/div/a/div/div[2]")),
    //
    //
    CONTENTFIELD_MASSEGA_LABEL(By.xpath("//*[@id='main-content']/div/div[2]/form/div[2]/p"));




    private By path;
    CreateNewsPageLocators (By path){
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}
