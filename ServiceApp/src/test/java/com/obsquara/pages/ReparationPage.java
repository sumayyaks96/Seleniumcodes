package com.obsquara.pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.obsquara.utilities.ExcelUtility;
import com.obsquara.utilities.PageUtility;
import com.obsquara.utilities.WaitUtility;

public class ReparationPage {
	public WebDriver driver;
	public ReparationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/reparation']")
	private WebElement MoreInfoField;
	
	@FindBy(xpath="//a[@href='#CompletedRepairs']")
	private WebElement completedRepair;
	
	@FindBy(xpath="//tr[@class='warranty_row even' or @class='warranty_row odd']")
	private List<WebElement> rowcount;
	
	@FindBy(xpath="//a[@href=#PendingRepairs']")
	private WebElement pendingRepair;
	
	@FindBy(xpath="//tr[@class='invoice_link']")
	private WebElement pendingRepairRowcount;
	
	@FindBy(xpath="//div[@id='dynamic-table_info']")
	private WebElement pendingRepairMsg;
	
	@FindBy(xpath="//div[@id='dynamic-table-completed_info']")
	private WebElement completedrepairmsg;
	
	
	@FindBy(xpath="(//input[@class='form-control input-sm input-xs'])[1]")
	private WebElement search;
	
	@FindBy(xpath="//tr[@class='invoice_link']")
	private List<WebElement> rowName;
	
	@FindBy(xpath="(//a[text()='Next > '])[1]")
	private WebElement nextbutton;
	
	@FindBy(xpath="(//a[text()=' < Previous'])[1]")
	private WebElement previousbutton;
	
	@FindBy(xpath="(//select[@class='form-control input-sm select input-xs'])[2]")
	private WebElement showdropdowninCompletedrepair;
	
	@FindBy(xpath="(//select[@class='form-control input-sm select input-xs'])[1]")
	private WebElement showdropdowninPendingrepair;
	
	@FindBy(xpath="(//div[@class='dataTables_info'])[1]")
	private WebElement searchbuttonmsg;
	
	
	
	public void completedrepairCount() throws IOException {
		String expectedmsg =ExcelUtility.getString(0, 1, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Reparation");
		String actualmsg;
		WaitUtility.waitForElementClickable(driver, MoreInfoField);
		PageUtility.clickOnElement(MoreInfoField);
		WaitUtility.waitForElement(driver,completedRepair );
		PageUtility.clickOnElement(completedRepair);
		Select objSelect=new Select(showdropdowninCompletedrepair);
		List<WebElement>option=objSelect.getOptions();
		for(WebElement Inputmenu:option) {
			String show=Inputmenu.getText();
			if(show.contains("All")) {
				Inputmenu.click();
				break;
			}
		}
		actualmsg=completedrepairmsg.getText();
		Assert.assertEquals(expectedmsg, actualmsg,"pending repair count not diplayed");
		
		}
	public void pendingrepairCount() throws IOException {
		String expectedmsg =ExcelUtility.getString(0, 2, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Reparation");
		String actualmsg;
		WaitUtility.waitForElement(driver,MoreInfoField );
		PageUtility.clickOnElement(MoreInfoField);
		Select objSelect=new Select(showdropdowninPendingrepair);
		List<WebElement>option=objSelect.getOptions();
		for(WebElement Inputmenu:option) {
			String show=Inputmenu.getText();
			if(show.contains("All")) {
				Inputmenu.click();
				break;
				}
			}
		actualmsg=pendingRepairMsg.getText();
		Assert.assertEquals(expectedmsg, actualmsg,"pending repair count not diplayed");
		
    	}
	public void searchField() throws IOException, InterruptedException {
		String ExpectedMsg =ExcelUtility.getString(1, 2, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Reparation");
		String actualMsg;
		String searchMsg =ExcelUtility.getString(0, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Reparation");
		WaitUtility.waitForElementClickable(driver, MoreInfoField);
		PageUtility.clickOnElement(MoreInfoField);
		boolean searchDisplayed=search.isDisplayed();
		Assert.assertTrue(searchDisplayed,"search is not displayed");
		PageUtility.enterText(search,searchMsg);
		List<WebElement>NumberOfRows=rowName;
    	for(WebElement row:NumberOfRows) {
    		int count=NumberOfRows.size();
    			break;
    		}
    	actualMsg=searchbuttonmsg.getText();
		Assert.assertEquals(ExpectedMsg, actualMsg,"search not possible");
		}
	public void nextButtonVerificationInPendingRepair() throws IOException {
		String ExpectedMsg =ExcelUtility.getString(1, 1, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Reparation");
		String actualMsg;
		WaitUtility.waitForElementClickable(driver, MoreInfoField);
		PageUtility.clickOnElement(MoreInfoField);
		WaitUtility.waitForElement(driver,nextbutton );
		PageUtility.clickOnElement(nextbutton);
		actualMsg=pendingRepairMsg.getText();
		Assert.assertEquals(ExpectedMsg, actualMsg,"next button not working");
	}
	public void previousButtonVerificationInPendingRepair() throws IOException {
		String ExpectedMsg =ExcelUtility.getString(2, 1, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Reparation");
		String actualMsg;
		WaitUtility.waitForElementClickable(driver, MoreInfoField);
		PageUtility.clickOnElement(MoreInfoField);
		WaitUtility.waitForElement(driver,previousbutton );
		PageUtility.clickOnElement(previousbutton);
		actualMsg=pendingRepairMsg.getText();
		Assert.assertEquals(ExpectedMsg, actualMsg,"next button not working");
	}
	public void getTitleReperationPageVerification() throws IOException{
		String expectedTitle =ExcelUtility.getString(2, 2, System.getProperty("user.dir") + System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Reparation");
		String actualTitle;
		WaitUtility.waitForElementClickable(driver, MoreInfoField);
		PageUtility.clickOnElement(MoreInfoField);
		actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle,"Title didn't get ReperationPage ");
	    }
}




