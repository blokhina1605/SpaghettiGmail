package com.epam.blokhina.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;


public class Waiter {

    public static void waitForElementNotVisible(WebDriver driver, By locator) {
        Wait wait = new FluentWait(driver)
                .pollingEvery(2, TimeUnit.SECONDS)
                .withTimeout(25, TimeUnit.SECONDS)
                .ignoring(WebDriverException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForPageLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = driver1 -> ((JavascriptExecutor) driver1).executeScript(
                "return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }
}
