package com.obsquara.testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsquara.pages.ClientPage;
import com.obsquara.serviceapp.Base;

public class ClientTest extends Base{
	ClientPage obj;
	@Test
	public void verifyAddClientField() throws IOException {
		obj=new ClientPage(driver);
		obj.addClient();
	}
	@Test
	public void verifyChangeColumnField() throws IOException {
		obj=new ClientPage(driver);
		obj.changeColumn();;
	}
	@Test
	public void verifyshowButtonField() throws IOException {
		obj=new ClientPage(driver);
		obj.showButton();;
	}

}
