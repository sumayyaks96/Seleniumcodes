package com.obsquara.testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsquara.pages.ClientPage;
import com.obsquara.pages.LoginPage;
import com.obsquara.serviceapp.Base;

public class ClientTest extends Base{
	ClientPage obj;
	LoginPage obj1;
	@Test(groups= {"SmokeTest"})
	public void verifyAddClientField() throws IOException, InterruptedException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPage();
		obj=new ClientPage(driver);
		obj.addClient();
	}
	@Test(groups= {"RegressionTest"})
	public void verifyshowButtonSelectNumberDisplayedOrNot() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPage();
		obj=new ClientPage(driver);
		obj.showButtonSelectedNumberOfRowsDisplayed();
	}
	@Test(groups= {"SmokeTest"})
	public void verifySearchButtonField() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPage();
		obj=new ClientPage(driver);
		obj.searchField();
	}
	@Test(groups= {"RegressionTest"})
	public void verifygoButtonField() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPage();
		obj=new ClientPage(driver);
		obj.gobackButton();
	}
	@Test
	public void verifytitleClientPage() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPage();
		obj=new ClientPage(driver);
		obj.getTitleClientPageVerification();
	}

}
