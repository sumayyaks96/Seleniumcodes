package com.obsquara.testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsquara.pages.LoginPage;
import com.obsquara.serviceapp.Base;

public class LoginTest extends Base{
	LoginPage obj;
	
	@Test(groups= {"SmokeTest"})
	public void verifyLoginUsingCorrectUsernameAndPass() throws IOException {
		obj=new LoginPage(driver);
		obj.verifyLoginPageSample();
	}
	@Test(groups= {"RegressionTest"})
	public void verifyLoginUsingIncorrectPassword() throws IOException {
		obj=new LoginPage(driver);
		obj.loginPageIncorrectPassword();
	}
	@Test(groups= {"RegressionTest"})
	public void verifyForgotPasswordUsingIncorrectMailid() throws IOException {
		obj=new LoginPage(driver);
		obj.verifyForgotPassword();
	}
	@Test(priority=1)
	public void verifyLoginUsingCorrectUsernameAndPassword() throws IOException {
		obj=new LoginPage(driver);
		obj.verifyLoginPage();
	}
	@Test(groups= {"RegressionTest"})
	public void verifyBackToLoginINForgotPassword() throws IOException {
		obj=new LoginPage(driver);
		obj.backToLoginPageButtonInForgotPasswordField();
	}

}
