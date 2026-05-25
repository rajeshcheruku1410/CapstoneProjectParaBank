package stepdefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BillPayPage;
import pages.LoginPage;

public class BillPaySteps extends BaseClass {

	LoginPage loginPage;
	BillPayPage billPayPage;


	@When("user logs into parabank for bill payment")
	public void user_logs_into_parabank_for_bill_payment() {

		loginPage = new LoginPage(driver);

		loginPage.enterUsername("john");
		loginPage.enterPassword("demo");

		loginPage.clickLoginButton();
	}


	@When("user clicks on bill pay link")
	public void user_clicks_on_bill_pay_link() {

		billPayPage = new BillPayPage(driver);

		billPayPage.clickBillPayLink();
	}

	@Then("user should navigate to bill pay page")
	public void user_should_navigate_to_bill_pay_page() {

		Assert.assertTrue(
				billPayPage.verifyBillPayPage());
	}


	@When("user enters valid bill payment details")
	public void user_enters_valid_bill_payment_details() {

		billPayPage.enterPayeeName("Rajesh");

		billPayPage.enterAddress("2-123");

		billPayPage.enterCity("jgl");

		billPayPage.enterState("Ts");

		billPayPage.enterZipCode("505425");

		billPayPage.enterPhone("9849884181");

		billPayPage.enterAccountNumber("12345");

		billPayPage.enterVerifyAccount("12345");

		billPayPage.enterAmount("100");
	}

	@When("user clicks send payment button")
	public void user_clicks_send_payment_button() {

		billPayPage.clickSendPaymentButton();
	}

	@Then("bill payment should be successful")
	public void bill_payment_should_be_successful() {

		Assert.assertTrue(
				billPayPage.verifyPaymentSuccess());
	}

	

	@When("user enters invalid bill payment details")
	public void user_enters_invalid_bill_payment_details() {

		billPayPage.enterPayeeName("");

		billPayPage.enterAddress("");

		billPayPage.enterCity("");

		billPayPage.enterState("");

		billPayPage.enterZipCode("");

		billPayPage.enterPhone("");

		billPayPage.enterAccountNumber("");

		billPayPage.enterVerifyAccount("");

		billPayPage.enterAmount("");
	}

	@Then("user should see invalid bill payment behavior")
	public void user_should_see_invalid_bill_payment_behavior() {

		Assert.assertTrue(
				billPayPage.verifyInvalidPayment());
	}


	@Then("user should see bill payment confirmation message")
	public void user_should_see_bill_payment_confirmation_message() {

		Assert.assertTrue(
				billPayPage.verifyPaymentMessage());
	}
}