package stefDefination;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import PayloadData.AddPlacePayLoad;
import Utils.Util;
import api.ApiResources;
import googleMap_pojo.AddPlace;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddPlaceSD extends Util {
	
	RequestSpecification requestSpecification;
	Response response;
	AddPlace apResponse;
	AddPlacePayLoad ap=new AddPlacePayLoad();
	RestAssured restAssured= new RestAssured();
	

	@Given("User can add payloads {string} {string} {string}")
	public void user_can_add_payloads(String name, String language, String address) throws IOException {
		requestSpecification = restAssured.given().spec(requestSpecfication()).body(ap.payloadForAddPlace(name, language, address));
	}


	@When("User can call {string} with {string} http method")
	public void user_can_call_with_http_method(String resources, String string2) {
		if(resources.equalsIgnoreCase("AddPlace")) {
		ApiResources api = ApiResources.valueOf(resources);
		String resources2 = api.getResources();
		System.out.println(resources2+"**********************");
		response = requestSpecification.when().post(resources2);}
		else if(resources.equalsIgnoreCase("DeletePlace")) {
		
			ApiResources api = ApiResources.valueOf(resources);
			String resources2 = api.getResources();
			System.out.println(resources2+"**********************");
			response = requestSpecification.when().post(resources2);}

	}
	@Then("Api call call got success with status code is {string}")
	public void api_call_call_got_success_with_status_code_is(String string) {
		apResponse= response.then().extract().response().as(AddPlace.class);
		int statusCode = response.then().extract().response().statusCode();
		assertEquals(statusCode,200);
		
	}


}
