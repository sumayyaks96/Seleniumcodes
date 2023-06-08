package com.obsquara.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.obsquara.utilities.ExcelUtility;
import com.obsquara.utilities.PageUtility;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//span[@class='hidden-xs'])[1]")
	private WebElement UserField;
	
	@FindBy(xpath="//a[@class='btn btn-default btn-flat']")
	private WebElement logoutButton;
	
	@FindBy(xpath="//div[@id='infoMessage']")
	private WebElement logoutMsg;
	
	@FindBy(xpath="(//h3[@class='box-title'])[3]")
	private WebElement quickemailField;
	
	@FindBy(xpath="(//h3[@class='box-title'])[4]")
	private WebElement quickSmsField;
	
	@FindBy(xpath="(//button[@class='btn btn-info btn-sm'])[1]")
	private WebElement closeButtonRevenue;
	
	@FindBy(xpath="(//h3[@class='box-title'])[1]")
	private WebElement RevenueChartTitle;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/inventory']")
	private WebElement inventoryProductMoreInfoOption;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/customers']")
	private WebElement ClientMoreInfoOption;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/reparation']")
	private WebElement ReperationMoreInfoOption;
	
	public void logoutVerification() throws IOException {
		String expectedMsg =ExcelUtility.getString(0, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE,"Home");
		String actualMsg;
		PageUtility.clickOnElement(UserField);
		boolean logout=logoutButton.isEnabled();
		Assert.assertTrue(logout,"logout Button is not enabled");
		PageUtility.clickOnElement(logoutButton);
		actualMsg=logoutMsg.getText();
		Assert.assertEquals(expectedMsg, actualMsg,"Logout Failed");	
	}
	public void navigateToClientPageVerification() throws IOException {
		String expectedUrl =ExcelUtility.getString(1, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE,"Home");
		String actualUrl;
		 PageUtility.clickOnElement(ClientMoreInfoOption);
		 actualUrl = driver.getCurrentUrl();
		 Assert.assertEquals(expectedUrl, actualUrl,"Navigation didn't occur to ClientPage ");
	    }
	public void QuickSmsFieldIsBelowQuickEmail() {
		PageUtility.ScrollBy(driver);
		Point SMSField=quickSmsField.getLocation();
		int x=SMSField.getX();
		int y=SMSField.getY();
		Point EmailField=quickemailField.getLocation();
		int xAxis=EmailField.getX();
		int yAxis=EmailField.getY();
		if(y<yAxis) {
			Assert.assertEquals(y, yAxis,"SMSField place under EmailField");
		}	
	}
	public void navigateToReperationPageVerification() throws IOException {
		String expectedUrl =ExcelUtility.getString(2, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE,"Home");
		String actualUrl;
		 PageUtility.clickOnElement(ReperationMoreInfoOption);
		 actualUrl = driver.getCurrentUrl();
		 Assert.assertEquals(expectedUrl, actualUrl,"Navigation didn't occur to Reperation Page ");
	    }
	public void checkCloseButtonInRevenueChart() throws IOException {
		String expectedMsg =ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE,"Home");
		String actualMsg;
		boolean closeButton=closeButtonRevenue.isDisplayed();
		Assert.assertTrue(closeButton,"close Button not displayed");
		PageUtility.clickOnElement(closeButtonRevenue);
		actualMsg=RevenueChartTitle.getText();
		Assert.assertNotEquals(actualMsg, expectedMsg,"close button not working");
		}
	public void navigateToInventoryPageVerification() throws IOException {
		String expectedUrl =ExcelUtility.getString(0, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE,"Home");
		String actualUrl;
		 PageUtility.clickOnElement(inventoryProductMoreInfoOption);
		 actualUrl = driver.getCurrentUrl();
		 Assert.assertEquals(expectedUrl, actualUrl,"Navigation didn't occur to InventoryPage ");
	    }

}
