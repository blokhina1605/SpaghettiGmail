package com.epam.blokhina.pages.steps;

import com.epam.blokhina.helpers.CustomPageFactory;
import com.epam.blokhina.helpers.Waiter;
import com.epam.blokhina.pages.base.BaseSteps;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


public class MainSteps extends BaseSteps {


    public MainSteps(WebDriver driver) {
        super(driver);
    }

    public ComposeLetterSteps createNewLetter() {
        mainPage.getSendLetterButton().click();
        try {if (mainPage.getStrangeWindow().isDisplayed()) mainPage.getStrangeWindow().click();}
        catch (NoSuchElementException ex){}
        return new ComposeLetterSteps(driver);
    }

    public MainSteps changeUser(String user, String password) {
        mainPage.getPopupMenu().click();
        if (mainPage.getAnotherUser().isDisplayed()) {
            mainPage.getAnotherUser().click();
            CustomPageFactory.goToNewWindow(driver);
            Waiter.waitForPageLoad(driver);
            return new MainSteps(driver);
        } else {
            mainPage.getAddUserButton().click();
            CustomPageFactory.goToNewWindow(driver);
            return new LoginSteps(driver).logIn(user, password);
        }
    }

    public ContentSteps clickSelectTheme(){
        mainPage.getSettingsButton().click();
        mainPage.getSelectThemeButton().click();
        return new ContentSteps(driver);
    }

    public MainSteps clickMoreButton(){
        mainPage.getMoreButton().click();
        return this;
    }
}
