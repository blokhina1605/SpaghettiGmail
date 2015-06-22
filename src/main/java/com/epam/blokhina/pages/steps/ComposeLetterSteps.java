package com.epam.blokhina.pages.steps;

import com.epam.blokhina.helpers.FileUploader;
import com.epam.blokhina.helpers.Waiter;
import com.epam.blokhina.pages.base.BaseSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;


public class ComposeLetterSteps extends BaseSteps {

    private static final By PROGRESS_BAR_LOCATOR = xpath("//div[@role='progressbar']");
    public ComposeLetterSteps(WebDriver driver) {
        super(driver);
    }

    public ComposeLetterSteps composeLetter(String recipient, String subject, String content) {
        composeLetterPage.getReciptientField().sendKeys(recipient);
        composeLetterPage.getSubjectField().sendKeys(subject);
        composeLetterPage.getTextAreaField().sendKeys(content);
        return this;
    }

    public ComposeLetterSteps composeLetter(String recipient, String subject, String content, String filePath) {
        composeLetter(recipient, subject, content);
        composeLetterPage.getAddFileButton().click();
        FileUploader.uploadFile(filePath);
        Waiter.waitForElementNotVisible(driver, PROGRESS_BAR_LOCATOR);
        return this;
    }

    public MainSteps sendLetter(){
        composeLetterPage.getSendLetterButton().click();
        return new MainSteps(driver);
    }
}
