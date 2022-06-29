package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase {

	@FindBy(xpath = "//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
	WebElement dealsLabel;

	// Initializing the page objects:
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifydealslabel() {
		return dealsLabel.isDisplayed();
	}
}
