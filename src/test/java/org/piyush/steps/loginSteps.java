package org.piyush.steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import org.piyush.base.BasePage;
import org.piyush.config.ConfigReader;
import org.piyush.hooks.Hooks;
import org.piyush.pages.LoginPage;

public class loginSteps {

    @Given("user opens a website")
    public void userOpensAWebsite() {
        LoginPage loginPage = new LoginPage(Hooks.playwrightManager.getPage());

        loginPage.Open(ConfigReader.get("baseUrl"));
        System.out.println("Title: " + loginPage.getPageTitle());
        System.out.println("Heading: " + loginPage.getHeading());

    }
}

