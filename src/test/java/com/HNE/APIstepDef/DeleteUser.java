package com.HNE.APIstepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

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
        System.out.println(response);
    }
}
