package com.myMavenProject.mySeleniumTestProject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {

	public WebDriver driver;
	
	@BeforeMethod
	public void launchDriver()
	{
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe"); 		
		ChromeOptions chromeOptions= new ChromeOptions();
		chromeOptions.setBinary("C:\\Users\\Admin\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
		chromeOptions.addArguments("disable-infobars"); // disabling infobars
		chromeOptions.addArguments("--disable-extensions"); // disabling extensions
		chromeOptions.addArguments("--disable-gpu"); // applicable to windows os only
		chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}
	
	@Test
	public void Test1()
	{
		driver.navigate().to("http://AutomationTalks.com");
		System.out.println("Title of the application: "+driver.getTitle());
	}
	
	@AfterMethod
	public void quitBrowser()
	{
		driver.quit();
	}
}
