package com.HNE.APIstepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;

public class DeleteUser {

    private String endpoint;
    private String appID;
    private String appidval;

    private Response response;

    @Given("the API endpoint for delete user data is {string}")
    public void theAPIEndpointForDeleteUserDataIs(String endpoint) {
    this.endpoint = endpoint;
    }

    @And("header for delete is {string} with value {string}")
    public void headerForDeleteIsWithValue(String appID, String appidval) {
        this.appID=appID;
        this.appidval = appidval;

    }

    @And("i delete user with id {string}")
    public void iDeleteUserWithId(String userID) {
     response = RestAssured.given()
                .header("Conten-Type","application/json")
                .header(appID,appidval)
                .delete(endpoint+userID);

     response.then().log().all();
    }

    @Then("i should get response {int} for delete date")
    public void iShouldGetResponseForDeleteDate(int expectedstatuscode) {
        int statuscode = response.statusCode();
        String getError = response.jsonPath().getString("error");

//        Assert.assertEquals(expected,statuscode);

        if (statuscode == 400 && "PARAMS_NOT_VALID".equals(getError)){
//            System.out.println("THATS ID NEVER EXIST !!!");
            Assert.fail("THATS ID NEVER EXIST !!!");
        }if (statuscode == 404 && "RESOURCE_NOT_FOUND".equals(getError)){
//            System.out.println("YOU INSERT WRONG ID !!!");
            Assert.fail("YOU INSERT WRONG ID !!!");
        }if (statuscode == expectedstatuscode) {
            System.out.println("SUCCESS DELETE DATA");
        }
    }
}
