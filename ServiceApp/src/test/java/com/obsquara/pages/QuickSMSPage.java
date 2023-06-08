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
import com.obsquara.utilities.FakerUtility;
import com.obsquara.utilities.PageUtility;

public class QuickSMSPage {
	public WebDriver driver;
	public QuickSMSPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
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
	
	@FindBy(xpath="//li[@class='parsley-required']")
	private WebElement MsgField ;
	
	public void quicksmsField() throws IOException {
		PageUtility.ScrollBy(driver);
		String phone =ExcelUtility.getNumeric(0, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"QuickSMS");
		String sms= ExcelUtility.getString(0, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"QuickSMS");
		String expectedUrl= ExcelUtility.getString(0, 3, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"QuickSMS");
		String actualUrl = null;
		PageUtility.enterText(phoneNumber, phone);
		PageUtility.enterText(smstext, sms);
		PageUtility.clickOnElement(sendButton);
		actualUrl=driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl,actualUrl,"Message not send");
	}
	public void quicksmsFieldWithNoSMS() throws IOException {
		PageUtility.ScrollBy(driver);
		String phone =ExcelUtility.getNumeric(0, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"QuickSMS");
		String expectedMsg= ExcelUtility.getString(0, 2, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"QuickSMS");
		String actualMsg;
		PageUtility.enterText(phoneNumber, phone);
		PageUtility.clickOnElement(sendButton);
		actualMsg=MsgField.getText();
		Assert.assertEquals(expectedMsg,actualMsg,"Message send done");
	}
	public void quicksmsFieldWithNoSMSUsingFaker() throws IOException {
		PageUtility.ScrollBy(driver);
		String expectedMsg= ExcelUtility.getString(0, 2, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"QuickSMS");
		String actualMsg;
		FakerUtility.phoneNumber();
		PageUtility.clickOnElement(sendButton);
		actualMsg=MsgField.getText();
		Assert.assertEquals(expectedMsg,actualMsg,"Message send done");
	}
	
}
