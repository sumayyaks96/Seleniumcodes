package com.obsquara.TestNGSample;

import org.testng.annotations.*;

public class AnnotationSample {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
	@BeforeClass
	public void beforeClaas() {
		System.out.println("Before Class");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}
	@Test
	public void test() {
		System.out.println("Test");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}
}
