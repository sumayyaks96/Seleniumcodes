package com.obsquara.Automationcourse;

public class NavigateCommand extends GeoceryStore{
	public void navigate() {
		driver.navigate().to("https://www.toolsqa.com/automation-practice-form/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NavigateCommand obj=new NavigateCommand();
		obj.initializeBrowser();
		obj.navigate();
		obj.browserClose();
	}

}
