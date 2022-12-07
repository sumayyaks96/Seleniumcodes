package com.obsquara.testScripts;

import org.testng.annotations.Test;

import com.obsquara.POMSampleProject.Base;
import com.obsquara.Pages.SimpleFormDemoPage;

public class SimpleFormDemoTest extends Base {
	SimpleFormDemoPage obj;
	@Test
	public void enterMsgandVerifySingleInpuyField() {
		obj=new SimpleFormDemoPage(driver);
		obj.verifyEnterMsgField();
}
	@Test
	public void withoutMsgAndVerifySingleInputField() {
		obj=new SimpleFormDemoPage(driver);
		obj.verifyEnterMsgFieldWithoutMsg();
	}
	@Test
	public void verifyTwoInputField() {
		obj=new SimpleFormDemoPage(driver);
		obj.twoInputField();
	}
}
