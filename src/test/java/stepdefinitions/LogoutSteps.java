package stepdefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.LogoutPage;

public class LogoutSteps extends BaseClass {

	LoginPage loginPage;
	LogoutPage logoutPage;


	@When("user logs into parabank for logout")
	public void user_logs_into_parabank_for_logout() {

		loginPage = new LoginPage(driver);

		loginPage.enterUsername("john");
		loginPage.enterPassword("demo");

		loginPage.clickLoginButton();
	}



	@When("user clicks logout link")
	public void user_clicks_logout_link() {

		logoutPage = new LogoutPage(driver);

		logoutPage.clickLogoutLink();
	}

	@Then("user should logout successfully")
	public void user_should_logout_successfully() {

		Assert.assertTrue(
				logoutPage
				.verifyLogoutSuccess());
	}
	@When("User enters invalid username and password")
	public void user_enters_invalid_username_and_password() {

		loginPage = new LoginPage(driver);

		loginPage.enterUsername("wronguser");
		loginPage.enterPassword("wrongpass");
	}


	@Then("user session should terminate successfully")
	public void user_session_should_terminate_successfully() {

		Assert.assertTrue(
				logoutPage.verifyLogoutSuccess());
	}
}