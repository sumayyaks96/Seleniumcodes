package com.obsquara.TestNGSample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectSample extends Base{
	@Test
	public void selectByVisibleTest() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select objSelect=new Select(driver.findElement(By.xpath("//select[@id='single-input-field']")));
		objSelect.selectByVisibleText("Red");
		objSelect.selectByVisibleText("Yellow");
		objSelect.selectByVisibleText("Green");
	}
	@Test
	public void selectByIndexSample() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select objSelect=new Select(driver.findElement(By.xpath("//select[@id='single-input-field']")));
		objSelect.selectByIndex(1);
		objSelect.selectByIndex(2);
		objSelect.selectByIndex(3);
	}
	@Test
	public void selectByValueSample() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select objSelect=new Select(driver.findElement(By.xpath("//select[@id='single-input-field']")));
		objSelect.selectByValue("Red");
		objSelect.selectByValue("Yellow");
		objSelect.selectByValue("Green");
	}
	@Test
	public void alloptionsSample() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select objSelect=new Select(driver.findElement(By.xpath("//select[@id='single-input-field']")));
		List<WebElement> allOptions=objSelect.getOptions();
		int count=allOptions.size();
	}
	@Test
	public void twoInputField() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select objSelect1=new Select(driver.findElement(By.xpath("//select[@id='multi-select-field']")));
		boolean isMultipleFlag=objSelect1.isMultiple();
		Assert.assertTrue(isMultipleFlag,"Multiple selection is not possible");
		objSelect1.selectByVisibleText("Red");
		objSelect1.selectByVisibleText("Yellow");
		objSelect1.deselectAll();	
	}
	@Test
	public void onecolourSelect() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		String expectedColor="Selected Color : Red",actualColor;
		WebElement MsgField=driver.findElement(By.xpath("//div[@id='message-one']"));
		Select objSelect=new Select(driver.findElement(By.xpath("//select[@id='single-input-field']")));
		objSelect.selectByVisibleText("Red");
		actualColor=MsgField.getText();
		Assert.assertEquals(expectedColor, actualColor,"one color select is not possible");
	}
	@Test
	public void alloptionsSelectSample() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		String expectedMsg="All selected colors are : Green,Red,Yellow",ActualMsg;
		Select objSelect1=new Select(driver.findElement(By.xpath("//select[@id='multi-select-field']")));
		WebElement getAllSelectedButton=driver.findElement(By.xpath("//button[@id='button-all']"));
		WebElement msgField=driver.findElement(By.xpath("//div[@id='message-two']"));
		boolean isMultipleFlag=objSelect1.isMultiple();//check is multiple selection is possible
		Assert.assertTrue(isMultipleFlag,"Multiple selection is not possible");
		objSelect1.selectByVisibleText("Red");
		objSelect1.selectByVisibleText("Yellow");
		objSelect1.selectByVisibleText("Green");
		getAllSelectedButton.click();
		ActualMsg=msgField.getText();
		Assert.assertEquals(expectedMsg, ActualMsg,"No selected color shown");
	}
	@Test
	public void allOptionsDeselectsample() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		String expectedMsg="All selected colors are : ",ActualMsg ;
		Select objSelect1=new Select(driver.findElement(By.xpath("//select[@id='multi-select-field']")));
		WebElement getAllSelectedButton=driver.findElement(By.xpath("//button[@id='button-all']"));
		WebElement msgField=driver.findElement(By.xpath("//div[@id='message-two']"));
		boolean isMultipleFlag=objSelect1.isMultiple();
		Assert.assertTrue(isMultipleFlag,"Multiple selection is not possible");
		objSelect1.selectByVisibleText("Red");
		objSelect1.selectByVisibleText("Yellow");
		objSelect1.selectByVisibleText("Green");
		objSelect1.deselectAll();
		ActualMsg=msgField.getText();
		Assert.assertEquals(expectedMsg, ActualMsg,"deselection is not possible");
		
	}
}
