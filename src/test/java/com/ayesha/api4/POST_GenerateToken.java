package com.ayesha.api4;
import org.junit.Assert;
import org.junit.Test;

import com.test.utils.APIConstants;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_GenerateToken {

	@Test
	public void generateToken()
	{
		//set the Base URI
		RestAssured.baseURI = APIConstants.BASE_URI;
		
		//create a request
		RequestSpecification request = RestAssured.given();
		
		//since I am sending a JSON payload, I need to add that to the header
		request.header("Content-Type","application/json; charset=utf-8");
		
		String payload = "{\r\n"
				+ "  \"userNameOrEmailAddress\": \"Tester\",\r\n"
				+ "  \"password\": \"Student@Neo\",\r\n"
				+ "  \"rememberClient\": true\r\n"
				+ "}";
		
		request.body(payload);
		
		
		//make the call
		Response response = request.when().post(APIConstants.GENERATE_TOKEN_ENDPOINT);
		
		//another way to send a request
		//Response response = request.when().request(Method.POST,"/api/TokenAuth/Authenticate");
		
		System.out.println("-----------------------------");
		System.out.println("Status Code: " + response.statusCode()); //.getStatusCode()
		System.out.println("-----------------------------");
		System.out.println(response.statusLine()); //.getStatusLine();
		
		response.prettyPrint();
		System.out.println("-----------------------------");
		
		response.then().assertThat().statusCode(200);
		Assert.assertEquals(200, response.statusCode());
	}
	
	@Test
	public void generateTokenShortWay()
	{
		RestAssured.baseURI = "https://neo-api.azurewebsites.net";
		
		String payload = "{\r\n"
				+ "  \"userNameOrEmailAddress\": \"Tester\",\r\n"
				+ "  \"password\": \"Student@Neo\",\r\n"
				+ "  \"rememberClient\": true\r\n"
				+ "}";
		
		
		RestAssured.given()
			.header("Content-Type","application/json; charset=utf-8")
			.body(payload)
			.when().post("/api/TokenAuth/Authenticate")
			.prettyPeek()
			.then().assertThat().statusCode(200);
	}
	
	
}
