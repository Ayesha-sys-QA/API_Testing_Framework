package com.ayesha.api5;

import com.test.utils.APIConstants;
import com.test.utils.APIGlobalVariables;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import io.restassured.RestAssured;

public class DELETE_RemoveStudentFromClass {
	@Test
	public void removeStudentFromClass() {
		
		RestAssured.baseURI = APIConstants.BASE_URI;
		
		RestAssured.given()
		.auth().oauth2(APIGlobalVariables.token)
		.queryParam("StudentId", APIGlobalVariables.studentId)
		.queryParam("ClassId", APIGlobalVariables.classId)
				.when().delete(APIConstants.REMOVE_STUDENT_FROM_CLASS_ENDPOINT).prettyPeek().then().assertThat()
				.statusCode(200).and().body("result.action", equalTo("Remove student")).and()
				.body("result.success", equalTo(true));

	}
}
