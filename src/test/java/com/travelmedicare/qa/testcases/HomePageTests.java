package com.travelmedicare.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.travelmedicare.qa.bases.TestBase;
import com.travelmedicare.qa.pages.CreateAccountPage;
import com.travelmedicare.qa.pages.HomePage;
import com.travelmedicare.qa.pages.LoginPage;

public class HomePageTests extends TestBase{

	HomePage homePage;
	LoginPage loginPage;
	CreateAccountPage createAccountPage;
	public HomePageTests() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
	}

	@Test(priority = 1)
	public void clickingOnMyTm_HomePage() {
		loginPage = homePage.clickOnMyTm();
	}
	
	@Test(priority = 2)
	public void ValidatingRegisterBtn_HomePage() {
		createAccountPage = homePage.ClickOnRegister();
	}
	
	@Test(priority = 3)
	public void validatingLogo_HomePage() {
		homePage.logoDisplay();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
