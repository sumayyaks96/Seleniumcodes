package com.obsquara.testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsquara.pages.LoginPage;
import com.obsquara.pages.ReparationPage;
import com.obsquara.serviceapp.Base;

public class ReparationTest extends Base{
	ReparationPage obj;
	LoginPage obj1;
	@Test(priority=4)
	public void verifyNumberOfCompletedRepairs() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPage();
		obj=new ReparationPage(driver);
		obj.completedrepairCount();
		
	}
	@Test(priority=3)
	public void verifyNumberOfPendingRepairs() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPage();
		obj=new ReparationPage(driver);
		obj.pendingrepairCount();
		
	}
	@Test
	public void verifySearchField() throws IOException, InterruptedException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPage();
		obj=new ReparationPage(driver);
		obj.searchField();
		
	}
	@Test(priority=1)
	public void verifyNextButtonInpendingRepairfield() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPage();
		obj=new ReparationPage(driver);
		obj.nextButtonVerificationInPendingRepair();
		
	}
	@Test(priority=2)
	public void verifyPreviousButtonInpendingRepairfield() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPage();
		obj=new ReparationPage(driver);
		obj.previousButtonVerificationInPendingRepair();
		
	}
	@Test
	public void verifyTitleReperationPage() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPage();
		obj=new ReparationPage(driver);
		obj.getTitleReperationPageVerification();
		
	}

}
