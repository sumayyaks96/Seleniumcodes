package com.obsquara.testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsquara.pages.QuickEmailPage;
import com.obsquara.serviceapp.Base;

public class QuickEmailTest extends Base{
	QuickEmailPage obj;
	@Test
	public void verifyQuickEmailWithoutMessage() throws IOException {
		obj=new QuickEmailPage(driver);
		obj.quickemailFieldWithoutMsg();
		
	}
	@Test
	public void verifyQuickEmail() throws IOException {
		obj=new QuickEmailPage(driver);
		obj.quickemailField();
		
	}

}
