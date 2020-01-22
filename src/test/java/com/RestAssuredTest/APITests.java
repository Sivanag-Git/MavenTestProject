package com.RestAssuredTest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITests {

	//@Test(priority = 1, groups = "READ")
	public void GetAllPosts()
	{
		String response = RestAssured.get("http://localhost:3000/posts").getBody().jsonPath().prettify().toString();
		System.out.println("Available posts: "+response);
	}
	
	//@Test(priority = 2, groups = "CRUD")
	public void AddNewPost()
	{
		RequestSpecification request = (RequestSpecification) RestAssured.given().
						contentType(ContentType.JSON).
						body("{ \"id\": 4,\"title\": \"Test automation\",\"author\": \"Sivanag\" }");
		Response response = request.post("http://localhost:3000/posts");
		int code = response.getStatusCode();
		Assert.assertEquals(code, 201);
		System.out.println("New post added successfully: "+code);
	}
		
	@SuppressWarnings("unchecked")
	//@Test(priority = 3, groups = "CRUD")
	public void UpdatePost()
	{
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type",ContentType.JSON);
		
		JSONObject json = new JSONObject();
		json.put("id", 4);
		json.put("title", "Test Automation4");
		json.put("author", "Sivanag");
		
		request.body(json.toJSONString());
		
		Response response = request.put("http://localhost:3000/posts/4");
		int code = response.getStatusCode();		
		Assert.assertEquals(code, 200);
		System.out.println("Post edited successfully: "+code);
	}

	//@Test(priority = 4, groups = "CRUD")
	public void DeletePost()
	{
		RequestSpecification request = RestAssured.given();
		Response response = request.delete("http://localhost:3000/posts/4");
		int code = response.getStatusCode();
		Assert.assertEquals(code, 200);
		System.out.println("Post deleted successfully: "+code);
	}
}
