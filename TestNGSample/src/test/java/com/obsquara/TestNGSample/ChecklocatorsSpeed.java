package com.obsquara.TestNGSample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ChecklocatorsSpeed extends Base {
	@Test
	public void checkLocatorId() {
		driver.findElement(By.id("twotabsearchtextbox"));
	}
	@Test
	public void checkLocatorClass() {
		driver.findElement(By.className("nav-input,nav-progressive-attribute"));
	}
	/*@Test
	public void checkLocatorName() {
		driver.findElement(By.name(""));
	}*/
	@Test
	public void checkLocatorCssSelector() {
		driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
	}
	@Test
	public void checkLocatorXpath() {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	}


}
