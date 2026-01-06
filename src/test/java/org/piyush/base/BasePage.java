package org.piyush.base;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

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

    public void waitForSelectorIn(String selector) {
        page.locator(selector).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
    }

    public boolean isVisible(String selector) {
        return page.isVisible(selector);
    }
}
