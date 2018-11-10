package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.Base;
import com.crm.utils.Utils;

public class HomePage extends Base{

	@FindBy(xpath="//td[contains(text(),'Tushar')]")
	WebElement usernameLevel;
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement contactLink;
	
	@FindBy(xpath="//a[text()='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[text()='Tasks']")
	WebElement tasksLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);	
	}
	
	public String varifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean varifyUsername()
	{
		Utils.switchToFrame("mainpanel");
		return usernameLevel.isDisplayed();
	}
	
	public ContactsPage clickOnContacts()
	{
		Utils.switchToFrame("mainpanel");
		contactLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDeals()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasks()
	{
		tasksLink.click();
		return new TasksPage();
	}
}
