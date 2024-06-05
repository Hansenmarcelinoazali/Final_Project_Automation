package com.HNE;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//public class BaseTest {
//    protected static WebDriver driver;
//
//
//    protected void getDriver() {
////        ChromeOptions options = new ChromeOptions();
////        options.addArguments("--headless");
////        WebDriverManager.chromedriver().setup();
////        driver = new ChromeDriver(options);
//
//
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//
//    }
//}

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;

    protected void getDriver() {

        driver  =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}

