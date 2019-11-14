package com.travelmedicare.qa.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.travelmedicare.qa.bases.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(linkText = "My TM")
	WebElement loginbtn;
	
	@FindBy(xpath = "//a[@href='http://travelmedicare.com/register']")
	WebElement register;
	
	@FindBy(xpath = "//img[@alt='logo']")
	WebElement logo;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnMyTm() {
		loginbtn.click();
		return new LoginPage();
	}
	
	public CreateAccountPage ClickOnRegister() {
		register.click();
		return new CreateAccountPage();
	}
	
	public void logoDisplay() {
		logo.isDisplayed();
	}
}
