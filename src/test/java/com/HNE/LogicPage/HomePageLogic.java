package com.HNE.LogicPage;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePageLogic {

    public static int SamsungS6PriceDetail;

    public static  int MacbookPrice;


    WebDriver driver;
    By userID = By.xpath("//*[@id=\"nameofuser\"]");
    By samsungGS6 = By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a");
    By AddToCart = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
    By Cart = By.xpath("//*[@id=\"navbarExample\"]/ul/li[4]/a");
    By HomeTopbar = By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a");
    By PriceDetail = By.xpath("//*[@id=\"tbodyid\"]/h3");
    By laptopMenu = By.xpath("//a[contains(text(),'Laptops')]");
    By MacbookAir = By.xpath("//*[@id=\"tbodyid\"]/div[3]/div/div/h4/a");


    public HomePageLogic(WebDriver driver) {
        this.driver = driver;
    }

    public void ProfileChecker(String expectedUserName) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(3));
        String userIDWeb = wait.until(ExpectedConditions.visibilityOfElementLocated(userID)).getText();

        Assert.assertEquals(expectedUserName, userIDWeb);
    }

    public void ClickSamsungGS6() throws InterruptedException {


        Thread.sleep(Duration.ofSeconds(2).toMillis());


        driver.findElement(samsungGS6).click();

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
