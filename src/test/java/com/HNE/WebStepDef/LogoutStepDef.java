package com.HNE.WebStepDef;

import com.HNE.BaseTest;
import com.HNE.LogicPage.LogoutPageLogic;
import io.cucumber.java.en.And;

public class LogoutStepDef extends BaseTest {

    LogoutPageLogic logoutPageLogic;

    public LogoutStepDef(){
        logoutPageLogic = new LogoutPageLogic(driver);

    }

    @And("user clicks logout")
    public void userClicksLogout() {

        logoutPageLogic.logoutButton();
    }
}
