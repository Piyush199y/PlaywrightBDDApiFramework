package org.piyush.pages;

import com.microsoft.playwright.Page;
import org.piyush.base.BasePage;

public class LoginPage extends BasePage {

    private final String headingText = "h1";

    public LoginPage(Page page) {
        super(page);
    }

    public void Open(String url){
        navigateTo(url);
    }

    public String getHeading() {
        return getText(headingText);
    }

    public String getPageTitle() {
        return getTitle();
    }



}
