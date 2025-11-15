package com.ayesha.api5;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import com.test.utils.APIConstants;
import com.test.utils.APIGlobalVariables;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_CreateStudent {
	@Test
	public void CreateStudent() {
 
		String payload = "{\r\n" + "  " + "\"firstName\": \"" + APIGlobalVariables.firstname + "\" ,\r\n"
				+ "  \"lastName\": \"" + APIGlobalVariables.lastname + "\",\r\n" + "  \"email\": \""
				+ APIGlobalVariables.email + "\",\r\n" + "  \"city\": \"" + APIGlobalVariables.city + "\",\r\n"
				+ "  \"state\": \"" + APIGlobalVariables.state + "\",\r\n" + "  \"studentNumber\": \""
				+ APIGlobalVariables.studentNumber + "\"\r\n" + "}";

		RestAssured.given().auth().oauth2(APIGlobalVariables.token).body(payload).contentType(ContentType.JSON).when()
				.post(APIConstants.CREATE_STUDENT_ENDPOINT).prettyPeek().then().assertThat().statusCode(200).and()
				.body("result.firstName", equalTo(APIGlobalVariables.firstname)).and()
				.body("result.email", equalTo(APIGlobalVariables.email));

	}
}
