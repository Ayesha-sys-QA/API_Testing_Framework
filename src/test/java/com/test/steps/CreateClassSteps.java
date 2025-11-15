package com.test.steps;

import static org.hamcrest.Matchers.equalTo;

import com.test.utils.APIConstants;
import com.test.utils.APIGlobalVariables;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;

public class CreateClassSteps {
	int id;
	String name;
	ValidatableResponse response;

	@When("I create a new class and store its name")
	public void i_create_a_new_class_and_store_its_name() {
		RestAssured.baseURI = APIConstants.BASE_URI;
		String payload = "{\r\n" + "  \"name\": \"API\",\r\n" + "  \"description\": \"BackEnd_Test\",\r\n"
				+ "  \"instructor\": \"Shane\",\r\n" + "  \"instructorEmail\": \"Shane@Neotech.com\",\r\n"
				+ "  \"term\": \"A\",\r\n" + "  \"credits\": 9\r\n" + "}";

		id = RestAssured.given().auth().oauth2(APIGlobalVariables.token).body(payload).contentType(ContentType.JSON)
				.when().post(APIConstants.CREATE_CLASS_ENDPOINT).prettyPeek().body().jsonPath().getInt("result.id");
        
		name =RestAssured.given().auth().oauth2(APIGlobalVariables.token).body(payload).contentType(ContentType.JSON)
				.when().post(APIConstants.CREATE_CLASS_ENDPOINT).prettyPeek().body().jsonPath().getString("result.name");
	}

	@When("I get the class by id and the stored name")
	public void i_get_the_class_by_id_and_the_stored_name() {
		RestAssured.baseURI = APIConstants.BASE_URI;
		 response = RestAssured.given()
		                    .auth().oauth2(APIGlobalVariables.token)
		                    .pathParam("Id", id)
		                    .contentType(ContentType.JSON)
		                .when()
		                    .get(APIConstants.GET_ONE_CLASS_ENDPOINT).prettyPeek() 
		                .then()
		                   .assertThat().statusCode(200).and()
		                  .body("result.name", equalTo(name)) ;
		                  
	}

	

	@Then("I validate the information of the created class")
	public void i_validate_the_information_of_the_created_class() {
		 response.assertThat()
         .body("result.name", equalTo("API"))
         .body("result.description", equalTo("BackEnd_Test"))
         .body("result.instructor", equalTo("Shane"))
         .body("result.term", equalTo("A"))
         .body("result.credits", equalTo(9));
 }
}