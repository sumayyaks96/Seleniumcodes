package com.obsquara.TestNGSample;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestScript extends Base {
	@Test
	public void verifyUrl() {
	String expectedUrl="https://www.amazon.com/";
	String ActualUrl=driver.getCurrentUrl();
	Assert.assertEquals(expectedUrl,ActualUrl);
	}
	@Test
	public void verifyTitle()
	{
		String expectedTitle="Amazon.com. Spend less. Smile more.";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);	
	}
	@Test
	public void softAssertSample() {
		SoftAssert softassert=new SoftAssert();
		String expectedTitle="Amazon.com. Spend less. Smile more.";
		String actualTitle=driver.getTitle();
		softassert.assertEquals(expectedTitle, actualTitle);
		String expectedUrl="https://www.amazon.com/";
		String ActualUrl=driver.getCurrentUrl();
		softassert.assertEquals(expectedUrl,ActualUrl);
		softassert.assertAll();
	}
	@Test
	public void hardAssertSample() {
		String expectedTitle="Amazon.com. Spend less. Smile more.";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		String expectedUrl="https://www.amazon.com/";
		String ActualUrl=driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl,ActualUrl);
	}

}
