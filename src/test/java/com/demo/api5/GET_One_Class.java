package com.demo.api5;

import org.junit.Test;

import com.test.utils.APIConstants;
import com.test.utils.APIGlobalVariables;

import io.restassured.RestAssured;

public class GET_One_Class {

	@Test

	public void GetOneClass() {
		RestAssured.baseURI = APIConstants.BASE_URI;
		
		RestAssured.given()
		
		.pathParam("Id", APIGlobalVariables.classId)
		.when().get(APIConstants.GET_ONE_CLASS_ENDPOINT)
		.prettyPeek()
		.then().assertThat().statusCode(200);
		
		
		

	}
}
