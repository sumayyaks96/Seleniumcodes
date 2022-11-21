package com.obsquara.TestNGSample;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Locators extends Base{
	@Test
	public void idLocator() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.id("glow-ingress-line2")).click();;
		//driver.findElement(By.id(null))
	}
	@Test
	public void classLocator() {
		driver.findElement(By.className("nav-logo-linknav-progressive-attribute"));
	}
	@Test
	public void nameLocator() {
		driver.findElement(By.name("glow-validation-token"));
		
	}
	@Test
	public void cssselector() {
		driver.findElement(By.cssSelector("input#twotabsearchtextbox"));//id&tag
		driver.findElement(By.cssSelector("span.hm-icon-label"));//cls& tag
	}
	@Test
	public void cssSelectorTagAttribute() {
		driver.findElement(By.cssSelector("input[id=twotabsearchtextbox]"));
		
	}
	@Test
	public void xpathLocator() {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		
	}
	@Test
	public void xpathAdvantageSample() {
		driver.findElement(By.xpath("(//div[@class='nav-fill'])[2]"));
	}
	@Test
	public void xpathHomeWork() {
		driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));//logo
		driver.findElement(By.xpath("//span[@id='glow-ingress-line1']"));//deliver to india
		driver.findElement(By.xpath("//span[@class='hm-icon-label']"));//All
		driver.findElement(By.xpath("//span[@id='nav-cart-count']"));//cart
		driver.findElement(By.xpath("(//span[@class='nav-line-2'])[2]"));//returns and order
		driver.findElement(By.xpath("(//a[@class='nav-a  '])[1]"));//todays deal
		driver.findElement(By.xpath("(//a[@class='nav-a  '])[2]"));//customer service
		driver.findElement(By.xpath("(//a[@class='nav-a  '])[3]"));//Registry
		driver.findElement(By.xpath("(//a[@class='nav-a  '])[4]"));//Giftcard
		driver.findElement(By.xpath("(//a[@class='nav-a  '])[5]"));//sell
		}
	
	
}
