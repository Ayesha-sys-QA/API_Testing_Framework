package com.ayesha.api5;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import com.test.utils.APIConstants;
import com.test.utils.APIGlobalVariables;

import io.restassured.RestAssured;

public class GET_AllStudents {

	@Test
	public void getAllStudents()
	{
		RestAssured.baseURI = APIConstants.BASE_URI;
		
				RestAssured.given()
		// .header("Authorization", "Bearer " + APIGlobalVariables.token)
		.auth().oauth2(APIGlobalVariables.token).when().get(APIConstants.GET_ALL_STUDENTS_ENDPOINT).prettyPeek()
		.then().assertThat().statusCode(200).and().assertThat().body("result.totalCount", equalTo(45)).and()
		.assertThat().body("result.items.size()", is(10));
	}
}