package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.base.Base;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.pages.NewContactPage;
import com.crm.utils.Utils;

public class ContactPageTest extends Base{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	NewContactPage newContactPage;
	String sheetName="Contacts";
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactPage=new ContactsPage();
		newContactPage=new NewContactPage();
	}
	
	@Test
	public void varifyContactLevelTest()
	{
		homePage.clickOnContacts();
		Assert.assertTrue(contactPage.varifyContactLevel(),"Contacts level is not displayed");
	}
	
	@Test
	public void selectContactTest()
	{
		homePage.clickOnContacts();
		contactPage.selectContact("Test1 Test2");
	}
	
	@DataProvider
	public Object[][] getContactsData()
	{
		Object[][] data=Utils.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getContactsData")
	public void createNewContact(String title,String firstName,String lastName,String company)
	{
		homePage.clickOnNewContact();
		newContactPage.createNewContact(title, firstName, lastName, company);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
