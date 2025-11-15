package com.ayesha.api5;

import org.junit.Test;

import com.test.utils.APIConstants;
import com.test.utils.APIGlobalVariables;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class GET_Class_Roaster {
	@Test
	public void getClassRoster() {

		RestAssured.baseURI = APIConstants.BASE_URI;

		RestAssured.given().auth().oauth2(APIGlobalVariables.token).queryParam("classId", APIGlobalVariables.classId)
				.when().get(APIConstants.GET_CLASS_ROSTER_ENDPOINT).prettyPeek().then().assertThat().statusCode(200)
				.and().body("result.students.size()", greaterThan(0)).and().body("result.studentCount", greaterThan(0));
	}
}

