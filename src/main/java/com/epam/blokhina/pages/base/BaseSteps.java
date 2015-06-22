package com.epam.blokhina.pages.base;


import com.epam.blokhina.pages.impl.ComposeLetterPage;
import com.epam.blokhina.pages.impl.ContentPage;
import com.epam.blokhina.pages.impl.LoginPage;
import com.epam.blokhina.pages.impl.MainPage;
import com.epam.blokhina.pages.steps.ContentSteps;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public abstract class BaseSteps {

    @Getter protected WebDriver driver;
    @Getter protected LoginPage loginPage;
    @Getter protected MainPage mainPage;
    @Getter protected ContentPage contentPage;
    @Getter protected ComposeLetterPage composeLetterPage;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
        this.contentPage = new ContentPage(driver);
        this.mainPage = new MainPage(driver);
        this.composeLetterPage = new ComposeLetterPage(driver);
    }

    public ContentSteps goToPage(WebElement link) {
        link.click();
        return new ContentSteps(driver);
    }
}
