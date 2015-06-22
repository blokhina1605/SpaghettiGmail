package com.epam.blokhina.pages.impl;

import com.epam.blokhina.pages.base.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class ContentPage extends BasePage {

    @FindBy(xpath = "//div/div/span/b")
    @Getter private WebElement subjectOfLastLetter;

    @FindBy(xpath = "//td[7]/img")
    @Getter private WebElement attachedFile;

	@FindBy(xpath = "//tbody/tr[2]/td/div[@id]/div/div/div/div")
	@Getter private List<WebElement> themesList;

    @FindBy(xpath = "//div[2]/div[3]/div//div[2]")
    @Getter private WebElement confirmMessage;

	@FindBy(xpath = "//tbody//td/div[@aria-checked='false']/div[1]")
    @Getter private WebElement checkEmail;

	@FindBy(xpath = "(//div[@role='button']/div/div[@class])[3]")
    @Getter private WebElement spamButton;



    public ContentPage(WebDriver driver) {
        super(driver);
    }
}
