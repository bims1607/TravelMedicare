package com.travelmedicare.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.travelmedicare.qa.bases.TestBase;

public class LoginPage extends TestBase{

	@FindBy(name = "email")
	WebElement signInEmail;
	
	@FindBy(name = "password")
	WebElement signInPassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement sbButton;
	
	@FindBy(xpath = "//*[contains(text(),'Quick Quote')]")
	WebElement quickQuotetitle; 
	
	@FindBy(xpath = "//*[contains(text(),'The password field is required')]")
	WebElement paswdError;
	
	@FindBy(xpath = "//*[contains(text(),'The email field is required')]")
	WebElement emailError;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void SignIn(String email, String password){
		signInEmail.sendKeys(email);
		signInPassword.sendKeys(password);
		sbButton.click();
	}
	
	public String gettingTittle() {
		return quickQuotetitle.getText();
	}
	
	public String passwordError() {
		return paswdError.getText();
	}
	public String EmailError() {
		return emailError.getText();
	}
}
