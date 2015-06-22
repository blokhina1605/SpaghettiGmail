package com.epam.blokhina.pages.base;


import lombok.Getter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {
    @Getter
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
