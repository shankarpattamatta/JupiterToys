package com.planittesting.jupitertoys.tests;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@Execution(ExecutionMode.CONCURRENT)
public class BaseTests {
// This test contains all the mandatory actions that has to happen before a test case execution
	
	protected WebDriver driver;
	
	@BeforeEach
	public void setupTest() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--window-size=1920,1080");
		chromeOptions.setHeadless(true);
		driver = new ChromeDriver(chromeOptions);//Driver type should come from enviromental variable
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//Implicit time out shuld come from an env variable 
		driver.manage().window().maximize();
		driver.navigate().to("http://jupiter2.cloud.planittesting.com");//Also the URL should come from env varibale
	}
	@AfterEach
	public void shutdownTest() {
		driver.quit();
	}
	
	
}