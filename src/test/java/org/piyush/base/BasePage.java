package org.piyush.base;

import com.microsoft.playwright.Page;

public class BasePage {
    protected Page page;

    public BasePage(Page page){
        this.page = page;
    }

    public void navigateTo(String url){
        page.navigate(url);
    }

    public String getTitle(){
        return page.title();
    }

    public void click(String selector){
        page.locator(selector).click();
    }

    public void type(String selector, String value) {
        page.fill(selector, value);
    }

    public String getText(String selector) {
        return page.textContent(selector);
    }

    public void waitForSelector(String selector) {
        page.waitForSelector(selector);
    }

    public boolean isVisible(String selector) {
        return page.isVisible(selector);
    }
}
