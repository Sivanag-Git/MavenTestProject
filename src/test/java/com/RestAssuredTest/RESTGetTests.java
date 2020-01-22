package com.RestAssuredTest;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import org.testng.Assert;

public class RESTGetTests {

	//@Test
	public void GetResponseCode()
	{
		int code = RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=4232742beab0a3dca10f779a75b288ce").getStatusCode();
		System.out.println("Status code is: "+code);
		Assert.assertEquals(code, 200);
	}
	
	//@Test
	public void GetResponseInfo()
	{
		long resTime = RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=4232742beab0a3dca10f779a75b288ce").time();
		System.out.println("Response time: "+resTime);
	}
}
