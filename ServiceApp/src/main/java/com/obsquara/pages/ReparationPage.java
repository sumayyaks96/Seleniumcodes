package com.obsquara.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.obsquara.utilities.PageUtility;

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
	
	@FindBy(xpath="(//input[@class='form-control input-sm input-xs'])[1]")
	private WebElement search;
	
	
	


	public void completedrepairCount() {
		PageUtility.clickOnElement(MoreInfoField);
		PageUtility.clickOnElement(completedRepair);
		Select objSelect=new Select(driver.findElement(By.xpath("//select[@class='form-control input-sm select input-xs'])[2]")));
		List<WebElement>option=objSelect.getOptions();
		for(WebElement Inputmenu:option) {
			String show=Inputmenu.getText();
			if(show.contains("All")) {
				Inputmenu.click();
				break;
			}
			
		}
		boolean rows=rowcount.isEmpty();
		List<WebElement>NumberOfRows=rowcount;
    	for(WebElement row:NumberOfRows) {
    		int count=NumberOfRows.size();
    		break;
    		}
    	Assert.assertTrue(rows, "row count is empty");
    	}
	public void pendingrepairCount() {
		PageUtility.clickOnElement(MoreInfoField);
		PageUtility.clickOnElement(pendingRepair);
		Select objSelect=new Select(driver.findElement(By.xpath("(//select[@class='form-control input-sm select input-xs'])[1]")));
		List<WebElement>option=objSelect.getOptions();
		for(WebElement Inputmenu:option) {
			String show=Inputmenu.getText();
			if(show.contains("All")) {
				Inputmenu.click();
				break;
			}
			
		}
		boolean rows=rowcount.isEmpty();
		List<WebElement>NumberOfRows=rowcount;
    	for(WebElement row:NumberOfRows) {
    		int count=NumberOfRows.size();
    		break;
    		}
    	Assert.assertTrue(rows, "row count is empty");
    	}
	public void searchField() {
		String searchMsg = null;
		PageUtility.clickOnElement(MoreInfoField);
		PageUtility.enterText(search,searchMsg);
	}
		
	
	}




