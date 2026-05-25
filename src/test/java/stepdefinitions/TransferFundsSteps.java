package stepdefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.TransferFundsPage;

public class TransferFundsSteps extends BaseClass {

	LoginPage loginPage;
	TransferFundsPage transferPage;

	@When("user logs into parabank for transfer funds")
	public void user_logs_into_parabank_for_transfer_funds() {

		loginPage = new LoginPage(driver);

		loginPage.enterUsername("john");
		loginPage.enterPassword("demo");

		loginPage.clickLoginButton();
	}


	@When("user clicks on transfer funds link")
	public void user_clicks_on_transfer_funds_link() {

		transferPage =
				new TransferFundsPage(driver);

		transferPage.clickTransferFundsLink();
	}

	@Then("user should navigate to transfer funds page")
	public void user_should_navigate_to_transfer_funds_page() {

		Assert.assertTrue(
				transferPage
				.verifyTransferFundsPage());
	}



	@When("user enters valid transfer amount")
	public void user_enters_valid_transfer_amount() {

		transferPage.enterAmount("300");
	}

	@When("user clicks transfer funds button")
	public void user_clicks_transfer_funds_button() {

		transferPage.clickTransferButton();
	}

	@Then("fund transfer should be successful")
	public void fund_transfer_should_be_successful() {

		Assert.assertTrue(
				transferPage
				.verifyTransferSuccess());
	}


	@When("user enters invalid transfer amount")
	public void user_enters_invalid_transfer_amount() {

		transferPage.enterAmount("-300");
	}

	@Then("user should see invalid transfer behavior")
	public void user_should_see_invalid_transfer_behavior() {

		Assert.assertTrue(
				transferPage
				.verifyInvalidTransfer());
	}


	@Then("user should see transfer success message")
	public void user_should_see_transfer_success_message() {

		Assert.assertTrue(
				transferPage
				.verifyTransferMessage());
	}
}