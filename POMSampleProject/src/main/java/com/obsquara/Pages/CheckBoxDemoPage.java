package com.obsquara.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckBoxDemoPage {
	WebDriver driver;
	By clickCheckBox=By.xpath("//input[@id='gridCheck']");
	By singleCheckboxMsgField=By.xpath("//div[@id='message-one']");
	By selectButtonMultipleSelect=By.xpath("//input[@id='button-two']");
	By checkBoxOne=By.xpath("//input[@id='check-box-one']");
	By checkBoxTwo=By.xpath("//input[@id='check-box-two']");
	By checkBoxThree=By.xpath("//input[@id='check-box-three']");
	By checkBoxFour=By.xpath("//input[@id='check-box-four']");
	public CheckBoxDemoPage(WebDriver driver) {
		this.driver=driver;
	}
	public void singleCheckBoxDemoField() {
		String expectedMsg="    Success - Check box is checked",actualMsg;
		boolean isSelectedClickCheckBox;
		driver.navigate().to("https://selenium.obsqurazone.com/check-box-demo.php");
		driver.findElement(clickCheckBox).click();
		driver.findElement(singleCheckboxMsgField);
		isSelectedClickCheckBox=driver.findElement(clickCheckBox).isSelected();
		if(isSelectedClickCheckBox) {
			actualMsg=driver.findElement(singleCheckboxMsgField).getText();
			Assert.assertEquals(expectedMsg, actualMsg,"    Success - Check box is checked");
		}
	}
	public void multipleCheckBoxDemoSelectAll() {
		boolean selectAllButton;
		driver.navigate().to("https://selenium.obsqurazone.com/check-box-demo.php");
		driver.findElement(selectButtonMultipleSelect);
		driver.findElement(checkBoxOne);
		driver.findElement(checkBoxTwo);
		driver.findElement(checkBoxThree);
		driver.findElement(checkBoxFour);
		driver.findElement(selectButtonMultipleSelect).click();
		selectAllButton=driver.findElement(selectButtonMultipleSelect).isSelected();
		Assert.assertTrue(selectAllButton,"Button not selected");
	}

}
