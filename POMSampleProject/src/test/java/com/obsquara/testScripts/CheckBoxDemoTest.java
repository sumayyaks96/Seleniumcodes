package com.obsquara.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsquara.POMSampleProject.Base;
import com.obsquara.Pages.CheckBoxDemoPage;

public class CheckBoxDemoTest extends Base{
	CheckBoxDemoPage obj;
	@Test
	public void clickOnThisCheckBoxField() {
		obj=new CheckBoxDemoPage(driver);
		obj.singleCheckBoxDemoField();
	}
	@Test
	public void verifyMultipleCheckBoxSelectAllButton() {
		obj=new CheckBoxDemoPage(driver);
		obj.multipleCheckBoxDemoSelectAll();
	}
}
