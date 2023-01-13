package com.obsquara.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.obsquara.utilities.ExcelUtility;
import com.obsquara.utilities.PageUtility;

public class QuickEmailPage {
	public WebDriver driver;
	public QuickEmailPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='identity']")
	private WebElement usernameField;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@class='btn btn-primary btn-block btn-flat']")
	private WebElement loginButton;
	
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
	
	public void quickemailFieldWithoutMsg() throws IOException {
		String Username =ExcelUtility.getString(0, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"LoginPage");
		String password = ExcelUtility.getString(0, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"LoginPage");
		PageUtility.enterText(usernameField, Username);
		PageUtility.enterText(passwordField, password);
		PageUtility.clickOnElement(loginButton);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("window.scrollBy(0,750)", "");
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
		String Username =ExcelUtility.getString(0, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"LoginPage");
		String password = ExcelUtility.getString(0, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"LoginPage");
		PageUtility.enterText(usernameField, Username);
		PageUtility.enterText(passwordField, password);
		PageUtility.clickOnElement(loginButton);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("window.scrollBy(0,750)", "");
		String Email_Id =ExcelUtility.getString(0, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"QuickEmail");
		String sms= ExcelUtility.getString(0, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"QuickEmail");
		String MessageField= ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"QuickEmail");
		PageUtility.enterText(EmailIdField, Email_Id);
		PageUtility.enterText(subjectField, sms);
		PageUtility.enterText(EnterMessageField, MessageField);
		boolean button=sendButton.isEnabled();
		PageUtility.clickOnElement(sendButton);
		Assert.assertTrue(button,"Email not send");
	}

}
