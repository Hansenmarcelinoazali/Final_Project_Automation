package com.HNE.LogicPage;

import com.HNE.BaseTest;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.codehaus.groovy.transform.ThreadInterruptibleASTTransformation;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePageLogic {

    public static int SamsungS6PriceDetail;

    public static  int MacbookPrice;


    WebDriver driver;
    By userID = By.id("nameofuser");
    By samsungGS6 = By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a");
    By AddToCart = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
    By Cart = By.xpath("//*[@id=\"navbarExample\"]/ul/li[4]/a");
    By HomeTopbar = By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a");
    By PriceDetail = By.cssSelector("h3.price-container");
    By laptopMenu = By.xpath("//a[contains(text(),'Laptops')]");
    By MacbookAir = By.xpath("//*[@id=\"tbodyid\"]/div[3]/div/div/h4/a");


    public HomePageLogic(WebDriver driver) {
        this.driver = driver;
    }

    public void ProfileChecker(String expectedUserName) throws InterruptedException{


        Thread.sleep(Duration.ofSeconds(30).toMillis());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String userIDWeb = wait.until(ExpectedConditions.visibilityOfElementLocated(userID)).getText();

        System.out.println(userIDWeb);

        Assert.assertEquals(expectedUserName, userIDWeb);
    }

    public void ClickSamsungGS6() throws InterruptedException {

//        Thread.sleep(Duration.ofSeconds(30).toMillis());
//        driver.findElement(samsungGS6).click();
//        Thread.sleep(Duration.ofSeconds(10).toMillis());


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            WebElement samsungGS6Element = wait.until(ExpectedConditions.visibilityOfElementLocated(samsungGS6));
            samsungGS6Element.click();
        } catch (StaleElementReferenceException e) {
            // Log the exception or handle accordingly
            System.out.println("StaleElementReferenceException caught. Trying to find the element again.");
            WebElement samsungGS6Element = wait.until(ExpectedConditions.visibilityOfElementLocated(samsungGS6));
            samsungGS6Element.click();
        }

    }

    public void ClickAddToCartButton() {

        String getPriceSamsung = driver.findElement(PriceDetail).getText();

        String priceSamsungString = getPriceSamsung.replaceAll("[^0-9]", "");

        SamsungS6PriceDetail = Integer.parseInt(priceSamsungString);

        driver.findElement(AddToCart).click();

        System.out.println("ini harga samsung "+ SamsungS6PriceDetail);
    }

    public void GetAlertText(String alertExpected) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        String textAlert = alert.getText();

        Assert.assertEquals(alertExpected, textAlert);

        alert.accept();

    }

    public void clickCart() {
        driver.findElement(Cart).click();
    }


    public void homeButtonTopBar() {
        driver.findElement(HomeTopbar).click();
    }

    public void ClickMacbook() throws InterruptedException {

        Thread.sleep(Duration.ofSeconds(2).toMillis());


        driver.findElement(MacbookAir).click();
    }

    public void ClickLaptopMenu() {
        driver.findElement(laptopMenu).click();
    }

    public void AddtoCartMacbook(){
        String getPriceMacbook = driver.findElement(PriceDetail).getText();

        String priceMacbookString = getPriceMacbook.replaceAll("[^0-9]", "");

        MacbookPrice = Integer.parseInt(priceMacbookString);

        driver.findElement(AddToCart).click();

        System.out.println("ini harga macbook" + MacbookPrice);


    }

}
