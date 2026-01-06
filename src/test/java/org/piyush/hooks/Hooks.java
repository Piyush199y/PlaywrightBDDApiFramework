package org.piyush.hooks;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.piyush.config.ConfigReader;
import org.piyush.manager.PlaywrightManager;
import org.testng.annotations.BeforeTest;

public class Hooks {
    public static PlaywrightManager playwrightManager;

    @Before
    public void setUp(){
        ConfigReader.loadConfig();
        playwrightManager = new PlaywrightManager();
        playwrightManager.initBrowser();
    }

    @After
    public void tearDown(){
        playwrightManager.closeBrowser();
    }

}
