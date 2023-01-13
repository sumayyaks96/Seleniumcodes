package com.obsquara.testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsquara.pages.LoginPage;
import com.obsquara.serviceapp.Base;

public class LoginTest extends Base{
	LoginPage obj;
	@Test
	public void verifyLoginUsingCorrectUsernameAndPassword() throws IOException {
		obj=new LoginPage(driver);
		obj.verifyLoginPage();
	}
	@Test
	public void verifyLoginUsingIncorrectPassword() throws IOException {
		obj=new LoginPage(driver);
		obj.loginPageIncorrectPassword();
	}
	@Test
	public void verifyForgotPasswordUsingIncorrectMailid() throws IOException {
		obj=new LoginPage(driver);
		obj.verifyForgotPassword();
	}

}
