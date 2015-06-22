package com.epam.blokhina;

import com.epam.blokhina.core.DriverManager;
import com.epam.blokhina.core.PropertyManager;

import com.epam.blokhina.pages.steps.LoginSteps;
import com.epam.blokhina.pages.steps.MainSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class BaseTest {

    protected static final String FIRST_USER_LOGIN = PropertyManager.getPropertyByName("user1");
    protected static final String PASSWORD = PropertyManager.getPropertyByName("password");
    protected static final String SECOND_USER_LOGIN = PropertyManager.getPropertyByName("user2");

    protected static final String SUBJECT_OF_LETTER = "subject";
    protected static final String CONTENT_OF_LETTER = "content";

    protected WebDriver driver;
    protected LoginSteps loginSteps;
    protected MainSteps mainSteps;



    @BeforeTest
    public void setUp() {
        driver = DriverManager.getInstance();
        driver.get(PropertyManager.getPropertyByName("url"));
        loginSteps = new LoginSteps(driver);
        mainSteps = new MainSteps(driver);
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}
