package com.epam.blokhina.pages.impl;

import com.epam.blokhina.pages.base.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ComposeLetterPage extends BasePage{

    @FindBy(xpath = "//input[@name='subjectbox']")
    @Getter private WebElement subjectField;

    @FindBy(xpath = "//textarea[@name='to']")
    @Getter private WebElement reciptientField;

    @FindBy(xpath = "//div[@role='textbox' and @contenteditable]")
    @Getter private WebElement textAreaField;

    @FindBy(xpath = "//div[@command='Files']//div[@id]")
    @Getter private WebElement addFileButton;

	@FindBy(xpath = "//table//td[1]/div/div[@role='button']")
	@Getter private WebElement sendLetterButton;

    public ComposeLetterPage(WebDriver driver) {
        super(driver);
    }
}
