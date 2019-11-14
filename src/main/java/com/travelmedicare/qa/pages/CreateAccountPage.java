package com.travelmedicare.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.travelmedicare.qa.bases.TestBase;

public class CreateAccountPage extends TestBase {
	
	@FindBy(name = "first_name")
	WebElement firstName;
	
	@FindBy(name = "last_name")
	WebElement lastName;
	
	@FindBy(name = "email")
	WebElement eMail;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name = "password_confirmation")
	WebElement cnfmPassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath = "//*[text()='Personal Details']")
	WebElement pageName;

	public CreateAccountPage() {
		PageFactory.initElements(driver, this);
	}
	public void createAccountInput(String fn, String ln,String eml,String fpwd,String cpwd) {
		
		
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		eMail.sendKeys(eml);
		password.sendKeys(fpwd);
		cnfmPassword.sendKeys(cpwd);
		submit.click();
	} 
	
	public void checkPagetitle() {
		String nameofPage = pageName.getText();
		Assert.assertEquals(nameofPage, "Personal Details" );
	}
}
