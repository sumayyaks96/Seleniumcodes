package com.obsquara.testScripts;

import org.testng.annotations.Test;

import com.obsquara.POMSampleProject.Base;
import com.obsquara.Pages.RedioButtonDemoPage;

public class RadioButtonDemoTest extends Base{
	RedioButtonDemoPage obj;
	@Test
	public void verifyRadioButtonDemoWithNoSelectedField() {
		obj=new RedioButtonDemoPage(driver);
		obj.maleAndFemlaeNotSelected();
		
	}
	@Test
	public void verifyRadioButtonMaleField() {
		obj=new RedioButtonDemoPage(driver);
		obj.radioButtonMale();
	}
	@Test
	public void verifyRadioButtonFemaleField() {
		obj=new RedioButtonDemoPage(driver);
		obj.radioButtonFemale();
	}

}
