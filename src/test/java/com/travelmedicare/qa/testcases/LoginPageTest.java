package com.travelmedicare.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.travelmedicare.qa.bases.TestBase;
import com.travelmedicare.qa.pages.HomePage;
import com.travelmedicare.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	
	public LoginPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		loginPage = homePage.clickOnMyTm();
	}
	
	@Test(priority = 1)
	public void ValidData_SignIn() {
		loginPage.SignIn("hemanshu2838@gmail.com", "Rr@191604");
		String title = loginPage.gettingTittle();
		Assert.assertEquals(title, "Quick Quote");
	}
	@Test(priority = 2)
	public void InValidData_BlankEmail_SignIn() {
		loginPage.SignIn("", "Rr@191604");
		String title = loginPage.EmailError();
		Assert.assertEquals(title, "The email field is required.");
	}
	@Test(priority = 3)
	public void InValidData_BlankPassword_SignIn() {
		loginPage.SignIn("hemanshu2838", "");
		String title = loginPage.passwordError();
		Assert.assertEquals(title, "The password field is required.");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
