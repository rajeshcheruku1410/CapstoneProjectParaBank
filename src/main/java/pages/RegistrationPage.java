package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(id = "customer.firstName")
    WebElement txtFirstName;

    @FindBy(id = "customer.lastName")
    WebElement txtLastName;

    @FindBy(id = "customer.address.street")
    WebElement txtAddress;

    @FindBy(id = "customer.address.city")
    WebElement txtCity;

    @FindBy(id = "customer.address.state")
    WebElement txtState;

    @FindBy(id = "customer.address.zipCode")
    WebElement txtZipCode;

    @FindBy(id = "customer.phoneNumber")
    WebElement txtPhone;

    @FindBy(id = "customer.ssn")
    WebElement txtSSN;

    @FindBy(id = "customer.username")
    WebElement txtUsername;

    @FindBy(id = "customer.password")
    WebElement txtPassword;

    @FindBy(id = "repeatedPassword")
    WebElement txtConfirmPassword;

    @FindBy(xpath = "//input[@value='Register']")
    WebElement btnRegister;

    @FindBy(xpath = "//h1")
    WebElement successMessage;

    @FindBy(id = "customer.firstName.errors")
    WebElement firstNameError;


    public void clickRegisterLink() {

        registerLink.click();
    }

    public void enterFirstName(String firstname) {

        txtFirstName.sendKeys(firstname);
    }

    public void enterLastName(String lastname) {

        txtLastName.sendKeys(lastname);
    }

    public void enterAddress(String address) {

        txtAddress.sendKeys(address);
    }

    public void enterCity(String city) {

        txtCity.sendKeys(city);
    }

    public void enterState(String state) {

        txtState.sendKeys(state);
    }

    public void enterZipCode(String zipcode) {

        txtZipCode.sendKeys(zipcode);
    }

    public void enterPhoneNumber(String phone) {

        txtPhone.sendKeys(phone);
    }

    public void enterSSN(String ssn) {

        txtSSN.sendKeys(ssn);
    }

    public void enterUsername(String username) {

        txtUsername.sendKeys(
                username + System.currentTimeMillis());
    }

    public void enterPassword(String password) {

        txtPassword.sendKeys(password);
    }

    public void enterConfirmPassword(String password) {

        txtConfirmPassword.sendKeys(password);
    }

    public void clickRegisterButton() {

        btnRegister.click();
    }

    public String getSuccessMessage() {

        return successMessage.getText();
    }

    public boolean verifyMandatoryFieldError() {

        return firstNameError.isDisplayed();
    }
}