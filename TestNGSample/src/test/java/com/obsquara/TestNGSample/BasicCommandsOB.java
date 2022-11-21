package com.obsquara.TestNGSample;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicCommandsOB extends Base{
	@Test
	public void singleInputVerification() {
		String actualMsg,inputMsg="Hello";
		String expectedMsg="Your Message : "+inputMsg;
		driver.findElement(By.xpath("//input[@id='single-input-field']")).sendKeys("Hello");
		driver.findElement(By.xpath("//button[@id='button-one']")).click();
		actualMsg=driver.findElement(By.xpath("//div[@id='message-one']")).getText();
		Assert.assertEquals(expectedMsg,actualMsg,"Message are not equal");
	}
	@Test
	public void twoInputField() {
		int Num1=12,Num2=22,Sum =Num1+Num2;
		String expectedSum,actualSum;
		String a=Integer.toString(Num1);
		String b=Integer.toString(Num2);
		String Total=Integer.toString(Sum);
		expectedSum="Total A + B : "+Sum;
		driver.findElement(By.xpath("//input[@id='value-a']")).sendKeys(a);
		driver.findElement(By.xpath("//input[@id='value-b']")).sendKeys(b);
		driver.findElement(By.xpath("//button[@id='button-two']")).click();
		actualSum=driver.findElement(By.xpath("//div[@id='message-two']")).getText();
	}

}
