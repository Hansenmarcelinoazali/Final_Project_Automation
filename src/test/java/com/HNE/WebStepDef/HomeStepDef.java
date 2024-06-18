package com.HNE.WebStepDef;

import com.HNE.BaseTest;
import com.HNE.LogicPage.HomePageLogic;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeStepDef extends BaseTest {

    HomePageLogic homePageLogic;


    public HomeStepDef() {
        homePageLogic = new HomePageLogic(driver);

    }


    @Then("user is directed to homepage and sees {string}")
    public void userIsDirectedToHomepageAndSees(String profileName) {
        homePageLogic.ProfileChecker(profileName);

    }


    @And("user clicks product Samsung Galaxy S-six")
    public void userClicksProductSamsungGalaxySSix() throws InterruptedException {


        homePageLogic.ClickSamsungGS6();

    }

    @And("user clicks button add to cart for samsung")
    public void userClicksButtonAddToCart() {


        homePageLogic.ClickAddToCartButton();
    }

    @Then("user gets popup alert {string} and closes popup")
    public void userGetsPopupAlertAndClosesPopup(String alertAddtoCart) {

        homePageLogic.GetAlertText(alertAddtoCart);
    }


    @And("user click Cart")
    public void userClickCart() {
        homePageLogic.clickCart();
    }


    @And("user clicks Home button")
    public void userClicksHomeButton() {
        homePageLogic.homeButtonTopBar();
    }

    @And("user clicks Macbook Air")
    public void userClicksMacbookAir() throws InterruptedException {
        homePageLogic.ClickMacbook();
    }

    @And("user click menu laptop")
    public void userClickMenuLaptop() {
        homePageLogic.ClickLaptopMenu();
    }

    @And("user clicks button add to cart for macbook")
    public void userClicksButtonAddToCartForMacbook() {
        homePageLogic.AddtoCartMacbook();

    }


}
