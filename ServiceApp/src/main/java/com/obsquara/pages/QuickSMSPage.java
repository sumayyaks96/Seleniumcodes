package com.obsquara.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.obsquara.utilities.ExcelUtility;
import com.obsquara.utilities.PageUtility;

public class QuickSMSPage {
	public WebDriver driver;
	public QuickSMSPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='identity']")
	private WebElement usernameField;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@class='btn btn-primary btn-block btn-flat']")
	private WebElement loginButton;
	
	@FindBy(xpath="//input[@id='phone_number']")
	private WebElement phoneNumber;
	
	@FindBy(xpath="//textarea[@placeholder='SMS Text']")
	private WebElement smstext ;
	
	@FindBy(xpath="(//button[@class='pull-right btn btn-default'])[2]")
	private WebElement sendButton ;
	
	@FindBy(xpath="(//button[@class='pull-right btn btn-default'])[2]")
	private WebElement AlertMsg ;
	
	@FindBy(xpath="(//button[@class='pull-right btn btn-default'])[2]")
	private WebElement AlertButton ;
	
	@FindBy(xpath="(//li[@class='parsley-required'])[2]")
	private WebElement MsgField ;
	
	public void quicksmsField() throws IOException {
		String Username =ExcelUtility.getString(0, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"LoginPage");
		String password = ExcelUtility.getString(0, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"LoginPage");
		PageUtility.enterText(usernameField, Username);
		PageUtility.enterText(passwordField, password);
		PageUtility.clickOnElement(loginButton);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("window.scrollBy(0,750)", "");
		String phone =ExcelUtility.getString(0, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"QuickSMS");
		String sms= ExcelUtility.getString(0, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"QuickSMS");
		String expectedMsg= ExcelUtility.getString(0, 2, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"QuickSMS");
		String actualMsg = null;
		PageUtility.enterText(phoneNumber, phone);
		PageUtility.enterText(smstext, sms);
		PageUtility.clickOnElement(sendButton);
		Assert.assertEquals(expectedMsg,actualMsg,"Message not send");
	}
	public void quicksmsFieldWithNoSMS() throws IOException {
		String Username =ExcelUtility.getString(0, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"LoginPage");
		String password = ExcelUtility.getString(0, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"LoginPage");
		PageUtility.enterText(usernameField, Username);
		PageUtility.enterText(passwordField, password);
		PageUtility.clickOnElement(loginButton);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("window.scrollBy(0,750)", "");
		String phone =ExcelUtility.getString(0, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"QuickSMS");
		String expectedMsg= ExcelUtility.getString(0, 2, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"QuickSMS");
		String actualMsg;
		PageUtility.enterText(phoneNumber, phone);
		PageUtility.clickOnElement(sendButton);
		actualMsg=MsgField.getText();
		Assert.assertEquals(expectedMsg,actualMsg,"Message send done");
	}
	
}
