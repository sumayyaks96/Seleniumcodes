package com.obsquara.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.obsquara.serviceapp.Base;
import com.obsquara.utilities.ExcelUtility;
import com.obsquara.utilities.PageUtility;

public class LoginPage{
	WebDriver driver;
	public LoginPage(WebDriver driver ) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='identity']")
	private WebElement usernameField;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@class='btn btn-primary btn-block btn-flat']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement loginMsgField;
	
	
	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service//panel/login/forgot_password']")
	private WebElement ForgotPasswordField;
	
	@FindBy(xpath="//input[@name='identity']")
	private WebElement emailIdField;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement submitButton;
	
	@FindBy(xpath="//div[@id='infoMessage']")
	private WebElement MsgField;
	
	public void verifyLoginPage() throws IOException {
		String expectedMsg=ExcelUtility.getString(1, 2, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"LoginPage"),actualMsg = null;
		String Username =ExcelUtility.getString(0, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"LoginPage");
		String password = ExcelUtility.getString(0, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"LoginPage");
		PageUtility.enterText(usernameField, Username);
		PageUtility.enterText(passwordField, password);
		PageUtility.clickOnElement(loginButton);
		actualMsg=loginMsgField.getText();
		Assert.assertEquals(expectedMsg, actualMsg,"Login Failed ");		
	}
	public void loginPageIncorrectPassword() throws IOException {
		String Username =ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"LoginPage");
		String password = ExcelUtility.getString(1, 1, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"LoginPage");
		PageUtility.enterText(usernameField, Username);
		PageUtility.enterText(passwordField, password);
		PageUtility.clickOnElement(loginButton);
		Assert.assertTrue(true, "Login succesfully ");		
	
	}
	public void verifyForgotPassword() throws IOException {
		String Expectedmsg=ExcelUtility.getString(0, 2, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"LoginPage");
		String ActualMsg;
		String Emailid =ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"LoginPage");
		PageUtility.clickOnElement(ForgotPasswordField);
		PageUtility.enterText(emailIdField, Emailid);
		PageUtility.clickOnElement(submitButton);
		ActualMsg=MsgField.getText();
		Assert.assertEquals(Expectedmsg, ActualMsg,"Reset password");
		
		
	}

}
