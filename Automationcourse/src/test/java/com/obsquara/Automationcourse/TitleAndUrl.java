package com.obsquara.Automationcourse;

import junit.framework.Assert;

public class TitleAndUrl extends GeoceryStore{
	public void browserTitle() {
		String expectedTitle="Geocerystore";
		String title=driver.getTitle();
		Assert.assertEquals(expectedTitle,title);
	}
	public void browserUrl() {
		String url=driver.getCurrentUrl();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TitleAndUrl obj=new TitleAndUrl();
		obj.initializeBrowser();
		obj.browserTitle();
		obj.browserUrl();
		obj.browserClose();
	}

}
