package com.obsquara.testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsquara.pages.ClientPage;
import com.obsquara.pages.HomePage;
import com.obsquara.pages.LoginPage;
import com.obsquara.serviceapp.Base;

public class HomeTest extends Base{
	HomePage obj;
	LoginPage obj1;
	@Test(priority=1)
	public void verifylogoutfield() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPage();
		obj=new HomePage(driver);
		obj.logoutVerification();	
	}
	@Test(priority=2)
	public void verifynavigateToClientPage() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPageSample();
		obj=new HomePage(driver);
		obj.navigateToClientPageVerification();
	}
	@Test(priority=3)
	public void verifyQuickSmsFieldIsBelowQuickEmail() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPageSample();
		obj=new HomePage(driver);
		obj.QuickSmsFieldIsBelowQuickEmail();
	}
	@Test(priority=4)
	public void verifynavigateToReperationPage() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPageSample();
		obj=new HomePage(driver);
		obj.navigateToReperationPageVerification();
	}
	@Test(priority=5)
	public void verifyCloseButtonInRevenueChart() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPageSample();
		obj=new HomePage(driver);
		obj.checkCloseButtonInRevenueChart();
	}
	@Test
	public void verifynavigateToInventoryPage() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPageSample();
		obj=new HomePage(driver);
		obj.navigateToInventoryPageVerification();
	}

}
