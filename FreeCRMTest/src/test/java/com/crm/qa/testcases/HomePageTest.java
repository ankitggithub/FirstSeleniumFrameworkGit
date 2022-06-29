package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		inilization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		dealsPage = new DealsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		String title = homePage.validatehomePageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void usernameLabelTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
				
	}
	
	@Test(priority=3)
	public void contactsLinkTest() {
		contactsPage = homePage.clickOnContactsLink();
		System.out.println(contactsPage);
		
	}
	
//	@Test(priority=4)
//	public void dealsLinkTest() {
//		dealsPage = homePage.clickOnDealsLink();
//		System.out.println(dealsPage);
//	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
