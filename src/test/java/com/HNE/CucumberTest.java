package com.HNE;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.HNE"},
        features = {"src/test/resources"},
        plugin = {"pretty","html:reports/cucumber.html", "json:reports/cucumber.json"} // untuk menampilkan step yang di eksekusi
)
public class CucumberTest {
}
