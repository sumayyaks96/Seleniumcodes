package com.obsquara.testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsquara.pages.LoginPage;
import com.obsquara.pages.QuickEmailPage;
import com.obsquara.serviceapp.Base;

public class QuickEmailTest extends Base{
	QuickEmailPage obj;
	LoginPage obj1;
	@Test(groups= {"SmokeTest"})
	public void verifyQuickEmailWithoutMessage() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPageSample();
		obj=new QuickEmailPage(driver);
		obj.quickemailFieldWithoutMsg();
		
	}
	@Test(groups= {"SmokeTest"})
	public void verifyQuickEmail() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPageSample();
		obj=new QuickEmailPage(driver);
		obj.quickemailField();
		
	}
	@Test(groups= {"RegressionTest"})
	public void verifyQuickEmailWithoutSubject() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPageSample();
		obj=new QuickEmailPage(driver);
		obj.quickemailFieldWithoutSubject();
		
	}
	@Test(groups= {"RegressionTest"})
	public void verifyQuickEmailWithoutEmail() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPageSample();
		obj=new QuickEmailPage(driver);
		obj.quickemailFieldWithoutEmail();
		
	}

}
