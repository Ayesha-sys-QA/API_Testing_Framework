package com.ayesha.api4;

import com.test.utils.APIConstants;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GET_AllClasses {
	public static void main(String[] args) {

		// we define the method - GET
		// we define the URI 
		// we set any params, header, auth, body... 

		
		// SEND
		
		// validate response code
		// validate elements on payload
		
		
		//set the base uri
		RestAssured.baseURI = APIConstants.BASE_URI;
		
		System.out.println(RestAssured.baseURI);
		System.out.println("--------------------------------");
		
		
		//Build the request - this is where I can specify params, auth, headers
		RequestSpecification request = RestAssured.given();
		
		
		Response response = request.when().get(APIConstants.GET_ALL_CLASSES_ENDPOINT);
		
		System.out.println(response.statusCode());
		System.out.println(response.getStatusCode());
		System.out.println("--------------------------");
		
		//Get Headers 
		System.out.println(response.headers());
		System.out.println("--------------------------");
		
		//get a particular header 
		String contentType = response.header("Content-Type"); 
		System.out.println(contentType);
		System.out.println("--------------------------");
		
		//we can also create a headers object and work with it 
		// Headers headers = response.headers();
		
		ResponseBody body = response.getBody();
		System.out.println(body.asString());
		System.out.println("--------------------------");
		
		System.out.println(body.asPrettyString());
		System.out.println("--------------------------");
		
		//we can also print the response directly 
		response.prettyPrint();
	}

}

