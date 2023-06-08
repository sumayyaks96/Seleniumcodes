package com.obsquara.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.obsquara.utilities.ExcelUtility;
import com.obsquara.utilities.PageUtility;
import com.obsquara.utilities.WaitUtility;

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
	
	@FindBy(xpath="//a[text()=' ← Back to login!']")
	private WebElement backtologinField;
	
	public void verifyLoginPageSample() throws IOException {
		String Username =ExcelUtility.getString(0, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"LoginPage");
		String password = ExcelUtility.getString(0, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"LoginPage");
		String expectedUrl =ExcelUtility.getString(3, 2, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"LoginPage");
		String actualUrl;
		PageUtility.enterText(usernameField, Username);
		PageUtility.enterText(passwordField, password);
		WaitUtility.waitForElement(driver, loginButton);
		PageUtility.clickOnElement(loginButton);
		WaitUtility.waitForElement(driver, loginMsgField);
		actualUrl=driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl,"Login Failed");
	}
	
	
	public void loginPageIncorrectPassword() throws IOException {
		String Username =ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"LoginPage");
		String password = ExcelUtility.getString(1, 1, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"LoginPage");
		String expectedUrl =ExcelUtility.getString(4, 2, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"LoginPage");
		String actualUrl;
		PageUtility.enterText(usernameField, Username);
		PageUtility.enterText(passwordField, password);
		boolean buttonisEnabled=loginButton.isEnabled();
		Assert.assertTrue(buttonisEnabled, "loginButton is not Enabled ");
		PageUtility.clickOnElement(loginButton);
		actualUrl=driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl,"Login Succesfully");
		
	}
	public void verifyForgotPassword() throws IOException {
		String Expectedmsg=ExcelUtility.getString(0, 2, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"LoginPage");
		String ActualMsg;
		String Emailid =ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"LoginPage");
		PageUtility.clickOnElement(ForgotPasswordField);
		PageUtility.enterText(emailIdField, Emailid);
		WaitUtility.waitForElement(driver, submitButton);
		PageUtility.clickOnElement(submitButton);
		ActualMsg=MsgField.getText();
		Assert.assertEquals(Expectedmsg, ActualMsg,"Reset password");
		
		
	}
	public void verifyLoginPage() throws IOException {
		String Username =ExcelUtility.getString(0, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"LoginPage");
		String password = ExcelUtility.getString(0, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"LoginPage");
		PageUtility.enterText(usernameField, Username);
		PageUtility.enterText(passwordField, password);
		boolean buttonisEnabled=loginButton.isEnabled();
		Assert.assertTrue(buttonisEnabled,"Login Failed");	
		PageUtility.clickOnElement(loginButton);	
	}
	public void backToLoginPageButtonInForgotPasswordField() throws IOException {
		String expectedUrl =ExcelUtility.getString(5, 2, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"LoginPage");
		String actualUrl;
		PageUtility.clickOnElement(ForgotPasswordField);
		boolean backtoLoginIsDisplayed=backtologinField.isDisplayed();
		Assert.assertTrue(backtoLoginIsDisplayed, "BacktoLogin Field not displayed");
		PageUtility.clickOnElement(backtologinField);
		actualUrl=driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl,"Back to login button not working ");	
	}
	

}
