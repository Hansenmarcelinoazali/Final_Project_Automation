package com.HNE.LogicPage;

import io.cucumber.java.bs.A;
import org.junit.Assert;
import org.junit.Assume;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class CartPageLogic {
    public static int samsungPriceCart;
    public static int macbookPriceCart;
    WebDriver driver;
    By samsungInCart = By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]");
    By deleteButton = By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[4]/a");

    By finalPriceVar = By.xpath("//*[@id=\"totalp\"]");

    By placeHolderButton = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");

    By cartButtonWithoutProduct = By.id("cartur");

    By popUpPlaceholder = By.xpath("//*[@id=\"orderModal\"]/div/div/div[2]");

    By inputName = By.xpath("//*[@id=\"name\"]");
    By inputCountryName = By.id("country");
    By inputCityName = By.id("city");
    By inputCard = By.id("card");
    By inputMonth = By.id("month");
    By inputYear = By.id("year");

    By popUpAppear = By.xpath("/html/body/div[10]");

    By purchaseButton = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");


    public CartPageLogic(WebDriver driver) {
        this.driver = driver;
    }

    public void samsungInCart(String expectedSamsungS6) {
        String getSamsung = driver.findElement(samsungInCart).getText();

        Assert.assertEquals(expectedSamsungS6, getSamsung);
    }

//    public void deleteButtonInCart(){
//        driver.findElement(deleteButton).click();
//    }


    public void getPriceSamsungandandMac(String samsung, String mac) {
        String xpath = "//td[text()='" + samsung + "']/following-sibling::td[1]";
        WebElement priceElement = driver.findElement(By.xpath(xpath));

        String priceSamsung = priceElement.getText();

        samsungPriceCart = Integer.parseInt(priceSamsung);
//        System.out.println("ini harga samsung integer" + samsungPriceCart);

        String xpathmac = "//td[text()='" + mac + "']/following-sibling::td[1]";
        WebElement priceElementmac = driver.findElement(By.xpath(xpathmac));

        String priceMac = priceElementmac.getText();

        macbookPriceCart = Integer.parseInt(priceMac);
        int samsungS6PriceDetailHome = HomePageLogic.SamsungS6PriceDetail;
        int macbookPrice = HomePageLogic.MacbookPrice;

        Assert.assertEquals(samsungPriceCart, samsungS6PriceDetailHome);
        Assert.assertEquals(macbookPriceCart, macbookPrice);


    }

    public void FinalPrice() {
        int FinalPrice = samsungPriceCart + macbookPriceCart;

        String cartFinPri = driver.findElement(finalPriceVar).getText();
        int parseCartFinPr = Integer.parseInt(cartFinPri);

        Assert.assertEquals(FinalPrice, parseCartFinPr);

//        List<WebElement> priceElements = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-striped']//tbody//tr//td[3]"));
//
//        int totalPrice = 0;
//
//        for (WebElement priceElement : priceElements) {
//            String priceText = priceElement.getText();
//            int price = Integer.parseInt(priceText);
//            totalPrice += price;
//        }
//        System.out.println("Total Price: " + totalPrice);
    }

    public void delete2Prod() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            Thread.sleep(Duration.ofSeconds(2).toMillis());
            driver.findElement(deleteButton).click();
        }
    }

    public void BlankPrice() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        WebElement webElement = driver.findElement(finalPriceVar);

        if (webElement.isDisplayed()) {
            System.out.println("ini tidak seharusnya muncul");
        } else {
            System.out.println("pass");
        }
    }

    public void deleteALlInCart() {
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-striped']//tbody//tr//td[4]//a[contains(text(),'Delete')]"));

        for (WebElement deleteButton : deleteButtons) {
            deleteButton.click();
        }
    }

    public void placeHolderbutton() {
        driver.findElement(placeHolderButton).click();
    }

//    public void clickCartWithoutProduct(){
//        driver.findElement(cartButtonWithoutProduct).click();
//    }

    public void popUpDisplayed() {
        driver.findElement(popUpPlaceholder).isDisplayed();
    }

    public void inputName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    public void inputCountry(String countryName) {
        driver.findElement(inputCountryName).sendKeys(countryName);
    }

    public void inputCity(String city) {
        driver.findElement(inputCityName).sendKeys(city);
    }

    public void inputCardNumber(String cardNumber) {
        WebElement element = driver.findElement(inputCard);

        element.sendKeys(cardNumber);

        String getInputValue = element.getAttribute("value");

        if (!getInputValue.matches("\\d+")) {
            Assert.fail("The String '" + getInputValue + "' Contains Non-Numeric Characters.");
        } else {
            System.out.println("Input value '" + getInputValue + "' contains only numeric characters.");
        }
    }

    public void inputMonth(String monthVal) {
        WebElement element = driver.findElement(inputMonth);

        element.sendKeys(monthVal);

        String getInputValue = element.getAttribute("value");

        if (getInputValue.matches("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]+$")) {
            Assert.fail("you cannot combine string and integer for this field");
        }

    }

    public void inputYear(String yearVal) {
        WebElement element = driver.findElement(inputYear);

        element.sendKeys(yearVal);

        String getValueYear = element.getAttribute("value");

        if (!getValueYear.matches("\\d+")) {
            Assert.fail("The String '" + getValueYear + "' Contains Non-Numeric Characters.");
        } else {
            System.out.println("Input value '" + getValueYear + "' contains only numeric characters.");
        }

    }

    public void PurchaseButton() {
        driver.findElement(purchaseButton).click();
    }

    public void popUpPurchase() {
        driver.findElement(popUpAppear).isDisplayed();
    }
}

