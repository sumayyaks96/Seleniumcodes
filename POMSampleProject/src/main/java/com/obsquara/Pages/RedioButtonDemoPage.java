package com.obsquara.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RedioButtonDemoPage {
	WebDriver driver;
	By maleField=By.xpath("//input[@id='inlineRadio1']");
	By femaleField=By.xpath("//input[@id='inlineRadio2']");
	By showSelectedValueButton=By.xpath("//button[@id='button-one']");
	By msgField=By.xpath("//div[@id='message-one']");
	public RedioButtonDemoPage(WebDriver driver) {
		this.driver=driver;
	}
	public void maleAndFemlaeNotSelected() {
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		boolean maleFieldSelected,femaleFieldSelected;
		String expectedMsg="Radio button is Not checked",actualMsg;
		driver.findElement(maleField);
		driver.findElement(femaleField);
		driver.findElement(showSelectedValueButton);
		maleFieldSelected=driver.findElement(femaleField).isSelected();
		femaleFieldSelected=driver.findElement(femaleField).isSelected();
		if(maleFieldSelected == false|| femaleFieldSelected==false) {
			driver.findElement(showSelectedValueButton).click();
			actualMsg=driver.findElement(msgField).getText();
			Assert.assertEquals(maleFieldSelected, femaleFieldSelected,"Radio button field is selected");
		}
		
	}
	public void  radioButtonMale() {
		String expectedMsg="Radio button 'Male' is checked",actualMsg;
		boolean isEnabledMaleField,isSelectedMaleField;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		isEnabledMaleField=driver.findElement(maleField).isEnabled();
		if(isEnabledMaleField) {
			driver.findElement(maleField).click();
			isSelectedMaleField=driver.findElement(maleField).isSelected();
			driver.findElement(showSelectedValueButton).click();
			actualMsg=driver.findElement(msgField).getText();
			Assert.assertEquals(expectedMsg,actualMsg,"Radio button 'Male' is not checked");
		}
		
		Assert.assertEquals(expectedMsg,"Radio button is Not checked");
	}
	public void  radioButtonFemale() {
		String expectedMsg="Radio button 'Female' is checked",actualMsg;
		boolean isEnabledFemaleField,isSelectedFemaleField;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		isEnabledFemaleField=driver.findElement(maleField).isEnabled();
		if(isEnabledFemaleField) {
			driver.findElement(femaleField).click();
			isSelectedFemaleField=driver.findElement(femaleField).isSelected();
			driver.findElement(showSelectedValueButton).click();
			actualMsg=driver.findElement(msgField).getText();
			Assert.assertEquals(expectedMsg,actualMsg,"Radio button 'Female' not is checked");
		}
		
		Assert.assertEquals(expectedMsg,"Radio button is Not checked");
	}
}
