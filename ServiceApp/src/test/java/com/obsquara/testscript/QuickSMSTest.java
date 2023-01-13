package com.obsquara.testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.obsquara.pages.QuickSMSPage;
import com.obsquara.serviceapp.Base;

public class QuickSMSTest extends Base {
	QuickSMSPage obj;
	@Test
	public void verifyQuickSMSField() throws IOException {
		obj=new QuickSMSPage(driver);
		obj.quicksmsField();
		
	}
	public void verifyQuickSMSFieldWithOutSMS() throws IOException {
		obj=new QuickSMSPage(driver);
		obj.quicksmsFieldWithNoSMS();
		
	}
	

}
