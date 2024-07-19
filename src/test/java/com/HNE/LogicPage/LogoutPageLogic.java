package com.HNE.LogicPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPageLogic {
    WebDriver driver;

    By logoutID = By.id("logout2");

    public LogoutPageLogic(WebDriver driver) {
        this.driver = driver;

    }

    public void logoutButton() {
        driver.findElement(logoutID).click();

    }
}
