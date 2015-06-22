package com.epam.blokhina.pages.impl;

import com.epam.blokhina.pages.base.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BasePage{

    @FindBy(xpath = "(//div[@id and @class]/div/div[@role='button' and @gh])[2]")
    @Getter private WebElement sendLetterButton;

	@FindBy(xpath = "//div[4]/div/a")
	@Getter private WebElement popupMenu;

    @FindBy(xpath = "//div[2]/div[3]/div[2]/a")
    @Getter private WebElement logoutButton;

    @FindBy(xpath = "//a[contains(@href,'https://accounts.google.com/AddSession')]")
    @Getter private WebElement addUserButton;

    @FindBy(xpath = "//div[4]/div[2]/div[2]/a[1]/img")
    @Getter private WebElement anotherUser;

    @FindBy(xpath = "(//span/a)[1]")
    @Getter private WebElement inboxPage;

    @FindBy(name = "cancel")
    @Getter private WebElement strangeWindow;

	@FindBy(xpath = "//div[contains(@role,'button') and (@title='Настройки')]")
	@Getter private WebElement settingsButton;

    @FindBy(xpath = "//div[@id and @role='menu']//div[9]/div")
    @Getter private WebElement selectThemeButton;

    @FindBy(xpath = "(//span/a)[2]")
    @Getter private WebElement starredPage;

    @FindBy(xpath = "//span/span")
    @Getter private WebElement moreButton;

    @FindBy(xpath = "(//div[@id]/div/div[1]/span/a)[8]")
    @Getter private WebElement spamPage;


    public MainPage(WebDriver driver) {
        super(driver);
    }
}
