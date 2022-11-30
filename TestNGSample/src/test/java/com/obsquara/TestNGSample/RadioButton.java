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
@Test
public void groupRadioButtonDemo() {
	String expectedMsg="Gender : Male, Age group: 1 to 18",actualMsg = null;
	boolean maleButtonSelected=true,ageGroupButtonseelected=true;
	driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
	WebElement maleButton=driver.findElement(By.xpath("//input[@id='inlineRadio11']"));
	WebElement age1_18=driver.findElement(By.xpath("//input[@id='inlineRadio22']"));
	WebElement getResultButton=driver.findElement(By.xpath("//button[@id='button-two']"));
	WebElement msgField=driver.findElement(By.xpath("//div[@id='message-two']"));
	maleButton.click();
	age1_18.click();
	maleButtonSelected=maleButton.isSelected();
	ageGroupButtonseelected=age1_18.isSelected();
	if(maleButtonSelected && ageGroupButtonseelected) {
		getResultButton.click();
		actualMsg=msgField.getText();
		Assert.assertEquals(expectedMsg, actualMsg,"Gender : Male, Age group: 1 to 18");
		
	}
	//Assert.assertEquals(maleButtonSelected, ageGroupButtonseelected,"Male button and age group button are not selected");
	
	
}
@Test
public void groupRadioButtonDemo2() {
	String expectedMsg="Gender : Male, Age group: 1 to 18",actualMsg = null;
	boolean femaleButtonSelected=true,ageGroupButtonseelected=true;
	driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
	WebElement femaleElement=driver.findElement(By.xpath("//input[@id='inlineRadio21']"));
	WebElement age19_44=driver.findElement(By.xpath("//input[@id='inlineRadio23']"));
	WebElement getResultButton=driver.findElement(By.xpath("//button[@id='button-two']"));
	WebElement msgField=driver.findElement(By.xpath("//div[@id='message-two']"));
	femaleElement.click();
	age19_44.click();
	femaleButtonSelected=femaleElement.isSelected();
	ageGroupButtonseelected=age19_44.isSelected();
	if(femaleButtonSelected && ageGroupButtonseelected) {
		getResultButton.click();
		actualMsg=msgField.getText();
		Assert.assertEquals(expectedMsg, actualMsg,"radioButton not checked");
		
	}
	//Assert.assertEquals(maleButtonSelected, ageGroupButtonseelected,"Male button and age group button are not selected");
	
	
}
@Test
public void groupRadioButton() {
	String expectedMsg="Gender : Male\nAge group: 1 to 18",actualMsg = null;
	boolean maleButtonSelected=true,ageGroupButtonseelected=true;
	driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
	WebElement maleButton=driver.findElement(By.xpath("(//label[@class='form-check-label'])[3]"));
	WebElement age1_18=driver.findElement(By.xpath("(//label[@class='form-check-label'])[5]"));
	WebElement getResultButton=driver.findElement(By.xpath("//button[@id='button-two']"));
	WebElement msgField=driver.findElement(By.xpath("//div[@id='message-two']"));
	if(maleButton.isEnabled()) {
		maleButton.click();
		maleButtonSelected=maleButton.isSelected();
		if(age1_18.isEnabled()) {
			age1_18.click();
			ageGroupButtonseelected=age1_18.isSelected();
			
		}
		getResultButton.click();
		actualMsg=msgField.getText();
		Assert.assertEquals(expectedMsg, actualMsg,"Msg field not selected");
	}
}
}


