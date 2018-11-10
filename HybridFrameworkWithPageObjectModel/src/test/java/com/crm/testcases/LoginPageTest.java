package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.Base;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class LoginPageTest extends Base{
	
	LoginPage loginPage;
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage=new LoginPage();
	}
	
	@Test()
	public void loginPageTitle()
	{
		String title=loginPage.validateLoginpageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test()
	public void crmLogoTest()
	{
		boolean flag=loginPage.validateCRMImane();
		Assert.assertTrue(flag);
	}
	
	@Test()
	public void loginTest() throws InterruptedException
	{
		HomePage homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
