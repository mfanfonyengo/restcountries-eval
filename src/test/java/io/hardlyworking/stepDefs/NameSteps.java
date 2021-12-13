package io.hardlyworking.stepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class NameSteps {

    RequestSpecification request;
    Response response;

    @Before
    public void restAssuredSetup(){
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("https://restcountries.com/v3.1");
        builder.setContentType(ContentType.JSON);
    }

    @Given("User sets the base API request {string}")
    public void userSetsTheBaseAPIRequestURL(String url) {
        //RestAssured.baseURI = url;
        //request = request.given();
        System.out.println("-----");
    }

    @When("users sends a GET request to {string}")
    public void usersSendsAGETRequestToNamePath(String path) {
        String url = "https://restcountries.com/v3.1" + path;
        response = RestAssured.get(url);
    }

    @Then("the server should handle it and return a response status {int}")
    public void theServerShouldHandleItAndReturnAResponseStatusCode(int code) {
        Assert.assertEquals(response.getStatusCode(), code);
    }



}
