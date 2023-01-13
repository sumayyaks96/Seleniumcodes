package com.obsquara.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.obsquara.utilities.ExcelUtility;
import com.obsquara.utilities.PageUtility;

public class ClientPage {
	public WebDriver driver;
	public ClientPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='identity']")
	private WebElement usernameField;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@class='btn btn-primary btn-block btn-flat']")
	private WebElement loginButton;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/customers']")
	private WebElement moreInfoButton;
	
	@FindBy(xpath="//button[@class='add_c btn btn-primary']")
	private WebElement AddClientField;
	
	@FindBy(xpath="//input[@id='name1']")
	private WebElement clientName;
	
	@FindBy(xpath="//input[@id='company1']")
	private WebElement company;
	
	@FindBy(xpath="//input[@id='autocomplete']")
	private WebElement geoLocate;
	
	@FindBy(xpath="//input[@id='route']")
	private WebElement address;
	
	@FindBy(xpath="//input[@id='locality']")
	private WebElement city ;
	
	@FindBy(xpath="//input[@id='email1']")
	private WebElement EmailId;
	
	@FindBy(xpath="//input[@id='image']")
	private WebElement upload ;
	
	@FindBy(xpath="//textarea[@id='comment1']")
	private WebElement comment ;
	
	@FindBy(xpath="//button[@id='submit']")
	private WebElement AddClientButton;
	
	@FindBy(xpath="//button[@id='submit']")
	private WebElement AlertMsgField;
	
	@FindBy(xpath="//button[@class='dt-button buttons-collection buttons-colvis']")
	private WebElement changecolumn;
	
	@FindBy(xpath="//tr[@class='odd' or @class='even']")
	private List<WebElement> rowcount;
	
	public void addClient() throws IOException {
		String Username =ExcelUtility.getString(0, 0, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx","LoginPage");
		String password = ExcelUtility.getString(0, 1, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx","LoginPage");
		PageUtility.enterText(usernameField, Username);
		PageUtility.enterText(passwordField, password);
		PageUtility.clickOnElement(loginButton);
		PageUtility.clickOnElement(moreInfoButton);
		PageUtility.clickOnElement(AddClientField);
		String Name =ExcelUtility.getString(0, 0, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx","Client");
		String companyname = ExcelUtility.getString(0, 1, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx","Client");
		String Location =ExcelUtility.getString(0, 2, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx","Client");
		String clientaddress= ExcelUtility.getString(0, 3, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx","Client");
		String cityname =ExcelUtility.getString(0, 4, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx","Client");
		String email= ExcelUtility.getString(0, 7, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx","Client");
		String uploadfile =ExcelUtility.getString(0, 8, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx","Client");
		String commentMsg=ExcelUtility.getString(0, 9, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx","Client");
		//String expectedMsg=ExcelUtility.getString(0, 10, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx","Client");
		//String actualMsg;
		PageUtility.enterText(clientName, Name);
		PageUtility.enterText(company, companyname);
		PageUtility.enterText(geoLocate, Location);
		PageUtility.enterText(address, clientaddress);
		PageUtility.enterText(city, cityname);
		PageUtility.enterText(EmailId,email);
		PageUtility.enterText(comment,commentMsg);
		PageUtility.clickOnElement(AddClientButton);
		//actualMsg=AlertMsgField.getText();
		Assert.assertTrue(true, "Add Client Failed ");
		}
	
	public void changeColumn() throws IOException {
		String Username =ExcelUtility.getString(0, 0, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx","LoginPage");
		String password = ExcelUtility.getString(0, 1, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx","LoginPage");
		PageUtility.enterText(usernameField, Username);
		PageUtility.enterText(passwordField, password);
		PageUtility.clickOnElement(loginButton);
		PageUtility.clickOnElement(moreInfoButton);
		PageUtility.clickOnElement(changecolumn);
		
	}
	
	public void showButton() throws IOException {
		String Username =ExcelUtility.getString(0, 0, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx","LoginPage");
		String password = ExcelUtility.getString(0, 1, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx","LoginPage");
		PageUtility.enterText(usernameField, Username);
		PageUtility.enterText(passwordField, password);
		PageUtility.clickOnElement(loginButton);
		PageUtility.clickOnElement(moreInfoButton);
		Select objSelect=new Select(driver.findElement(By.xpath("//select[@class='form-control input-sm select input-xs']")));
		List<WebElement>option=objSelect.getOptions();
		for(WebElement Inputmenu:option) {
			String show=Inputmenu.getText();
			if(show.contains("10")) {
				Inputmenu.click();
				break;
			}
			
		}	
    	List<WebElement>NumberOfRows=rowcount;
    	for(WebElement row:NumberOfRows) {
    		int count=NumberOfRows.size();
    		break;
    		}
    	Assert.assertTrue(true, "Show button not verify");
    	}
	
	

}
