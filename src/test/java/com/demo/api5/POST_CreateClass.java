package com.demo.api5;

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

public class POST_CreateClass {
	@Test
	public void CreateClass() {

		String payload = "{\r\n" + "  \"name\": \"API\",\r\n" + "  \"description\": \"BackEnd_Test\",\r\n"
				+ "  \"instructor\": \"Shane\",\r\n" + "  \"instructorEmail\": \"Shane@Neotech.com\",\r\n"
				+ "  \"term\": \"A\",\r\n" + "  \"credits\": 9\r\n" + "}";

		RestAssured.baseURI = APIConstants.BASE_URI;

		Response response = RestAssured.given().auth().oauth2(APIGlobalVariables.token).body(payload)
				.contentType(ContentType.JSON).when().post(APIConstants.CREATE_CLASS_ENDPOINT).prettyPeek();

		response.then().assertThat().statusCode(200).and().body("result.name", equalTo("API")).and()
				.body("result.instructor", equalTo("Shane"));

	}
}
