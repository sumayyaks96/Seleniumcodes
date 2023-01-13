package com.obsquara.testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsquara.pages.LoginPage;
import com.obsquara.pages.ReparationPage;
import com.obsquara.serviceapp.Base;

public class ReparationTest extends Base{
	ReparationPage obj;
	LoginPage obj1;
	@Test
	public void verifyNumberOfCompletedRepairs() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPage();
		obj=new ReparationPage(driver);
		obj.completedrepairCount();
		
	}
	@Test
	public void verifyNumberOfPendingRepairs() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPage();
		obj=new ReparationPage(driver);
		obj.pendingrepairCount();
		
	}

}
