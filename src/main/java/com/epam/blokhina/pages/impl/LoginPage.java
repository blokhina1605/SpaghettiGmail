package com.epam.blokhina.pages.impl;


import com.epam.blokhina.pages.base.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "gmail-sign-in")
    @Getter private WebElement loginInButton;

	@FindBy(id = "Email")
	@Getter private WebElement emailField;

	@FindBy(id = "next")
	@Getter private WebElement nextButton;

    @FindBy(id = "Passwd")
    @Getter private WebElement passwordField;

	@FindBy(id = "signIn")
	@Getter private WebElement signInButton;


	public LoginPage(WebDriver driver) {
		super(driver);
	}
}
