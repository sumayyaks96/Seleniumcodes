package com.obsquara.Automationcourse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GeoceryStore {
	public WebDriver driver;
	public void initializeBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\eclipse-workspace\\Automationcourse\\src\\main\\java\\Resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.opesmount.in/grocerystore1/");
		
	}
	public void browserClose() {
		driver.close();
	}

	

}
