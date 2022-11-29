package com.obsquara.TestNGSample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
	@Test
	public void clearSample(){
	WebElement enterMessageField=driver.findElement(By.xpath("//input[@id='single-input-field']"));
	enterMessageField.sendKeys("Hello");
	enterMessageField.clear();
	WebElement showMessage=driver.findElement(By.xpath("//button[@id='button-one']"));
	showMessage.isEnabled();
	showMessage.isDisplayed();
	showMessage.isSelected();
	
	}
	@Test
	public void testCaseSample() {
		String inputMsg="Hello",actualMsg = null;
		String expectedMsg="Your Message : "+inputMsg;
		WebElement messageField=driver.findElement(By.xpath("//input[@id='single-input-field']"));
		WebElement buttonField=driver.findElement(By.xpath("//button[@id='button-one']"));
		WebElement yourMsg=driver.findElement(By.xpath("//div[@id='message-one']"));
		boolean isMsgFieldDisplayed=messageField.isDisplayed();
		boolean isButtonDisplayed=buttonField.isDisplayed();
		if(isMsgFieldDisplayed && isButtonDisplayed) {
			messageField.sendKeys("Hello");
			boolean isButtonenabled=buttonField.isEnabled();
			if(isButtonenabled) {
				buttonField.click();
				actualMsg=yourMsg.getText();
				Assert.assertEquals(expectedMsg,actualMsg,"Messages are not equal" );
			}
			Assert.assertTrue(isButtonenabled, "Button is not Enabled");
		}
		Assert.assertTrue(isMsgFieldDisplayed, "message field is not Displayed");
		Assert.assertTrue(isButtonDisplayed, "Button not Displayed");
	}
	@Test
	public void getAttributeSample() {
		String className=driver.findElement(By.xpath("//button[@id='button-one']")).getAttribute("class");
		String tagName=driver.findElement(By.xpath("//button[@id='button-one']")).getTagName();
		String backGroundColor=driver.findElement(By.xpath("//button[@id='button-one']")).getCssValue("background-color");
		String fontColor=driver.findElement(By.xpath("//button[@id='button-one']")).getCssValue("color");
		String borderRadius=driver.findElement(By.xpath("//button[@id='button-one']")).getCssValue("border-radius");
		Dimension buttonSize=driver.findElement(By.xpath("//button[@id='button-one']")).getSize();
		int buttonHeight=buttonSize.getHeight();
	}
	@Test
	public void getTotalButtonCssValue() {
		String expectedFondColor="rgba(255,255,255,1)",expectedBackGroundColor="rgba(0,123,255,1)",expectedFontWeight="400";
		// expectedButtonSize=1;
		WebElement buttonField=driver.findElement(By.xpath("//button[@id='button-two']"));
		String actualFontColor=buttonField.getCssValue("color");
		SoftAssert softassert=new SoftAssert();
		softassert.assertEquals(expectedFondColor, actualFontColor,"Colors are not equal");
		Dimension actualButtonSize=buttonField.getSize();
		String actualBackGroundColor=buttonField.getCssValue("background-color");
		softassert.assertEquals(expectedBackGroundColor, actualBackGroundColor,"Background colors are not equals");
		String actualFontWeight=buttonField.getCssValue("font-weight");
		softassert.assertEquals(expectedFondColor, actualFontColor,"font-weight are not equal");
		softassert.assertAll();
	}
	@Test
	public void getLocation() {
		Point showMessage=driver.findElement(By.xpath("//button[@id='button-one']")).getLocation();
		int x=showMessage.getX();
		int y=showMessage.getY();
		Point enterMsgField=driver.findElement(By.xpath("//input[@id='single-input-field']")).getLocation();
		int xAxis=enterMsgField.getX();
		int yAxis=enterMsgField.getY();
		if(yAxis<y) {
			Assert.assertEquals(y, yAxis,"Show Message button place under enter message field");
		}
		
	}
	@Test
	public void findElementsSample() {
		List<WebElement>menuList=driver.findElements(By.xpath("//ul[@class='list-group list-group-flush']//li"));
		for(WebElement inputMenu:menuList) {
				String text=inputMenu.getText();
				if(text.contentEquals("Radio Buttons Demo")) {
					inputMenu.click();
					break;
				}
				
			}
			
		
	}
	@Test
	public void findElementsNavBar() {
		List<WebElement>menuOption=driver.findElements(By.xpath("//ul[@class='navbar-nav']//li"));
		for(WebElement menu:menuOption) {
				String text=menu.getText();
				if(text.contentEquals("Date Pickers")) {
					menu.click();
					break;
				}
				
			}
			
		}
	
		
@Test
public void checkRadioButton() {
	
	WebElement male=driver.findElement(By.xpath("(//label[@class='form-check-label'])[1]"));
	male.click();
	if(male.isSelected()) {
		WebElement selectedValue=driver.findElement(By.xpath(""));
		selectedValue.click();
		 
		
	}
		
}
	
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
public void isSelecetedMaleField() {
	driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
	WebElement maleButton=driver.findElement(By.xpath("(//label[@class='form-check-label'])[1]"));
	//WebElement female=driver.findElement(By.xpath("(//div[@class='form-check form-check-inline'])[2]"));
	WebElement showSelectedValueButton=driver.findElement(By.xpath("//button[@id='button-one']"));
	maleButton.click();
	boolean maleFieldSelected=maleButton.isSelected();
	//boolean femaleFieldSelected=female.isSelected();
	if(maleFieldSelected) {
		showSelectedValueButton.click();
		Assert.assertEquals(maleButton, "Radio button 'Male' is checked");
	}
	Assert.assertEquals(maleButton,"Radio button is Not checked");
}
@Test
public void isSelectedFemaleField() {
	driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
	WebElement male=driver.findElement(By.xpath("(//div[@class='form-check form-check-inline'])[1]"));
	WebElement female=driver.findElement(By.xpath("(//div[@class='form-check form-check-inline'])[2]"));
	WebElement showSelectedValueButton=driver.findElement(By.xpath("//button[@id='button-one']"));
	boolean maleFieldSelected=male.isSelected();
	boolean femaleFieldSelected=female.isSelected();
	female.click();
	if(femaleFieldSelected) {
		showSelectedValueButton.click();
		Assert.assertEquals(femaleFieldSelected, "Radio button 'Female' is checked");
	}
	Assert.assertEquals(maleFieldSelected, femaleFieldSelected,"Radio button is Not checked");
}
}
	
