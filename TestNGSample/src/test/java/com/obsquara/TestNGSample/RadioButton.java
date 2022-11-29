package com.obsquara.TestNGSample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButton extends Base {
	@Test
	public void isSelectedSample() {
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		WebElement male=driver.findElement(By.xpath("(//div[@class='form-check form-check-inline'])[1]"));
		WebElement female=driver.findElement(By.xpath("(//div[@class='form-check form-check-inline'])[2]"));
		WebElement showSelectedValueButton=driver.findElement(By.xpath("//button[@id='button-one']"));
		boolean maleFieldSelected=male.isSelected();
		boolean femaleFieldSelected=female.isSelected();
		if(maleFieldSelected == false|| femaleFieldSelected==false) {
			showSelectedValueButton.click();
			Assert.assertEquals(maleFieldSelected, femaleFieldSelected,"Radio button is Not checked");
		}
		
	}
	@Test
	public void isSelecetedMaleField() {
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		WebElement maleButton=driver.findElement(By.xpath("(//label[@class='form-check-label'])[1]"));
		//WebElement female=driver.findElement(By.xpath("(//div[@class='form-check form-check-inline'])[2]"));
		WebElement showSelectedValueButton=driver.findElement(By.xpath("//button[@id='button-one']"));
		maleButton.click();
		//boolean maleFieldSelected=maleButton.isSelected();
		//boolean femaleFieldSelected=female.isSelected();
		if(maleButton.isSelected()) {
			showSelectedValueButton.click();
			Assert.assertEquals(maleButton.isSelected(), "Radio button 'Male' is checked");
		}
		Assert.assertEquals(maleButton.isSelected(),"Radio button is Not checked");
	}
	@Test	
public void  radioButtonMale() {
		String expectedMsg="Radio button 'Male' is checked",actualMsg;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		WebElement maleButton=driver.findElement(By.xpath("(//label[@class='form-check-label'])[1]"));
		WebElement showSelectedValueButton=driver.findElement(By.xpath("//button[@id='button-one']"));
		WebElement msgField=driver.findElement(By.xpath("//div[@id='message-one']"));
		if(maleButton.isEnabled()) {
		maleButton.click();
		maleButton.isSelected();
			showSelectedValueButton.click();
			actualMsg=msgField.getText();
			Assert.assertEquals(expectedMsg,actualMsg,"Radio button 'Male' is checked");
		
		}
		
		Assert.assertEquals(expectedMsg,"Radio button is Not checked");
	}
@Test			
public void radioButtonFemale() {
	String expectedMsg="Radio button 'Female' is checked",actualMsg ;
	driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
	WebElement femaleButton=driver.findElement(By.xpath("(//label[@class='form-check-label'])[2]"));
	WebElement showSelectedValueButton=driver.findElement(By.xpath("//button[@id='button-one']"));
	WebElement msgField=driver.findElement(By.xpath("//div[@id='message-one']"));
	if(femaleButton.isEnabled()) {
		femaleButton.click();
		femaleButton.isSelected();
		showSelectedValueButton.click();
		actualMsg=msgField.getText();
		Assert.assertEquals(expectedMsg,actualMsg,"Radio button 'Female' is checked");
	
	}
	
	Assert.assertEquals(expectedMsg,"Radio button is Not checked");
}
}


