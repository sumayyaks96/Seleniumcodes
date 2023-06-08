package com.obsquara.testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.obsquara.pages.LoginPage;
import com.obsquara.pages.QuickSMSPage;
import com.obsquara.serviceapp.Base;

public class QuickSMSTest extends Base {
	QuickSMSPage obj;
	LoginPage obj1;
	@Test
	public void verifyQuickSMSField() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPage();
		obj=new QuickSMSPage(driver);
		obj.quicksmsField();
		
	}
	@Test
	public void verifyQuickSMSFieldWithOutSMS() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPage();
		obj=new QuickSMSPage(driver);
		obj.quicksmsFieldWithNoSMS();
		
	}
	@Test
	public void verifyQuickSMSFieldWithOutSMSUsingFaker() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPage();
		obj=new QuickSMSPage(driver);
		obj.quicksmsFieldWithNoSMSUsingFaker();
		
	}
	

}
