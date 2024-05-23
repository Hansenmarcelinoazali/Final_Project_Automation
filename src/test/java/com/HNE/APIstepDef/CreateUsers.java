package com.HNE.APIstepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CreateUsers {

    private  String endpoint;
    private  String appID;
    private  String appValue;

    private Response response;

    @Given("the API endpoint for create user is {string}")
    public void theAPIEndpointForCreateUserIs(String endpoint) {
        this.endpoint = endpoint;
    }

    @And("header to create user by id is {string} with value {string}")
    public void headerToUpdateUserByIdIsWithValue(String appID, String appValue) {
    this.appID = appID;
    this.appValue = appValue;
    }

    @And("create user with json file")
    public void createUserWithJsonFile() throws IOException {

        File jsonForpostnewuser = new File("D:\\JayJay\\Automate\\Final_project_jayjay\\src\\test\\resources\\JsonPost\\jsonforcreateuser.json");

        String jsonBody = FileUtils.readFileToString(jsonForpostnewuser,"UTF-8");

     response =    RestAssured.given()
                .header(appID, appValue)
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .body(jsonBody)
                .when().post(endpoint);

response.then().log().all();

    }

    @Then("i should get status code {int} for create data")
    public void iShouldGetStatusCodeForCreateData(int expectedstatuscode) {
        response.then().assertThat().statusCode(expectedstatuscode);


    }
}
