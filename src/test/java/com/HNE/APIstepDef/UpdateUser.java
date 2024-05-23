package com.HNE.APIstepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;

public class UpdateUser {

    private  String endpoint;
    private  String appID;
    private  String appIDVal;

    private Response response;
    @Given("the API endpoint for update user is {string}")
    public void theAPIEndpointForUpdateUserIs(String endpoint) {
       this. endpoint = endpoint;
    }

    @And("header to update user by id is {string} with value {string}")
    public void headerToUpdateUserByIdIsWithValue(String appID, String appIDVal) {
        this. appID = appID;
        this.  appIDVal = appIDVal;
    }


    @And("i update first name to {string} and last name {string} for user with id {string}")
    public void iUpdateFirtNameToAndLastNameForUserWithId(String firstname, String lastname, String userID) {



        JSONObject jsonObject =new JSONObject();

        jsonObject.put("firstName",firstname).put("lastName",lastname);


       response =RestAssured.given()
                .header("Content-Type","application/json")
                .header(appID,appIDVal)
                .body(jsonObject.toString())
                .when().put(endpoint+userID);

        response.then().log().all();

    }

    @Then("i should get response {int} for update users")
    public void iShouldGetResponseForUpdateUsers(int expectedrespose) {
        response.then().assertThat().statusCode(expectedrespose);
    }

}
