package stepdefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.UpdateContactInfoPage;

public class UpdateContactInfoSteps extends BaseClass {

	LoginPage loginPage;
	UpdateContactInfoPage updatePage;


	@When("user logs into parabank for update contact info")
	public void user_logs_into_parabank_for_update_contact_info() {

		loginPage = new LoginPage(driver);

		loginPage.enterUsername("john");
		loginPage.enterPassword("demo");

		loginPage.clickLoginButton();
	}


	@When("user clicks on update contact info link")
	public void user_clicks_on_update_contact_info_link() {

		updatePage =
				new UpdateContactInfoPage(driver);

		updatePage.clickUpdateContactInfoLink();
	}

	@Then("user should navigate to update contact info page")
	public void user_should_navigate_to_update_contact_info_page() {

		Assert.assertTrue(
				updatePage
				.verifyUpdateContactInfoPage());
	}


	@When("user enters valid contact details")
	public void user_enters_valid_contact_details() {

		updatePage.enterFirstName("rajesh");

		updatePage.enterLastName("cheruku");

		updatePage.enterAddress("Street 2");

		updatePage.enterCity("Dmp");

		updatePage.enterState("Ts");

		updatePage.enterZipCode("505425");

		updatePage.enterPhone("9550920301");
	}

	@When("user clicks update profile button")
	public void user_clicks_update_profile_button() {

		updatePage.clickUpdateProfileButton();
	}

	@Then("contact details should update successfully")
	public void contact_details_should_update_successfully() {

		updatePage.checkProfileUpdateMsg();
	}


	@When("user enters invalid contact details")
	public void user_enters_invalid_contact_details() {

		updatePage.enterFirstName("");

		updatePage.enterLastName("");

		updatePage.enterAddress("");

		updatePage.enterCity("");

		updatePage.enterState("");

		updatePage.enterZipCode("");

		updatePage.enterPhone("");
	}

	@Then("user should see invalid update behavior")
	public void user_should_see_invalid_update_behavior() {

		Assert.assertTrue(
				updatePage
				.verifyInvalidUpdateBehavior());
	}


	@Then("user should see updated contact information message")
	public void user_should_see_updated_contact_information_message() {

		Assert.assertTrue(
				updatePage
				.verifyUpdatedInfoMessage());
	}
}