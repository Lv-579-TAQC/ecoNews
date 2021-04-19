package com.locators;

import org.openqa.selenium.By;

public enum EditDonePageLocators implements BaseLocator{
    TITLE_FIELD(By.xpath("(//textarea[@placeholder='e.g. Coffee takeaway with 20% discount'])")),
    CONTENT_FIELD(By.xpath("(//textarea[@placeholder='e.g. Short description of news, agenda for event'])")),
    EDIT_BUTTON(By.xpath("(//button[@type='submit'])")),
    PREVIEW_BUTTON_ON_EDIT_NEWS_PAGE(By.xpath("//button[.=' Preview ']")),
    CANCEL_BUTTON_ON_EDIT_NEWS_PAGE(By.xpath("//button[@class='cancel']"));

    private By path;
    EditDonePageLocators (By path){
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}