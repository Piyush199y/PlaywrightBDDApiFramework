package org.piyush.manager;

import com.microsoft.playwright.*;
import org.piyush.config.ConfigReader;

public class PlaywrightManager {

    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    public void initBrowser(){
        Playwright playwright = Playwright.create();
        String browserName = ConfigReader.get("browser");

        BrowserType.LaunchOptions options =
                new BrowserType.LaunchOptions().setHeadless(false);

        switch (browserName.toLowerCase()) {

            case "firefox": {
                browser = playwright.firefox().launch(options);
                break;
            }

            case "webkit": {
                browser = playwright.webkit().launch(options);
                break;
            }

            case "chromium":
            default: {
                browser = playwright.chromium().launch(options);
                break;
            }
        }

        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null)); // MAXIMIZE IN PLAYWRIGHT
        page = context.newPage();
    }

    public Page getPage(){
        return  page;
    }

    public void closeBrowser(){
        if (page != null) {
            page.close();
        }
        if (context != null) {
            context.close();
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}
