package com.RestAssuredTest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RESTCRUDTests {

	//@Test
	public void POSTMethodTest()
	{
		RestAssured.given().
						contentType(ContentType.JSON).
						body("{ \"id\": 2,\"title\": \"Test automation\",\"author\": \"Sivanag\" }").
					when().
						post("http://localhost:3000/posts").
					then().
					assertThat().statusCode(201);
	}
	
	//@Test
	public void POSTMethodPOJOTest() throws JsonProcessingException
	{
		POSTClass objPOST = new POSTClass(3, "Automation", "Sivanag");
		
		ObjectMapper objMap = new ObjectMapper();
		String myPostData = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(objPOST);
		System.out.println(myPostData);
		
		
		  RestAssured.given(). 
		  contentType(ContentType.JSON). 
		  body(objPOST). 
		  when().
		  post("http://localhost:3000/posts"). then(). assertThat().statusCode(201);
		 
	}
	
	//@Test
	public void POSTMethodTest_ReqSpec()
	{
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type",ContentType.JSON);
		
		JSONObject json = new JSONObject();
		json.put("id", 3);
		json.put("title", "Automation");
		json.put("author", "Sivanag");
		
		request.body(json.toJSONString());
		
		Response response = request.post("http://localhost:3000/posts");
		int code = response.getStatusCode();
		System.out.println("Response status code: "+code);
		Assert.assertEquals(code, 201);
	}
	
	//@Test
	public void DeleteMethodTest()
	{
		RequestSpecification request = RestAssured.given();
		Response response = request.delete("http://localhost:3000/posts/3");
		int code = response.getStatusCode();
		System.out.println("Response status code: "+code);
		Assert.assertEquals(code, 200);
	}
	
	//@Test
	public void PUTMethodTest()
	{
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type",ContentType.JSON);
		
		JSONObject json = new JSONObject();
		json.put("id", 3);
		json.put("title", "Test Automation");
		json.put("author", "Sivanag");
		
		request.body(json.toJSONString());
		
		Response response = request.put("http://localhost:3000/posts/3");
		int code = response.getStatusCode();
		System.out.println("Response status code: "+code);
		Assert.assertEquals(code, 200);
	}
}

