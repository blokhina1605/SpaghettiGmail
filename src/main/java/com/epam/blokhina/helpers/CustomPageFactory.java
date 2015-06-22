package com.epam.blokhina.helpers;


import org.openqa.selenium.WebDriver;

import java.util.ArrayList;


public class CustomPageFactory {

    public static void goToNewWindow(WebDriver driver) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }
}
