package com.ayesha.api5;

import org.junit.Test;

import com.test.utils.APIConstants;
import com.test.utils.APIGlobalVariables;

import io.restassured.RestAssured;

public class DELETE_Student {
	
@Test

public void deleteStudent() {
	
	RestAssured.baseURI = APIConstants.BASE_URI;
	RestAssured.given()
	.auth().oauth2(APIGlobalVariables.token)
	.queryParam("Id", APIGlobalVariables.studentId)
	.when().delete(APIConstants.DELETE_STUDENT_ENDPOINT)
	.prettyPeek()
	.then().assertThat().statusCode(200);
	
}

}
