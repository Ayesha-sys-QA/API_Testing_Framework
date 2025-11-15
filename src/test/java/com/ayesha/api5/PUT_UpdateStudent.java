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

public class PUT_UpdateStudent {
	@Test
	public void CreateStudent() {

		String payload = "{\r\n" + "  \"id\": 1305,\r\n" + "  \"firstName\": \"Aicha\",\r\n"
				+ "  \"lastName\": \"Moustatia\",\r\n" + "  \"email\": \"Amoustatia@Neotech.com\",\r\n"
				+ "  \"city\": \"Rabat\",\r\n" + "  \"state\": \"MA\",\r\n" + "  \"studentNumber\": \"Neo@369\"\r\n"
				+ "}";

		RestAssured.baseURI = APIConstants.BASE_URI;

		Response response = RestAssured.given().auth().oauth2(APIGlobalVariables.token).body(payload)
				.contentType(ContentType.JSON).when().put(APIConstants.UPDATE_STUDENT_ENDPOINT).prettyPeek();

		response.then().assertThat().statusCode(200);

		// get the id from the body
		int id = response.body().jsonPath().getInt("result.id");

		// verify that the id is the same as the one we updated
		Assert.assertEquals(id, APIGlobalVariables.studentId);

		// negative test
		// verify that the response does not include the old city
		Assert.assertFalse(response.body().jsonPath().getString("result").contains(APIGlobalVariables.city));

	}
}
