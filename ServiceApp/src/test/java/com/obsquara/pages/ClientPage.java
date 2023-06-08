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
import com.obsquara.utilities.WaitUtility;

public class ClientPage {
	public WebDriver driver;
	public ClientPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
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
	
	@FindBy(xpath="//div[@id='titoloclienti']")
	private WebElement AddClientMsg;
	
	@FindBy(xpath="//button[@id='submit']")
	private WebElement AlertMsgField;
	
	@FindBy(xpath="//button[@class='dt-button buttons-collection buttons-colvis']")
	private WebElement changecolumn;
	
	@FindBy(xpath="//tr[@class='odd' or @class='even']")
	private List<WebElement> rowcount;
	
	@FindBy(xpath="//input[@class='form-control input-sm input-xs']")
	private WebElement search;
	
	@FindBy(xpath="//div[@id='dynamic-table_info']")
	private WebElement searchbuttonmsg;
	
	@FindBy(xpath="//a[@class='dropdown-toggle btn-round btn btn-default']")
	private WebElement actionButton;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/reports/quantity_alerts']")
	private WebElement exportToExcelFile;
	
	@FindBy(xpath="//div[@id='dynamic-table_info']")
	private WebElement MsgField;
	
	@FindBy(xpath="(//button[@class='pull-left btn btn-default'])[2]")
	private WebElement goButtonField;
	
	@FindBy(xpath="//section[@class='content-header']")
	private WebElement goBackMsgField;
	
	@FindBy(xpath="//select[@class='form-control input-sm select input-xs']")
	private WebElement showdropdowninClient;
	
	
	public void addClient() throws IOException, InterruptedException {
		String expectedMsg =ExcelUtility.getString(1, 9, System.getProperty("user.dir")+constants.Constants.EXCELFILE,"Client");
		String actualMsg;
		Thread.sleep(2000);
		PageUtility.clickOnElement(moreInfoButton);
		PageUtility.clickOnElement(AddClientField);
		String Name =ExcelUtility.getString(0, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Client");
		String companyname = ExcelUtility.getString(0, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE,"Client");
		String Location =ExcelUtility.getString(0, 2, System.getProperty("user.dir")+constants.Constants.EXCELFILE,"Client");
		String clientaddress= ExcelUtility.getString(0, 3, System.getProperty("user.dir")+constants.Constants.EXCELFILE,"Client");
		String cityname =ExcelUtility.getString(0, 4, System.getProperty("user.dir")+constants.Constants.EXCELFILE,"Client");
		String email= ExcelUtility.getString(0, 7, System.getProperty("user.dir")+constants.Constants.EXCELFILE,"Client");
		String commentMsg=ExcelUtility.getString(0, 9, System.getProperty("user.dir")+constants.Constants.EXCELFILE,"Client");
		PageUtility.enterText(clientName, Name);
		PageUtility.enterText(company, companyname);
		PageUtility.enterText(geoLocate, Location);
		PageUtility.enterText(address, clientaddress);
		PageUtility.enterText(city, cityname);
		PageUtility.enterText(EmailId,email);
		PageUtility.enterText(comment,commentMsg);
		boolean Buttonenabled=AddClientButton.isEnabled();
		Assert.assertTrue(Buttonenabled, "Add Client Failed ");
		PageUtility.clickOnElement(AddClientButton);
		actualMsg=AddClientMsg.getText();
		Assert.assertEquals(expectedMsg, actualMsg,"Couldn't add a client");
	}
	public void showButtonSelectedNumberOfRowsDisplayed() throws IOException {
		String expectedMsg =ExcelUtility.getString(1, 8, System.getProperty("user.dir")+constants.Constants.EXCELFILE,"Client");
		String actualMsg;
		PageUtility.clickOnElement(moreInfoButton);
		Select objSelect=new Select(showdropdowninClient);
		List<WebElement>option=objSelect.getOptions();
		for(WebElement Inputmenu:option) {
			String show=Inputmenu.getText();
			if(show.contains("10")) {
				Inputmenu.click();
				break;
			}
		}	
		actualMsg=MsgField.getText();
		Assert.assertEquals(expectedMsg, actualMsg,"show button number and selected number of rows is different");
	}	
	public void searchField() throws IOException {
		String searchMsg =ExcelUtility.getString(1, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Client");
		String expectedMsg =ExcelUtility.getString(2, 8, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Client");
		String actualmsg;
		PageUtility.clickOnElement(moreInfoButton);
		boolean searchDisplayed=search.isDisplayed();
		Assert.assertTrue(searchDisplayed,"search is not displayed");
		PageUtility.enterText(search, searchMsg);
		List<WebElement>NumberOfRows=rowcount;
    	for(WebElement row:NumberOfRows) {
    		int count=NumberOfRows.size();
    			break;
    		}
    	actualmsg=searchbuttonmsg.getText();
		Assert.assertEquals(expectedMsg, actualmsg,"search not possible");
	}
	public void gobackButton() throws IOException {
		String expectedMsg =ExcelUtility.getString(2, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Client");
		String actualmsg;
		PageUtility.clickOnElement(moreInfoButton);
		WaitUtility.waitForElement(driver, AddClientField);
		PageUtility.clickOnElement(AddClientField);
		boolean button=goButtonField.isEnabled();
		Assert.assertTrue(button,"gobutton is not enabled ");
		PageUtility.clickOnElement(goButtonField);	
		actualmsg=goBackMsgField.getText();
		Assert.assertEquals(expectedMsg, actualmsg,"go back button is not working");
	}
	public void getTitleClientPageVerification() throws IOException{
		String expectedTitle =ExcelUtility.getString(3, 8, System.getProperty("user.dir") + System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Client");
		String actualTitle;
		WaitUtility.waitForElement(driver, moreInfoButton);
		PageUtility.clickOnElement(moreInfoButton);
		actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle,"Title didn't get ClientPage ");
	    }
}
