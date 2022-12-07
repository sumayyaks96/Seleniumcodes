package com.obsquara.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SelectInputPage {
	WebDriver driver;
	Select objSelect;
	By SelectField=By.xpath("//select[@id='single-input-field']");
	By msgField=By.xpath("//div[@id='message-one']");
	public SelectInputPage(WebDriver driver) {
		this.driver=driver;
	}
	public void selectInputDemoField() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		String expectedMsg="Selected Color : Red",actualMsg;
	    objSelect=new Select((driver.findElement(SelectField)));
		objSelect.selectByVisibleText("Red");
		actualMsg=driver.findElement(msgField).getText();
		Assert.assertEquals(expectedMsg, actualMsg,"Message not displayed");
	}

}
