package com.obsquara.Automationcourse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public WebDriver driver;
	public  void initializeBrowser(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\eclipse-workspace\\Automationcourse\\src\\main\\java\\Resources\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.get("https://www.amazon.com/");
	}
	public void browserClose() {
		driver.close();
	}
	public void browserQuit() {
		driver.quit();
	}
	/*public static void main(String args[]) {
		Base obj=new Base();
		obj.initializeBrowser();
	}*/
}



