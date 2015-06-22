package com.epam.blokhina.pages.steps;

import com.epam.blokhina.pages.base.BaseSteps;
import org.openqa.selenium.WebDriver;


public class LoginSteps extends BaseSteps{

    public LoginSteps(WebDriver driver) {
        super(driver);
    }

    public MainSteps logIn(String user, String password){
        loginPage.getEmailField().sendKeys(user);
        loginPage.getNextButton().click();
        loginPage.getPasswordField().sendKeys(password);
        loginPage.getSignInButton().click();
        return new MainSteps(driver);
    }
}
