package com.epam.blokhina.core;

import org.openqa.selenium.WebDriver;


public class DriverManager {

    private static final String BROWSER_PROPERTY = "browser";
    public static WebDriver getInstance() {
        return WebDriverFactory.init(PropertyManager.getPropertyByName(BROWSER_PROPERTY));
    }
}
