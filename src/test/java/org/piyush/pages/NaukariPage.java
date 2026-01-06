package org.piyush.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.piyush.base.BasePage;
import org.piyush.config.ConfigReader;

import java.nio.file.Paths;

public class NaukariPage extends BasePage {

    private final String userNameInput = "//input[@id='usernameField']";
    private final String passwordInput = "//input[@id='passwordField']";
    private final String loginButton = "//button[text()='Login']";
    private final String profileButton = "//a[text()=' profile']";
    private final String deleteResButton = "//span[@data-title='delete-resume']";
    private final String deleteConfirm = "//p[contains(text(),'delete the resume')]/../div/button[text()='Delete']";
    private final String uploadResumeInput = "#attachCV";
    private final String resumeHeadline = "#resumeHeadlineTxt";
    private final String editResume = "//span[contains(text(),'headline')]/following-sibling::span[text()='editOneTheme']";
    private final String saveButton = "//button[text()='Save']";

    public NaukariPage(Page page){
        super(page);
    }

    public void userLoginToNaukri(String url){
        String baseUrl = ConfigReader.get(url);
        System.out.println("User navigating to : "+baseUrl);
        page.navigate(baseUrl);
        String title = getTitle();
        System.out.println("Page title is : "+title);

        page.fill(userNameInput, ConfigReader.get("NaukariUser"));
        page.fill(passwordInput, ConfigReader.get("NaukariPass"));
        page.click(loginButton);
    }

    public void userUpdateProfile(){

        page.click(profileButton);
        try{
            page.click(deleteResButton);
            page.click(deleteConfirm);
            System.out.println("Resume is removed");
        }catch(Exception e){
            System.out.println("Resume is missing");
        }

    }

    public void userUploadsResume(){
        page.locator(uploadResumeInput).scrollIntoViewIfNeeded();
        String filePath = "src/test/resources/Piyush_Bansod_Resume.pdf";
        page.setInputFiles(uploadResumeInput, Paths.get(filePath));
        System.out.println("Resume is Uploaded successfully");
    }

    public void userUpdateProfileSummary(){
        page.click(editResume);
        String existingText = page.getAttribute(resumeHeadline,"value");

        if (existingText.length() == 250) {
            char lastChar = existingText.charAt(existingText.length() - 1);
            String modifiedText = existingText.substring(0, existingText.length() - 1);

            page.locator(resumeHeadline).fill("");
            page.locator(resumeHeadline).fill(modifiedText);
            page.locator(resumeHeadline).fill(String.valueOf(lastChar));

        } else {
            page.locator(resumeHeadline).fill("");
            page.locator(resumeHeadline).fill(existingText);
        }

        page.click(saveButton);
    }
}
