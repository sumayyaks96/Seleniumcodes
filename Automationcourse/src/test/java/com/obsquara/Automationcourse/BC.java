package com.obsquara.Automationcourse;

import junit.framework.Assert;

public class BC extends Base {
	
		
		public void browserCommand() {
			String expectedTitle="Amazon.com. Spend less. Smile more.";
			
			String title=driver.getTitle();//get title
			/*if(expectedTitle.equals(title))//compare titles
			{
				System.out.println("Titles are equal");
			}
			else
			{
				System.out.println("Titles are not equal");
			}*/
			Assert.assertEquals(expectedTitle,title);
			
			
		}
		
		public void getUrl() {
		
			String url=driver.getCurrentUrl();
			
		}
		public void getPageSource() {
			String pageSource=driver.getPageSource();
			
		}
		public void navigate() {
			driver.navigate().to("https://www.amazon.com/s?k=gaming+headsets&pd_rd_r=3a1f1981-f012-4249-a680-011876c15d58&pd_rd_w=1RgfN&pd_rd_wg=h6u5Y&pf_rd_p=12129333-2117-4490-9c17-6d31baf0582a&pf_rd_r=F55NVZQAPYPHB3X882GS&ref=pd_gw_unk");
			driver.navigate().back();//back page 
			driver.navigate().forward();//forward page
			driver.navigate().refresh();//refresh the page
		}
	       
		public static void main(String args[]) {
			BC obj=new BC();
			obj.initializeBrowser();
			obj.navigate();
		}

}

