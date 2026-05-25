package stepdefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegistrationPage;

public class RegistrationSteps extends BaseClass {

    RegistrationPage register;


    @When("user clicks on register link")
    public void user_clicks_on_register_link() {

        register = new RegistrationPage(driver);

        register.clickRegisterLink();
    }

   

    @When("user enters firstname")
    public void user_enters_firstname() {

        register.enterFirstName("Uday");
    }

    @When("user enters lastname")
    public void user_enters_lastname() {

        register.enterLastName("Gedela");
    }

    @When("user enters address")
    public void user_enters_address() {

        register.enterAddress("Street No 7");
    }

    @When("user enters city")
    public void user_enters_city() {

        register.enterCity("Vizag");
    }

    @When("user enters state")
    public void user_enters_state() {

        register.enterState("Andhra Pradesh");
    }

    @When("user enters zipcode")
    public void user_enters_zipcode() {

        register.enterZipCode("530001");
    }

    @When("user enters phone number")
    public void user_enters_phone_number() {

        register.enterPhoneNumber("9999999999");
    }

    @When("user enters ssn")
    public void user_enters_ssn() {

        register.enterSSN("123456");
    }

    @When("user enters username")
    public void user_enters_username() {

        register.enterUsername("uday");
    }

    @When("user enters password")
    public void user_enters_password() {

        register.enterPassword("demo123");
    }

    @When("user enters confirm password")
    public void user_enters_confirm_password() {

        register.enterConfirmPassword("demo123");
    }

    @When("user clicks register button")
    public void user_clicks_register_button() {

        register.clickRegisterButton();
    }

 

    @When("user clicks register button without entering mandatory fields")
    public void user_clicks_register_button_without_entering_mandatory_fields() {

        register.clickRegisterButton();
    }


    @Then("user should register successfully")
    public void user_should_register_successfully() {

        Assert.assertTrue(
                register.getSuccessMessage().contains("Welcome"));
        
    }

    @Then("user should see mandatory field error")
    public void user_should_see_mandatory_field_error() {

        Assert.assertTrue(
                register.verifyMandatoryFieldError());
      
    }
}