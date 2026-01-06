package org.piyush.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.piyush.hooks.Hooks;
import org.piyush.pages.NaukariPage;

public class NaukriSteps {
    public NaukariPage naukariPage;
    @Given("User lands on home page after login to {string}")
    public void userLandsOnHomePageAfterLoginTo(String arg0) {
        naukariPage = new NaukariPage(Hooks.playwrightManager.getPage());
        naukariPage.userLoginToNaukri(arg0);
    }

    @When("User update the profile")
    public void userUpdateTheProfile() {
        naukariPage.userUpdateProfile();
        naukariPage.userUploadsResume();
        naukariPage.userUpdateProfileSummary();
    }

    @And("Upload a new resume")
    public void uploadANewResume() {
    }

    @Then("The profile should get updated")
    public void theProfileShouldGetUpdated() {
    }
}
