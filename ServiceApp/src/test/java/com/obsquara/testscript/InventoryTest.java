package com.obsquara.testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsquara.pages.ClientPage;
import com.obsquara.pages.InventoryPage;
import com.obsquara.pages.LoginPage;
import com.obsquara.serviceapp.Base;

public class InventoryTest extends Base{
	LoginPage obj1;
	InventoryPage obj;
	@Test
	public void verifySearchButtonField() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPage();
		obj=new InventoryPage(driver);
		obj.searchField();
	}
	@Test
	public void verifyTotalInventoryCount() throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPage();
		obj=new InventoryPage(driver);
		obj.totalInventoryCount();
	}
	@Test
	public void verifyaddproduct( ) throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPage();
		obj=new InventoryPage(driver);
		//obj.addProduct(,);
	}
	@Test
	public void verifydeleteproduct( ) throws IOException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPage();
		obj=new InventoryPage(driver);
		obj.deleteAProductInPendingRepair();
	}
	@Test
	public void verifyTitleOfTheInvendarypage( ) throws IOException, InterruptedException {
		obj1=new LoginPage(driver);
		obj1.verifyLoginPage();
		obj=new InventoryPage(driver);
		obj.getTitleInventoryPageVerification();
	}

}
