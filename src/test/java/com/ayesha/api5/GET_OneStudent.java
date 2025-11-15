package com.ayesha.api5;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import com.test.utils.APIConstants;
import com.test.utils.APIGlobalVariables;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_OneStudent {

	@Test
	public void getAllStudents() {
		RestAssured.baseURI = APIConstants.BASE_URI;

		Response response = RestAssured.given()
				// .header("Authorization", "Bearer " + APIGlobalVariables.token).
				.auth().oauth2(APIGlobalVariables.token).queryParam("Id", APIGlobalVariables.studentId).when()
				.get(APIConstants.GET_ONE_STUDENT_ENDPOINT).prettyPeek();
		System.out.println("--------------------");
		response.then().assertThat().statusCode(200);

		System.out.println(response.header("Content-Type"));
		
		int id = response.body().jsonPath().getInt("result.id");
		System.out.println("id = " + id);
		
		Assert.assertEquals(APIGlobalVariables.studentId, id);
		// Or: response.then().assertThat().body("result.id", equalTo(APIGlobalVariables.studentId));
		
	}
}