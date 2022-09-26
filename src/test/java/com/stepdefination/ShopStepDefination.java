package com.stepdefination;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import com.cucumber.pageobjectmodel.CartPage;
import com.cucumber.pageobjectmodel.HomePage;
import com.cucumber.pageobjectmodel.LoginPage;
import com.cucumber.pageobjectmodel.RegistrationPage;
import com.cucumber.utilities.PropertyData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ShopStepDefination {

	WebDriver driver;
	HomePage home;
	RegistrationPage reg;
	LoginPage login;
	CartPage cart;
	PropertyData data;
	SoftAssert softasrt = new SoftAssert();
	long str = System.currentTimeMillis();
	String formatGmail;

	@Given("Open the browser and enter the url")
	public void open_the_browser_and_enter_the_url() throws Exception {
		data = new PropertyData();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(data.getPropertyData("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("Register on the website and Click Signin on the landing page")
	public void register_on_the_website_and_click_signin_on_the_landing_page() {
		data = new PropertyData();
		reg = new RegistrationPage(driver);
		reg.clickOnLogin();
	}

	@When("Create Account by entering email address")
	public void create_account_by_entering_email_address() throws Exception {
		data = new PropertyData();
		reg = new RegistrationPage(driver);
		formatGmail = data.getPropertyData("mail") + str + "@gmail.com";
		reg.enterEmail(formatGmail);
		reg.clickOnCreate();
	}

	@When("Enter details on the Your Personal Information")
	public void enter_details_on_the_your_personal_information() throws Exception {
		data = new PropertyData();
		reg = new RegistrationPage(driver);
		reg.clickOnRadio();
		reg.enterFName(data.getPropertyData("FirstName"));
		reg.enterLName(data.getPropertyData("LastName"));
		reg.enterPassword(data.getPropertyData("password"));
		reg.selectDate(data.getPropertyData("date"));
		reg.selectMonth(data.getPropertyData("month"));
		reg.selectYear(data.getPropertyData("year"));
		reg.clickOncBox1();
		reg.clickOncBox2();
		reg.enterCompany(data.getPropertyData("company"));
		reg.enterAddress1(data.getPropertyData("address1"));
		reg.enterAddress2(data.getPropertyData("address2"));
		reg.enterCity(data.getPropertyData("city"));
		reg.selectState(data.getPropertyData("state"));
		reg.enterPostCode(data.getPropertyData("postcode"));
		reg.enterMsg(data.getPropertyData("msg"));
		reg.enterPhone(data.getPropertyData("phone"));
		reg.enterMobilePhone(data.getPropertyData("mobilePhone"));
		reg.enterAlias(data.getPropertyData("alias"));
		reg.clickOnRegister();
	}

	@When("Validate on the landing screen - correct name and surname is displayed")
	public void validate_on_the_landing_screen_correct_name_and_surname_is_displayed() throws Exception {
		data = new PropertyData();
		home = new HomePage(driver);
		String actualName = home.verifying();
		String expectedName = data.getPropertyData("FirstName") + " " + data.getPropertyData("LastName");
		System.out.println(actualName);
		System.out.println(expectedName);
		softasrt.assertEquals(actualName, expectedName);
		softasrt.assertAll();
	}

	@When("Logout and login again")
	public void logout_and_login_again() throws Exception {
		data = new PropertyData();
		reg = new RegistrationPage(driver);
		login = new LoginPage(driver);
		login.ClickOnLogoutBtn();
		reg.clickOnLogin();
		login.EnterEmail(formatGmail);
		login.EnterPassword(data.getPropertyData("password"));
		login.ClickOnLoginBtn();
	}

	@When("Add a product to the cart")
	public void add_a_product_to_the_cart() {
		home = new HomePage(driver);
		home.ClickOnShirts();
		home.ClickonItem();
		home.ClickOnAddToCart();
	}

	@When("Proceed to the checkout page and continue till payments")
	public void proceed_to_the_checkout_page_and_continue_till_payments() {
		home = new HomePage(driver);
		cart = new CartPage(driver);
		home.ClickOnCheckout();
		cart.ClickOnCheckOut1();
		cart.ClickOnCheckOut2();
		cart.ClickOnCheckBox();
		cart.ClickOnCheckOut3();
	}

	@Then("Validate on the payments page if the product details are correct")
	public void validate_on_the_payments_page_if_the_product_details_are_correct() throws Exception {
		cart = new CartPage(driver);
		data = new PropertyData();
		home = new HomePage(driver);
		String actualDress = cart.verifyDress();
		System.out.println(actualDress);
		softasrt.assertEquals(actualDress, data.getPropertyData("expected"));
		softasrt.assertAll();
	}
}
