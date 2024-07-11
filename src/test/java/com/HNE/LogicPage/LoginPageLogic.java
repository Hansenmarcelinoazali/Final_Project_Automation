package com.HNE.LogicPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageLogic {
    WebDriver driver;
    By loginButton = By.xpath("//*[@id=\"login2\"]");
    By UserNameBox = By.id("loginusername");
    By PasswordBox = By.id("loginpassword");
    By Login = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");

    public LoginPageLogic(WebDriver driver) {
        this.driver = driver;
    }

    public void GoToLoginPage() {
        driver.get("https://www.demoblaze.com/index.html");
    }

    public void LoginButton() {

        driver.findElement(loginButton).click();
    }

    public void InputUsernameLogin(String UserName) throws InterruptedException {

        Thread. sleep(Duration.ofSeconds(20).toMillis());
        driver.findElement(UserNameBox).sendKeys(UserName);
    }

    public void InputPasswordLogin(String PassLogin) {
        driver.findElement(PasswordBox).sendKeys(PassLogin);
    }

    public void ClickLogin() {
        driver.findElement(Login).click();
    }

    public void loginDisplay() {
        driver.findElement(loginButton).isDisplayed();
    }
}
