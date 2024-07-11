package com.HNE.WebStepDef;

import com.HNE.BaseTest;
import com.HNE.LogicPage.CartPageLogic;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.sl.In;

import java.time.Duration;

public class CartStepDef extends BaseTest {

    CartPageLogic cartPageLogic;


    public CartStepDef(){
        cartPageLogic = new CartPageLogic(driver);
    }


    @Then("user sees the {string} in the cart menu")
    public void userSeesTheInTheCartMenu(String expectedSamsungs6) {
cartPageLogic.samsungInCart(expectedSamsungs6);
    }

    @And("user click delete all")
    public void userClickDelete() throws InterruptedException{
        cartPageLogic.deleteALlInCart();

    }


    @And("{string} and {string} have same price with product info")
    public void andHaveSamePriceWithProductInfo(String samsung, String macb) {
        cartPageLogic.getPriceSamsungandandMac(samsung, macb);
    }

    @Then("final price in cart have correct calculate")
    public void finalPriceInCartHaveCorrectCalculate() {
        cartPageLogic.FinalPrice();
    }

//    @And("user click delete for samsung and mac")
//    public void userClickDeleteForSamsungAndMac()throws InterruptedException{
////        cartPageLogic.delete2Prod();
//        cartPageLogic.deleteALlInCart();
//    }


    @Then("total price is not displayed")
    public void totalPriceIsNotDisplayed()throws InterruptedException {
        cartPageLogic.BlankPrice();
    }

    @And("user click place holder button")
    public void userClickPlaceHolderButton() {
cartPageLogic.placeHolderbutton();
    }

//    @And("user click Cart without chose product")
//    public void userClickCartWithoutChoseProduct()throws InterruptedException {
//
//        Thread.sleep(Duration.ofSeconds(1));
//        cartPageLogic.clickCartWithoutProduct();
//    }

    @Then("popup appear")
    public void popupAppear() {

    }

    @And("user input name {string}")
    public void userInputName(String name) {
        cartPageLogic.inputName(name);
    }

    @And("user input country {string}")
    public void userInputCountry(String country) {
        cartPageLogic.inputCountry(country);
    }

    @And("user input city {string}")
    public void userInputCity(String city) {
        cartPageLogic.inputCity(city);
    }

    @And("user input credit card {string}")
    public void userInputCreditCard(String cardNumber) {
        cartPageLogic.inputCardNumber(cardNumber);
    }

    @And("user input month {string}")
    public void userInputMonth(String month) {
        cartPageLogic.inputMonth(month);
    }

    @And("user Input year {string}")
    public void userInputYear(String year) {
        cartPageLogic.inputYear(year);
    }

    @Then("popup purchase appear and click OK")
    public void popupPurchaseAppear() throws InterruptedException {
        cartPageLogic.popUpPurchase();
    }

    @And("user click purchase button")
    public void userClickPurchaseButton() {
    cartPageLogic.PurchaseButton();
    }
}
