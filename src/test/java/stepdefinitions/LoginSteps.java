package stepdefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps extends BaseClass {

    LoginPage loginPage;

    @Given("User launches ParaBank application")
    public void user_launches_parabank_application() {

        loginPage = new LoginPage(driver);
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {

        loginPage.enterUsername("john");
        loginPage.enterPassword("demo");
    }

    @When("User enters invalid username and valid password")
    public void user_enters_invalid_username_and_valid_password() {

        loginPage.enterUsername("wronguser");
        loginPage.enterPassword("NoPassword@123");
    }

    @When("User enters valid username and invalid password")
    public void user_enters_valid_username_and_invalid_password() {

        loginPage.enterUsername("udaySample");
        loginPage.enterPassword("wrongpass");
    }

    @When("User enters blank username and password")
    public void user_enters_blank_username_and_password() {

        loginPage.enterUsername("");
        loginPage.enterPassword("");
    }

 
    @And("User clicks login button")
    public void user_clicks_login_button() {

        loginPage.clickLoginButton();
    }

   
    @Then("User should navigate to account overview page")
    public void user_should_navigate_to_account_overview_page() {

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Accounts Overview"));

        
    }

    @Then("User should see invalid login error message")
    public void user_should_see_invalid_login_error_message() {

    	String currentUrl =
    			driver.getCurrentUrl();

    	Assert.assertTrue(

    			currentUrl.contains("index")
    			|| currentUrl.contains("login")
    	);
    	
    }

    @Then("User should verify username textbox")
    public void user_should_verify_username_textbox() {

        Assert.assertTrue(
                loginPage.verifyUsernameTextbox());
    }

    @And("User should verify password textbox")
    public void user_should_verify_password_textbox() {

        Assert.assertTrue(
                loginPage.verifyPasswordTextbox());
    }

    @And("User should verify login button")
    public void user_should_verify_login_button() {

        Assert.assertTrue(
                loginPage.verifyLoginButton());

        
    }
}