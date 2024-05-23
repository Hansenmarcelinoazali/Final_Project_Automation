package com.HNE.APIstepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static io.restassured.RestAssured.given;

public class GetListofTags {

    private String appID;
    private String endPoint;
    private String paramAppid;



    @Given("the API endppint  is {string}")
    public void theAPIEndppintIs(String linkEndpoint) {
        this.endPoint = linkEndpoint;
    }

    @And("header {string} with value {string}")
    public void headerWithValue(String paramAppID, String valueAppID) {
        this.appID = valueAppID;
        this.paramAppid = paramAppID;
    }

    @Then("http status response should be {int}")
    public void httpStatusResponseShouldBe(int expected) {
        given().header(paramAppid,appID)
                .when().get(endPoint).then().log().all()
               .assertThat().statusCode(expected);

    }
}
