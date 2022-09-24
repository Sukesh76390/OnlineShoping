package com.cucumber.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='logout']")
	WebElement signOutBtn;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailTxt;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement pwdTxt;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement submitLogin;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnLogoutBtn() {
		signOutBtn.click();
	}
	public void EnterEmail(String email) {
		emailTxt.sendKeys(email);
	}
	public void EnterPassword(String pwsd) {
		pwdTxt.sendKeys(pwsd);
	}
	public void ClickOnLoginBtn() {
		submitLogin.click();
	}

}
