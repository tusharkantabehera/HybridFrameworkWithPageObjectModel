package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.base.Base;

public class NewContactPage extends Base{
	
	public NewContactPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="title")
	WebElement titleDropdown;
	
	@FindBy(id="first_name")
	WebElement firstNameInput;
	
	@FindBy(id="surname")
	WebElement lastNameInput;
	
	@FindBy(name="client_lookup")
	WebElement companyInput;
	
	@FindBy(xpath="//input[@value='Load From Company']/following-sibling::input[1]")
	WebElement submitButton;
	
	public void createNewContact(String title,String firstName,String LastName,String cmpName)
	{
		Select select=new Select(titleDropdown);
		select.selectByValue(title);
		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(LastName);
		companyInput.sendKeys(cmpName);
		submitButton.click();
	}
}
