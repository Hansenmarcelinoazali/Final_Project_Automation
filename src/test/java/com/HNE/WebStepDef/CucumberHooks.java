package com.HNE.WebStepDef;

import com.HNE.BaseTest;
import com.HNE.LogicPage.HomePageLogic;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static java.sql.DriverManager.getDriver;

public class CucumberHooks extends BaseTest {
HomePageLogic homePageLogic;
    @Before
    public void beforeTest() {
        getDriver();
        homePageLogic = new HomePageLogic(driver);
    }

//    @After
//    public void afterTest() {
//        driver.quit();
//    }
}