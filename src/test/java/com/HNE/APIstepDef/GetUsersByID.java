package com.HNE.APIstepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.module.jsv.JsonSchemaValidator;


import java.io.File;

import static io.restassured.RestAssured.given;

public class GetUsersByID {

    private String endpoint;
    private String appID;
    private String appIDValue;
    private String valueID;
    private Response response;

    private File jsonGetValidator;


    @Given("the API endpoint is {string}")
    public void theAPIEndpointIs(String endpoint) {
        this.endpoint = endpoint;
    }

    @And("header to get by id is {string} with value {string}")
    public void headerToGetByIdIsWithValue(String appID, String appIDValue) {
        this.appID = appID;
        this.appIDValue = appIDValue;
    }

    @And("get user with id  {string}")
    public void getUserWithId(String valueID) {
        this.valueID = valueID;
    }

    @Then("data type should be same with json schema")
    public void dataTypeShouldBeSameWithJsonSchema() {
        jsonGetValidator = new File("D:\\JayJay\\Automate\\Final_project_jayjay\\src\\test\\resources\\JsonSchema\\JsonSchemaGetByID.json");

        response = given()
                .header(appID, appIDValue)
                .header("Content-Type", "application/json")
                .when()
                .get(endpoint + valueID);

        response.then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonGetValidator));
    }

    @Then("i should get http status code response {int} for get user by id")
    public void iShouldGetHttpStatusCodeResponseForGetUserById(int expectedStatusCode) {
        response.then().assertThat().statusCode(expectedStatusCode);
    }

}
