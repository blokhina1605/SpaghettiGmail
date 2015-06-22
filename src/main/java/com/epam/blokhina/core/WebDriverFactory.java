package com.epam.blokhina.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;


public class WebDriverFactory {
    private static WebDriver driver;

    public static WebDriver init(String browserName) {
        if (driver == null) {
            switch (browserName) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "driversLib\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "opera":
                    System.setProperty("webdriver.opera.driver", "driversLib\\operadriver64.exe");
                    driver = new OperaDriver();
                    break;
                case "ie":
                    System.setProperty("webdriver.ie.driver", "driversLib\\IEDriverServer64.exe");
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    driver = new FirefoxDriver();
                    break;

            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }
}
