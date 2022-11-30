package com.obsquara.TestNGSample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonSampleG extends Gurru99Base{
	@Test
	public void verifyRadioButtonTC1() {
		String expectedMsg="Radio button is Not checked",actualMsg;
		WebElement yesButton=driver.findElement(By.xpath("//input[@id='yes']"));
		WebElement noButton=driver.findElement(By.xpath("//input[@id='no']"));
		WebElement checkButton=driver.findElement(By.xpath("//input[@id='buttoncheck']"));
		WebElement MsgField=driver.findElement(By.xpath("//p[@class='radiobutton']"));
		boolean yesSelected=yesButton.isSelected();
		boolean noSelected=noButton.isSelected();
		if(yesSelected==false || noSelected==false) {
			checkButton.click();
			actualMsg=MsgField.getText();
			Assert.assertEquals(expectedMsg,actualMsg,"radio button checked");
			
			
		}
		
	}
	@Test
	public void clickNoButton() {
		String expectedMsg="Radio button is checked and it's value is No",actualMsg;
		boolean noButtonIsSeleceted;
		WebElement noButton=driver.findElement(By.xpath("(//input[@name='name'])[2]"));
		WebElement checkButton=driver.findElement(By.xpath("//input[@id='buttoncheck']"));
		WebElement MsgField=driver.findElement(By.xpath("//p[@class='radiobutton']"));
		noButton.click();
		noButtonIsSeleceted=noButton.isSelected();
		if(noButtonIsSeleceted) {
			checkButton.click();
			actualMsg=MsgField.getText();
			Assert.assertEquals(expectedMsg,actualMsg,"radio button checked");
			
		}
		
	}

}
