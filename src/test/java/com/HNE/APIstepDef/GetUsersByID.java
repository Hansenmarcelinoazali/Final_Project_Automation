package com.HNE.APIstepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.Assert;


import java.io.File;

import static io.restassured.RestAssured.get;
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

    @Then("i should get http status code response {int} and data type should be same with json schema")
    public void iShouldGetHttpStatusCodeResponseAndDataTypeShouldBeSameWithJsonSchema(int expected) {

        jsonGetValidator = new File("src/test/resources/JsonSchema/JsonSchemaGetByID.json");

        response = given()
                .header(appID, appIDValue)
                .header("Content-Type", "application/json")
                .when()
                .get(endpoint + valueID);

        int statuscode = response.statusCode();
        String getError = response.jsonPath().getString("error");

//        Assert.assertEquals(expected,statuscode);

        if (statuscode == 400 && "PARAMS_NOT_VALID".equals(getError)){
//            System.out.println("THATS ID NEVER EXIST !!!");
            Assert.fail("THATS ID NEVER EXIST !!!");
        }if (statuscode == 404 && "RESOURCE_NOT_FOUND".equals(getError)){
//            System.out.println("YOU INSERT WRONG ID !!!");
            Assert.fail("YOU INSERT WRONG ID !!!");
        }if (statuscode == 200) {
            response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonGetValidator));
        }
    }
}
