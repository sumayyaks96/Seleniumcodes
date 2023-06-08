package com.obsquara.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.obsquara.utilities.ExcelUtility;
import com.obsquara.utilities.PageUtility;
import com.obsquara.utilities.WaitUtility;

public class InventoryPage {
	public WebDriver driver; 
	public InventoryPage(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/inventory']")
	private WebElement moreInfoButton;
	
	@FindBy(xpath="//tr[@class='product_link']")
	private List<WebElement> rowcount;
	
	@FindBy(xpath="//input[@class='form-control input-sm input-xs']")
	private WebElement search;
	
	@FindBy(xpath="//div[@id='PRData_info']")
	private WebElement msg;
	
	@FindBy(xpath="//i[@class='icon fa fa-tasks tip']")
	private WebElement actionbutton;
	
	@FindBy(xpath="//ul[@class='dropdown-menu pull-right tasks-menus']//li[1]")
	private WebElement addproductButton;
	
	@FindBy(xpath="//input[@id='name']")
	private WebElement name;
	
	@FindBy(xpath="//input[@id='code']")
	private WebElement code;
	
	@FindBy(xpath="//span[@class='select2-search select2-search--dropdown']")
	private WebElement catgy;
	
	@FindBy(xpath="//input[@id='quantity']")
	private WebElement totalquantity;
	
	@FindBy(xpath="//span[@class='select2 select2-container select2-container--default select2-container--focus select2-container--below select2-container--open']")
	private WebElement suppliername;
	
	@FindBy(xpath="//input[@id='unit']")
	private WebElement totalunit;
	
	@FindBy(xpath="//input[@id='cost']")
	private WebElement productcost;
	
	@FindBy(xpath="//input[@id='price']")
	private WebElement productprice;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement addproductmsg;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement addproductsubmt;
	
	@FindBy(xpath="//ul[@class='dropdown-menu pull-right tasks-menus']//li[7]")
	private WebElement deleteproductdropdown;
	
	@FindBy(xpath="//button[@id='delete']")
	private WebElement yesAmSureButton ;
	
	@FindBy(xpath="//button[@class='btn bpo-close']")
	private WebElement noButton;
	
	@FindBy(xpath="(//input[@class='checkbox multi-select input-xs'])[1]")
	private WebElement checkboxButton;
	
	@FindBy(xpath="(//button[@class='close'])[1]")
	private WebElement addproductmsgfield ;
	
	@FindBy(xpath="//div[@id='PRData_info']")
	private WebElement searchbuttonmsg ;
	
	@FindBy(xpath="//select[@class='form-control input-sm select input-xs']")
	private WebElement showdropdowninInventory;
	
	public void searchField() throws IOException {
		String ExpectedMsg =ExcelUtility.getString(0, 2, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Inventory");
		String actualMsg;
		String searchMsg =ExcelUtility.getString(1, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Inventory");
		driver.manage().window().maximize();
		WaitUtility.waitForElementClickable(driver, moreInfoButton);
		PageUtility.clickOnElement(moreInfoButton);
		boolean searchDisplayed=search.isDisplayed();
		Assert.assertTrue(searchDisplayed,"search is not displayed");
		PageUtility.enterText(search, searchMsg);
		List<WebElement>NumberOfRows=rowcount;
    	for(WebElement row:NumberOfRows) {
    		int count=NumberOfRows.size();
    		break;
    		}
    	actualMsg=searchbuttonmsg.getText();
		Assert.assertEquals(ExpectedMsg, actualMsg,"search not possible");
		}
	public void totalInventoryCount() throws IOException {
		String expectedMsg =ExcelUtility.getString(0, 1, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Inventory");
		String actualmsg;
		WaitUtility.waitForElementClickable(driver, moreInfoButton);
		PageUtility.clickOnElement(moreInfoButton);
		Select objSelect=new Select(showdropdowninInventory);
		List<WebElement>option=objSelect.getOptions();
		for(WebElement Inputmenu:option) {
			String show=Inputmenu.getText();
			if(show.contains("All")) {
				Inputmenu.click();
				break;
				}
			}
		actualmsg=msg.getText();
		Assert.assertEquals(expectedMsg, actualmsg,"Total inventory product not displayed");
		}
	public void addProduct() throws IOException {
		String expectedMsg =ExcelUtility.getString(0, 1, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Inventory");
		String actualmsg;
		String ProductName =ExcelUtility.getString(2, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Inventory");
		String ProductCode =ExcelUtility.getString(2, 1, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Inventory");
		String category =ExcelUtility.getString(2, 2, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Inventory");
		String Quantity =ExcelUtility.getString(2, 3, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Inventory");
		String Supplier =ExcelUtility.getString(2, 4, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Inventory");
		String Unit =ExcelUtility.getString(2, 5, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Inventory");
		String cost =ExcelUtility.getString(2, 6, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Inventory");
		String price =ExcelUtility.getString(2, 7, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Inventory");
		WaitUtility.waitForElementClickable(driver, moreInfoButton);
		PageUtility.clickOnElement(moreInfoButton);
		PageUtility.clickOnElement(actionbutton);
		PageUtility.clickOnElement(addproductButton);
		PageUtility.enterText(name, ProductName);
		PageUtility.enterText(code, ProductCode);
		PageUtility.enterText(catgy, category);
		PageUtility.enterText(totalquantity, Quantity);
		PageUtility.enterText(suppliername, Supplier);
		PageUtility.enterText(totalunit, Unit);
		PageUtility.enterText(productcost, cost);
		PageUtility.enterText(productprice, price);
		PageUtility.clickOnElement(addproductsubmt);
		actualmsg=addproductmsg.getText();
		Assert.assertEquals(expectedMsg,actualmsg,"cannot add a product");
	}
	public void deleteAProductInPendingRepair() throws IOException {
		String expectedMsg =ExcelUtility.getString(1, 1, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"Inventory");
		String actualmsg;
		WaitUtility.waitForElementClickable(driver, moreInfoButton);
		PageUtility.clickOnElement(moreInfoButton);
		boolean isSelectedClickCheckBox;
		PageUtility.clickOnElement(checkboxButton);
		isSelectedClickCheckBox=checkboxButton.isSelected();
		PageUtility.clickOnElement(actionbutton);
		PageUtility.clickOnElement(deleteproductdropdown);
		PageUtility.clickOnElement(yesAmSureButton);
		driver.switchTo().alert().accept();
		actualmsg=addproductmsgfield.getText();
		Assert.assertEquals(expectedMsg,actualmsg,"Delete Failed" );
				
	}
	public void getTitleInventoryPageVerification() throws IOException, InterruptedException {
		String expectedTitle =ExcelUtility.getString(3, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE,"Inventory");
		String actualTitle;
		WaitUtility.waitForElementClickable(driver, moreInfoButton);
		PageUtility.clickOnElement(moreInfoButton);
		actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle,"Title didn't get InventoryPage ");
	    }
	
}
