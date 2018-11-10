package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.Base;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utils.Utils;

public class HomePageTest extends Base{

	LoginPage loginPage;
	HomePage homePage;
	Utils utils;
		
	//Test-cases should be separate and independent
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		utils=new Utils();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test()
	public void varifyHomepageTest()
	{
		String homepageTitle=homePage.varifyHomePageTitle();
		Assert.assertEquals(homepageTitle, "CRMPRO","Homapage title is not matched");
	}
	
	@Test()
	public void varifyUsernameTest()
	{
		Assert.assertTrue(homePage.varifyUsername());
	}
	
	@Test
	public void varifyContactsLinkTest()
	{
		homePage.clickOnContacts();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
