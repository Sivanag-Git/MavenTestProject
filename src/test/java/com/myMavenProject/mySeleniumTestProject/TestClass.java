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
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chromedriver.exe");
		ChromeOptions chromeOptions= new ChromeOptions();
		//chromeOptions.setBinary("C:\\Selenium\\Drivers\\chromedriver.exe");
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
