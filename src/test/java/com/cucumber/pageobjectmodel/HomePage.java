package com.cucumber.pageobjectmodel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//a[@class='account']/span")
	WebElement regName;

	@FindBy(xpath = "(//a[@title='T-shirts'])[2]")
	WebElement shirts;
	
	@FindBy(xpath="//img[@itemprop='image']")
	WebElement item;

	@FindBy(xpath = "//button[@type='submit']/span[text()='Add to cart']")
	WebElement addToCart;

	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	WebElement checkout;

	@FindBy(xpath = "//h1[@itemprop='name']")
	WebElement dressName;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String verifying() {
		return regName.getText();
	}

	public void ClickOnShirts() {
		shirts.click();
	}

	public void ClickonItem() {
		item.click();
	}

	public void ClickOnAddToCart() {
		driver.switchTo().frame(0); 	
		addToCart.click();
	}

	public void ClickOnCheckout() {
		checkout.click();
	}

	public String DressName() {
		return dressName.getText();
	}
}
