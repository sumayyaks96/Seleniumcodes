package com.obsquara.TestNGSample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Gurru99Base {
	public WebDriver driver;
	@BeforeMethod
	public void initializeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\eclipse-workspace\\TestNGSample\\src\\main\\java\\Resources\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.get("https://demo.guru99.com/test/ajax.html");
	}
	@AfterMethod
	public void browserQuit() {
		driver.quit();
	}
}
