package com.seleniumdesign.test;

import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeTest
	public void setUpDriver() {
		System.setProperty("webdriver.chrome.driver", Paths.get(System.getProperty("user.dir"), "/src/test/resources/chromedriver.exe").toString());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void tearDownDriver() {
		driver.quit();
	}

}
