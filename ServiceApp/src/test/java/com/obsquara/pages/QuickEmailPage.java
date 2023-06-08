package com.obsquara.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.obsquara.utilities.ExcelUtility;
import com.obsquara.utilities.FakerUtility;
import com.obsquara.utilities.PageUtility;

public class QuickEmailPage {
	public WebDriver driver;
	public QuickEmailPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='emailto_']")
	private WebElement EmailIdField ;
	
	@FindBy(xpath="//input[@id='subject_']")
	private WebElement subjectField ;
	
	@FindBy(xpath="(//textarea[@name='body'])[1]")
	private WebElement EnterMessageField ;
	
	@FindBy(xpath="(//button[@class='pull-right btn btn-default'])[1]")
	private WebElement sendButton ;
	
	@FindBy(xpath="//ul[@id='parsley-id-9']")
	private WebElement MsgField ;
	
	@FindBy(xpath="//textarea[@id='body_']")
    private WebElement msgFileldQuickEmail;
	
	@FindBy(xpath="//ul[@id='parsley-id-5']")
	private WebElement MsgFieldEmail ;
	
	@FindBy(xpath="//ul[@id='parsley-id-7']")
	private WebElement MsgFieldSubject ;
	
	public void quickemailFieldWithoutMsg() throws IOException {
		PageUtility.ScrollBy(driver);
		String Email_Id =ExcelUtility.getString(0, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"QuickEmail");
		String sms= ExcelUtility.getString(0, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"QuickEmail");
		String expectedMsg= ExcelUtility.getString(0, 2, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"QuickEmail");
		String actualMsg = null;
		PageUtility.enterText(EmailIdField, Email_Id);
		PageUtility.enterText(subjectField, sms);
		PageUtility.clickOnElement(sendButton);
		actualMsg=MsgField.getText();
		Assert.assertEquals(expectedMsg,actualMsg,"Message not send");
	}
	public void quickemailField() throws IOException {
		PageUtility.ScrollBy(driver);
		String Email_Id =ExcelUtility.getString(0, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"QuickEmail");
		String sms= ExcelUtility.getString(0, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"QuickEmail");
		String MessageField= ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"QuickEmail");
		String expectedUrl= ExcelUtility.getString(0, 3, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"QuickEmail");
		String actualUrl = null;
		PageUtility.enterText(EmailIdField, Email_Id);
		PageUtility.enterText(subjectField, sms);
		PageUtility.enterText(EnterMessageField, MessageField);
		boolean button=sendButton.isEnabled();
		Assert.assertTrue(button,"button is Enabled");
		PageUtility.clickOnElement(sendButton);
		actualUrl=driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl,"Email not send");	
	}
	public void quickemailFieldWithoutSubject() throws IOException {
		 PageUtility.ScrollBy(driver);
		 String actualMsg;
		 String Email_Id =FakerUtility.fakeValuesServiceEmail();
		 String msg= FakerUtility.cityName();
		 String expectedMsg= ExcelUtility.getString(0, 2, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"QuickEmail");
		 PageUtility.enterText(EmailIdField, Email_Id);
		 PageUtility.enterText(msgFileldQuickEmail, msg);
		 PageUtility.clickOnElement(sendButton);
		 actualMsg=MsgFieldSubject.getText();
		 Assert.assertEquals(expectedMsg,actualMsg,"alert message for missing subject not appeared");
	     } 
		public void quickemailFieldWithoutEmail() throws IOException {
		 PageUtility.ScrollBy(driver);
		 String expectedMsg= ExcelUtility.getString(0, 2, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"QuickEmail");
		 String sub= ExcelUtility.getString(1, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"QuickEmail");
		 String msg= ExcelUtility.getString(1, 2, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"QuickEmail");
		 String actualMsg;
		 PageUtility.enterText(subjectField, sub);
		 PageUtility.enterText(msgFileldQuickEmail, msg);
		 PageUtility.clickOnElement(sendButton);
		 actualMsg=MsgFieldEmail.getText();
		 Assert.assertEquals(expectedMsg,actualMsg,"alert message for missing email not appeared");
	     }
}
