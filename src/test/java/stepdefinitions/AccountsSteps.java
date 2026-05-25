package stepdefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountsPage;
import pages.LoginPage;

public class AccountsSteps extends BaseClass {

	LoginPage loginPage;
	AccountsPage accountsPage;

	@When("user logs into ParaBank application")
	public void user_logs_into_para_bank_application() {

		loginPage = new LoginPage(driver);

		loginPage.enterUsername("john");
		loginPage.enterPassword("demo");

		loginPage.clickLoginButton();
	}

	@When("user clicks on accounts overview")
	public void user_clicks_on_accounts_overview() {

		accountsPage = new AccountsPage(driver);

		accountsPage.clickAccountsOverview();
	}

	@Then("user should navigate to accounts overview page")
	public void user_should_navigate_to_accounts_overview_page() {

		Assert.assertTrue(
				accountsPage.getAccountsOverviewPageText()
				.contains("Accounts Overview"));
	}

	@Then("user should see account details and balances")
	public void user_should_see_account_details_and_balances() {

		Assert.assertTrue(
				accountsPage.verifyAccountsTable());
	}
}