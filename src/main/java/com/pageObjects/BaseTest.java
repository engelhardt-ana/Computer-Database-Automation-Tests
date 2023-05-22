package com.pageObjects;

import static java.util.concurrent.TimeUnit.SECONDS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	public WebDriver driver;

	@BeforeTest
	public void prepare() {

		System.setProperty("webdriver.chrome.driver", "resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://computer-database.gatling.io/computers/");
		driver.manage().timeouts().implicitlyWait(30, SECONDS);
		driver.manage().window().maximize();

	}

	@AfterTest
	public void quit(){
		
		driver.quit();
		
	}

}