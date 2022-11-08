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
	public void BrowserCommand() {
		String expectedTitle="Amazon.com. Spend less. Smile more.";
		String title=driver.getTitle();//get title
		if(expectedTitle.equals(title))//compare titles
		{
			System.out.println("Titles are equal");
		}
		else
		{
			System.out.println("Titles are not equal");
		}
		
	}
	public void browserClose() {
		driver.close();
	}
	public void browserQuit() {
		driver.quit();
	}
	public void getUrl() {
	
		String url=driver.getCurrentUrl();
		
	}
	public void getPageSource() {
		String pageSource=driver.getPageSource();
		
	}

	
	public static void main(String arg[]){
		Base obj=new Base();
		obj.initializeBrowser();
		obj.BrowserCommand();
		//obj.browserClose();
		obj.getUrl();
		obj.getPageSource();
		obj.browserQuit();
			
				
	}

}



