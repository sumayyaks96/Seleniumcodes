package com.obsquara.POMSampleProject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Base {
	public WebDriver driver;
	@BeforeMethod
	public  void initializeBrowser(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\eclipse-workspace\\POMSampleProject\\src\\main\\java\\Resources\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
	}
	
	public void browserClose() {
		driver.close();
	}
	@AfterMethod
	public void browserQuit() {
		driver.quit();
	}
}



