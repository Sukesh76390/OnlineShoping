package com.cucumber.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver driver;

	@FindBy(xpath = "(//a[@title='Proceed to checkout'])[2]")
	WebElement checkout1;

	@FindBy(xpath = "//button[@name='processAddress']")
	WebElement checkout2;

	@FindBy(xpath = "//input[@id='cgv']")
	WebElement check;

	@FindBy(xpath = "//button[@name='processCarrier']")
	WebElement checkout3;

	@FindBy(xpath = "//p[@class='product-name']")
	WebElement dress;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickOnCheckOut1() {
		checkout1.click();
	}

	public void ClickOnCheckOut2() {
		checkout2.click();
	}

	public void ClickOnCheckBox() {
		check.click();
	}

	public void ClickOnCheckOut3() {
		checkout3.click();
	}

	public String verifyDress() {
		return dress.getText();
	}

}
