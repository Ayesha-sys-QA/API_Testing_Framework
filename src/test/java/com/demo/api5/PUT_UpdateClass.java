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

public class PUT_UpdateClass {
	@Test
	public void UpdateClass() {

		String payload = "{\r\n"
				+ "  \"id\": 1041,\r\n"
				+ "  \"name\": \"API\",\r\n"
				+ "  \"description\": \"BACK_END_TEST\",\r\n"
				+ "  \"instructor\": \"SHANE\",\r\n"
				+ "  \"instructorEmail\": \"Shane@Neotech.com\",\r\n"
				+ "  \"term\": \"S\",\r\n"
				+ "  \"credits\": 9\r\n"
				+ "}";

		RestAssured.baseURI = APIConstants.BASE_URI;

		Response response = RestAssured.given().auth().oauth2(APIGlobalVariables.token).body(payload)
				.contentType(ContentType.JSON).when().put(APIConstants.UPDATE_CLASS_ENDPOINT).prettyPeek();

		response.then().assertThat().statusCode(200);

		
		int id = response.body().jsonPath().getInt("result.id");

		// verify that the id is the same as the one we updated
		Assert.assertEquals(id, APIGlobalVariables.classId);

		

	}
}
