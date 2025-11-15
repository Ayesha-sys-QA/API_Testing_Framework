package com.ayesha.api4;

//we can import all static methods --- do we need them all???
//import static org.hamcrest.Matchers.*;

//or we can specifically import the methods we want to use
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GET_OneClass {

	//@Test
	public void getOneClass()
	{
		//set the URI 
		
		//given ---> request ---> params, body, auth, headers... ---> 
		// ---> when ---> get, post, put/patch, delete ---> 
		// ---> then ---> assert status code, content etc.
		
		
		
		//set the URI
		RestAssured.baseURI = "https://neo-api.azurewebsites.net";
		
		
		RequestSpecification request = RestAssured.given();
		
		//setting a path parameter
		request.pathParam("Id", 1021);
		
		//make the call
		Response response = request.when().get("/api/services/app/Class/Get/{Id}");
		
		//can we write this simpler?? with directly adding the path parameter on the endpoint
		// request.when().get("/api/services/app/Class/Get/1021")  ???
		//YES!!!
		
		System.out.println("Status Line: " + response.getStatusLine());
		
		response.prettyPeek();
		System.out.println("-----------------------------------");
		
		
		//Assert using Hamcrest Matchers
		
		//assert the body has name Math101
		response.then().assertThat().body("result.name", equalTo("Math101"));
		
		//assert that the description contains Math
		response.then().assertThat().body("result.description", containsString("Math"));
		
		//assert that the instructor email ends with neo.com
		response.then().assertThat().body("result.instructorEmail", endsWith("neo.com"));
		
		
		//all of the above, can be done in one long method chain. 
		/*
		RestAssured.given()
			.pathParam("Id", 1021)
			.when().get("/api/services/app/Class/Get/{Id}")
			.prettyPeek()
			.then().assertThat().body("result.name", equalTo("Math101"))
			.and().assertThat().body("result.desciption", containsString("Math"))
			.and().assertThat().body("result.instructorEmail", endsWith("neo.com"));
		
		*/
	}
	
	@Test
	public void getOneClassShort()
	{
		RestAssured.baseURI = "https://neo-api.azurewebsites.net";
		
		RestAssured.given()
		.pathParam("Id", 1021)
		.when().get("/api/services/app/Class/Get/{Id}")
		.prettyPeek()
		.then().assertThat().body("result.name", equalTo("Math101"))
		.and().assertThat().body("result.description", containsString("Math"))
		.and().assertThat().body("result.instructorEmail", endsWith("neo.com"));
	}
	
	
}
