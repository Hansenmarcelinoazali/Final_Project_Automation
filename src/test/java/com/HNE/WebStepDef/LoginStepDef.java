package com.HNE.WebStepDef;

import com.HNE.BaseTest;
import com.HNE.LogicPage.LoginPageLogic;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginStepDef extends BaseTest {

    LoginPageLogic loginPageLogic;

    public LoginStepDef(){
        loginPageLogic = new LoginPageLogic(driver);

    }

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        loginPageLogic.GoToLoginPage();
    }

    @And("user clicks login button")
    public void userClicksLoginButton() {
        loginPageLogic.LoginButton();
    }

    @And("user inserts valid username {string}")
    public void userInsertsValidUsername(String validUsername) {
        loginPageLogic.InputUsernameLogin(validUsername);
    }

    @And("user inserts valid password {string}")
    public void userInsertsValidPassword(String validPassword) {
        loginPageLogic.InputPasswordLogin(validPassword);
    }


    @And("user click login")
    public void userClickLogin() {
        loginPageLogic.ClickLogin();

    }

    @Then("user sees login button")
    public void userSeesLoginButton() {
        loginPageLogic.loginDisplay();
    }
}
