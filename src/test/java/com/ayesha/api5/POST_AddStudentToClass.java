package com.ayesha.api5;

import org.json.JSONObject;
import org.junit.Test;

import com.test.utils.APIConstants;
import com.test.utils.APIGlobalVariables;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class POST_AddStudentToClass {
@Test
	public void addStudentToClass() {

		RestAssured.baseURI = APIConstants.BASE_URI;

		String payload = "{\r\n" + "  \"studentId\":" + APIGlobalVariables.studentId + ",\r\n" + "  \"classId\": "
				+ APIGlobalVariables.classId + "\r\n" + "}";

		String payload2 = new JSONObject().put("studentId", APIGlobalVariables.studentId)
				.put("classId", APIGlobalVariables.classId).toString();

		RestAssured.given().auth().oauth2(APIGlobalVariables.token).body(payload).contentType(ContentType.JSON).when()
				.post(APIConstants.ADD_STUDENT_TO_CLASS_ENDPOINT).prettyPeek().then().assertThat().statusCode(200).and()
				.body("result.action", equalTo("Add student")).and().body("result.success", equalTo(true));

	}
}