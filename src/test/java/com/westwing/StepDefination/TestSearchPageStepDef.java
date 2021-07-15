package com.westwing.StepDefination;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.westwing.pages.HomePage;
import com.westwing.pages.LoginPage;
import com.westwing.utility.Baseclass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSearchPageStepDef {

	Baseclass bs = new Baseclass();
	// HomePage hp;
	HomePage hp;
	LoginPage lp;
	ExtentTest test;
	ExtentReports report;


	@Given("I am on the WestwingNow home page {string}")
	public void i_am_on_the_westwing_now_home_page(String string) {
		report = new ExtentReports(System.getProperty("user.dir") + "//Report//ExtentReportResults.html");
		test = report.startTest("WestWing Search result");
		String browserName=bs.propertyFileReader("browserName");
		bs.launchBrowser(browserName);

		bs.launchURl(string, "Ihr M�bel & Interior Online-Shop | WestwingNow");
		}

	@When("I search for {string}")
	public void i_search_for(String string) {

		hp = new HomePage(bs.getdriver());
		lp = new LoginPage(bs.getdriver());
		Assert.assertTrue(bs.click(hp.acceptCookiesBtn));
		bs.typeText(hp.searchInput, string);
		bs.pressEnter(hp.searchInput);
		bs.actionClick();
		test.log(LogStatus.PASS, "Test search result visible");

	}

	@Then("I should see product listing page with a list of products")
	public void i_should_see_product_listing_page_with_a_list_of_products() {

		Assert.assertTrue(bs.isDisplayed(hp.product_List));
		test.log(LogStatus.PASS, "Test list of products visible");

	}

	@When("I click on wishlist icon of the first found product")
	public void i_click_on_wishlist_icon_of_the_first_found_product() {
		bs.clickedonListofWebElmeent(hp.wishlist, 0);
		test.log(LogStatus.PASS, "Test wishlish icon of the first found product visible");
	}

	@Then("I should see the login\\/registration overlay")
	public void i_should_see_the_login_registration_overlay() {
		bs.waitForElementToVisible(lp.registrationPageHeader);
		bs.click(lp.loginButton);
		test.log(LogStatus.PASS, "Test login registeration overlay visible");
	}

	@When("I switch to login form of the overlay")
	public void i_switch_to_login_form_of_the_overlay() {

		bs.waitForElementToVisible(lp.email);
		test.log(LogStatus.PASS, "Test switched to login form overlay successfully");
	}

	@When("I log in with {string}  credentials")
	public void i_log_in_with_credentials(String string) {

		bs.typeText(lp.email, "adhirmukati59@gmail.com");
		bs.typeText(lp.password, "Qait@1234");
		bs.click(lp.submitButton);
		test.log(LogStatus.PASS, "Test logged in successfully ");

	}

	@Then("the product should be added to the wishlist \\(wishlist icon on the product is filled in and wishlist counter in the website header shows {int},  screenshot )")
	public void the_product_should_be_added_to_the_wishlist_wishlist_icon_on_the_product_is_filled_in_and_wishlist_counter_in_the_website_header_shows_screenshot(
			Integer int1) {
		bs.waitForElementToVisible(lp.wishlistCounter);
		bs.getText(lp.wishlistCounter);
		bs.click(lp.wishlistLink);
		test.log(LogStatus.PASS, "Product added to the wishlish");

	}

	@Then("I delete the product from my wishlist")
	public void i_delete_the_product_from_my_wishlist() {

		lp.hardWait(2000);
		lp.click(lp.productListDeleteButton);
		lp.hardWait(2000);
		lp.actionHold(lp.meinKonto);
		lp.hardWait(2000);
		lp.click(lp.signout);
		test.log(LogStatus.PASS, "Test delete the product from my wishlist ");
		bs.getdriver().close();
		report.endTest(test);
		report.flush();
	}

}
