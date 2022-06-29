package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	WebElement createLink;
	
	@FindBy(xpath = "//input[@name='first_name']")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath = "//div[@name='category' and @role='listbox']")
	WebElement category;
	
	@FindBy(xpath = "//div[@name='category' and @role='listbox']//div[2]//div[2]//span[contains(text(),'Lead')]")
	WebElement drpdwn;
	
//	@FindBy(xpath = "(//div[contains(text(),'Select')])[4]")
//	WebElement sourceName;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveButton;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/div[3]/a[1]/i[1]")
	WebElement contactsIcon1;
	
	// Initializing the page objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifycontactslabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void clickCreateLink() {
		createLink.click();
	}
	
	public void createNewContact(String fn, String ln) {
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		category.click();
		drpdwn.click();
		saveButton.click();
		contactsIcon1.click();
	}
	
}
