package com.cucumber.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//input[@name='email_create']")
	WebElement eBox;
	
	@FindBy(id="SubmitCreate")
	WebElement createAccount;
	
	@FindBy(xpath="//label[@for='id_gender1']")
	WebElement gender;
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	WebElement fName;
	
	@FindBy(xpath="//input[@id='customer_lastname']")
	WebElement lName;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='newsletter']")
	WebElement newsletter;
	
	@FindBy(xpath="//input[@id='optin']")
	WebElement option;
	
	@FindBy(xpath="//input[@id='company']")
	WebElement company;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement address1;
	
	@FindBy(xpath="//input[@id='address2']")
	WebElement address2;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='postcode']")
	WebElement postcode;
	
	@FindBy(xpath="//textarea[@id='other']")
	WebElement msgBox;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement phone;
	
	@FindBy(xpath="//input[@id='phone_mobile']")
	WebElement mobilePhone;
	
	@FindBy(xpath="//input[@id='alias']")
	WebElement alias;
	
	@FindBy(xpath="//button[@id='submitAccount']")
	WebElement submitBtn;
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogin() {
		loginBtn.click();
	}
	public void enterEmail(String email) {
		eBox.sendKeys(email);
	}
	public void clickOnCreate() {
		createAccount.click();
	}
	public void clickOnRadio() {
		gender.click();
	}
	public void enterFName(String ftName) {
		fName.sendKeys(ftName);
	}
	public void enterLName(String ltName) {
		lName.sendKeys(ltName);
	}
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void selectDate(String date) {
		WebElement day = driver.findElement(By.xpath("//select[@id='days']"));
		Select select = new Select(day);
		select.selectByValue(date);
	}
	public void selectMonth(String months) {
		WebElement month = driver.findElement(By.xpath("//select[@id='months']"));
		Select select = new Select(month);
		select.selectByValue(months);
	}
	public void selectYear(String years) {
		WebElement year = driver.findElement(By.xpath("//select[@id='years']"));
		Select select = new Select(year);
		select.selectByValue(years);
	}
	public void clickOncBox1() {
		newsletter.click();
	}
	public void clickOncBox2() {
		option.click();
	}
	public void enterCompany(String compan) {
		company.sendKeys(compan);
	}
	public void enterAddress1(String add1) {
		address1.sendKeys(add1);
	}
	public void enterAddress2(String add2) {
		address2.sendKeys(add2);
	}
	public void enterCity(String city1) {
		city.sendKeys(city1);
	}
	public void selectState(String state) {
		WebElement states = driver.findElement(By.xpath("//select[@id='id_state']"));
		Select select = new Select(states);
		select.selectByValue(state);
	}
	public void enterPostCode(String code) {
		postcode.sendKeys(code);
	}
	public void enterMsg(String msg) {
		msgBox.sendKeys(msg);
	}
	public void enterPhone(String ph) {
		phone.sendKeys(ph);
	}
	public void enterMobilePhone(String mobph) {
		mobilePhone.sendKeys(mobph);
	}
	public void enterAlias(String als) {
		alias.clear();
		alias.sendKeys(als);
	}
	public void clickOnRegister() {
		submitBtn.click();
	}

}
