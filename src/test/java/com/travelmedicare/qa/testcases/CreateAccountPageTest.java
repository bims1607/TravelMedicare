package com.travelmedicare.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.travelmedicare.qa.bases.TestBase;
import com.travelmedicare.qa.pages.CreateAccountPage;
import com.travelmedicare.qa.pages.HomePage;
import com.travelmedicare.qa.utils.TestUtils;

public class CreateAccountPageTest extends TestBase {


	String SheetName= "wb11";
	HomePage homePage ;
	CreateAccountPage createAccountPage;
	public CreateAccountPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		//TestUtils testUtils = new TestUtils();
		
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = TestUtils.getTestData(SheetName);
		return data;
	}
	
	@Test(priority = 1, dataProvider = "getData")
	public void createAccount(String fn, String ln, String ml, String ps, String cps) {
		createAccountPage = homePage.ClickOnRegister();
		createAccountPage.createAccountInput(fn, ln, ml, ps, cps);
		createAccountPage.checkPagetitle();
	}
	
	@AfterMethod	
	public void teardown() {
		driver.quit();
	}
}
