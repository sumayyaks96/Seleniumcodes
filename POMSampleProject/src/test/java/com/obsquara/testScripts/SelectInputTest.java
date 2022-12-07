package com.obsquara.testScripts;

import org.testng.annotations.Test;

import com.obsquara.POMSampleProject.Base;
import com.obsquara.Pages.SelectInputPage;

public class SelectInputTest extends Base{
	SelectInputPage obj;
	@Test
	public void selectColorAndVerifySelectField(){
		obj=new SelectInputPage(driver);
		obj.selectInputDemoField();
	}
	
}
