package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.Base;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class ContactPageTest extends Base{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactPage=new ContactsPage();
		homePage.clickOnContacts();
	}
	
	@Test
	public void varifyContactLevelTest()
	{
		Assert.assertTrue(contactPage.varifyContactLevel(),"Contacts level is not displayed");
	}
	
	@Test
	public void selectContacTest()
	{
		contactPage.selectContact("Test1 Test2");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
