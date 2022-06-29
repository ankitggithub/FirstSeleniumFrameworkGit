package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Factory -- OR:
	@FindBy(xpath="//span[contains(text(),'Ankit Gupta')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/div[3]/a[1]/i[1]")
	WebElement contactsIcon;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/div[5]/a[1]/i[1]")
	WebElement dealsLink;
	
	//Initializing the page objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validatehomePageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean verifyCorrectUserName() {
		return usernameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsIcon.click();
		return new ContactsPage();
		
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
		
	}
}
