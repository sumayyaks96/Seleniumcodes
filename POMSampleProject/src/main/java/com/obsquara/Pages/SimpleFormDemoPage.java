package com.obsquara.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SimpleFormDemoPage {
	WebDriver driver;
	public SimpleFormDemoPage(WebDriver driver ) {
		this.driver=driver;
	}
	By inputField=By.xpath("//input[@id='single-input-field']");
	By showMsgButton=By.xpath("//button[@id='button-one']");
	By msgField=By.xpath("//div[@id='message-one']");
	By twoInputFieldValueA=By.xpath("//input[@id='value-a']");
	By twoInputFieldValueB=By.xpath("//input[@id='value-b']");
	By twoInputFieldButton=By.xpath("//button[@id='button-two']");
	By TwoInputFieldMsg=By.xpath("//div[@id='message-two']");
	
	public void verifyEnterMsgField() {
		String actualMsg,inputMsg="Hello";
		String expectedMsg="Your Message : "+inputMsg;
		driver.findElement(inputField).sendKeys("Hello");
		driver.findElement(showMsgButton).click();
		actualMsg=driver.findElement(msgField).getText();
		Assert.assertEquals(expectedMsg,actualMsg,"Message are not equal");
		
		
	}
	public void verifyEnterMsgFieldWithoutMsg() {
		String actualMsg;
		String expectedMsg="Your Message : ";
		driver.findElement(showMsgButton).click();
		actualMsg=driver.findElement(msgField).getText();
		Assert.assertEquals(expectedMsg,actualMsg,"Message not display");
	}
	public void twoInputField() {
		int Num1=12,Num2=22,Sum =Num1+Num2;
		String expectedSum,actualSum;
		String a=Integer.toString(Num1);
		String b=Integer.toString(Num2);
		String Total=Integer.toString(Sum);
		expectedSum="Total A + B : "+Sum;
		driver.findElement(twoInputFieldValueA).sendKeys(a);
		driver.findElement(twoInputFieldValueB).sendKeys(b);
		driver.findElement(twoInputFieldButton).click();
		actualSum=driver.findElement(TwoInputFieldMsg).getText();
		Assert.assertEquals(expectedSum, actualSum,"Sum are not equal");
	}

}
