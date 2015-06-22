package com.epam.blokhina.pages.steps;


import com.epam.blokhina.pages.base.BaseSteps;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;


public class ContentSteps extends BaseSteps {

    public ContentSteps(WebDriver driver) {
        super(driver);
    }

    public boolean verifyLetterPresent(String subject) {
        try {
            if (contentPage.getSubjectOfLastLetter().getText().equals(subject)) {
                return true;
            }
        } catch (NoSuchElementException ex) {
            return false;
        }
        return false;
    }

    public boolean verifyLetterWithFilePresent(String subject) {
        boolean cond = contentPage.getSubjectOfLastLetter().getText().equals(subject);
        boolean secCond = contentPage.getAttachedFile().isDisplayed();
        try {
            if (cond && secCond) {
                return true;
            }
        } catch (NoSuchElementException ex) {
            return false;
        }
        return false;
    }

    public ContentSteps chooseRandomTheme() {
        List<WebElement> themes = contentPage.getThemesList();
        Random random = new Random(themes.size());
        int randomNum = random.nextInt(themes.size());
        themes.get(randomNum).click();
        return this;
    }

    public boolean verifyConfirmMessage() {
        return contentPage.getConfirmMessage().isDisplayed();
    }

    public ContentSteps dragLetterToStarred() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(contentPage.getSubjectOfLastLetter(), mainPage.getStarredPage()).perform();
        return new ContentSteps(driver);
    }

    public MainSteps markLetterAsSpam() {
        contentPage.getCheckEmail().click();
        contentPage.getSpamButton().click();
        return new MainSteps(driver);
    }
}
