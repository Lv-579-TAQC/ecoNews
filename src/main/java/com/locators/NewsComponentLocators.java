package com.locators;

import org.openqa.selenium.By;

public enum NewsComponentLocators implements BaseLocator{
    NEWS_TAG(By.cssSelector(".filter-tag div")),
    NEWS_TITLE(By.cssSelector("div.title-list.word-wrap")),
    NEWS_CONTENT(By.cssSelector("div.list-text.word-wrap")),
    NEWS_IMAGE(By.cssSelector(".list-image")),

    NEWS_TAG_LIST(By.cssSelector(".filter-tag span")),
    NEWS_TITLE_LIST(By.cssSelector("div.eco-news_list-content-title.one-row")),
    NEWS_CONTENT_LIST(By.cssSelector(".eco-news_list-content-text.tree-row")),
    NEWS_IMAGE_LIST(By.cssSelector(".eco-news_list-img")),

    NEWS_ITEMS(By.cssSelector("ul.list>li"))
    ;

    private By path;

    NewsComponentLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
