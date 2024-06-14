package com.HNE.LogicPage;

import io.cucumber.java.bs.A;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class CartPageLogic {
    WebDriver driver;

    public static int samsungPriceCart;
    public static int macbookPriceCart;

    By samsungInCart = By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]");
    By deleteButton = By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[4]/a");

    By finalPriceVar = By.xpath("//*[@id=\"totalp\"]");

    By placeHolderButton = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");

    By cartButtonWithoutProduct = By.id("cartur");

    By popUpPlaceholder = By.xpath("//*[@id=\"orderModal\"]/div/div/div[2]");

    By inputName = By.xpath("//*[@id=\"name\"]");


    public CartPageLogic(WebDriver driver){
        this.driver = driver;
    }

        public void samsungInCart(String expectedSamsungS6){
        String getSamsung = driver.findElement(samsungInCart).getText();

            Assert.assertEquals(expectedSamsungS6, getSamsung);
    }

//    public void deleteButtonInCart(){
//        driver.findElement(deleteButton).click();
//    }


    public void getPriceSamsungandandMac(String samsung, String mac){
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

        Assert.assertEquals(samsungPriceCart,samsungS6PriceDetailHome);
        Assert.assertEquals(macbookPriceCart,macbookPrice);


    }

    public void FinalPrice(){
        int FinalPrice = samsungPriceCart+macbookPriceCart;

        String cartFinPri = driver.findElement(finalPriceVar).getText();
        int parseCartFinPr = Integer.parseInt(cartFinPri);

        Assert.assertEquals(FinalPrice,parseCartFinPr);

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

    public void delete2Prod() throws InterruptedException{
        for (int i = 0; i <2 ; i++) {
            Thread.sleep(Duration.ofSeconds(2));
            driver.findElement(deleteButton).click();
        }
    }

    public void BlankPrice()throws InterruptedException{
        Thread.sleep(Duration.ofSeconds(2));
        WebElement webElement = driver.findElement(finalPriceVar);

        if (webElement.isDisplayed()){
            System.out.println("ini tidak seharusnya muncul");
        }else {
            System.out.println("pass");
        }
    }

    public void deleteALlInCart(){
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-striped']//tbody//tr//td[4]//a[contains(text(),'Delete')]"));

        for (WebElement deleteButton : deleteButtons) {
            deleteButton.click();
        }
    }

    public void placeHolderbutton(){
        driver.findElement(placeHolderButton).click();
    }

//    public void clickCartWithoutProduct(){
//        driver.findElement(cartButtonWithoutProduct).click();
//    }

    public void popUpDisplayed(){
        driver.findElement(popUpPlaceholder).isDisplayed();
    }

    public void inputName(String name){
        driver.findElement(inputName).sendKeys(name);

    }
}
