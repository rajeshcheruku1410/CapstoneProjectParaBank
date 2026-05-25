package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillPayPage {

	WebDriver driver;
	WebDriverWait wait;

	public BillPayPage(WebDriver driver) {

		this.driver = driver;

		wait = new WebDriverWait(driver,
				Duration.ofSeconds(10));

		PageFactory.initElements(driver, this);
	}

	// Locators

	@FindBy(linkText = "Bill Pay")
	WebElement billPayLink;

	@FindBy(name = "payee.name")
	WebElement txtPayeeName;

	@FindBy(name = "payee.address.street")
	WebElement txtAddress;

	@FindBy(name = "payee.address.city")
	WebElement txtCity;

	@FindBy(name = "payee.address.state")
	WebElement txtState;

	@FindBy(name = "payee.address.zipCode")
	WebElement txtZipCode;

	@FindBy(name = "payee.phoneNumber")
	WebElement txtPhone;

	@FindBy(name = "payee.accountNumber")
	WebElement txtAccountNumber;

	@FindBy(name = "verifyAccount")
	WebElement txtVerifyAccount;

	@FindBy(name = "amount")
	WebElement txtAmount;

	@FindBy(xpath = "//input[@value='Send Payment']")
	WebElement btnSendPayment;

	@FindBy(xpath = "//h1")
	WebElement billPayHeading;

	@FindBy(id = "billpayResult")
	WebElement paymentResult;

	// Actions

	public void clickBillPayLink() {

		billPayLink.click();
	}

	public void enterPayeeName(String name) {

		txtPayeeName.sendKeys(name);
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

	public void enterPhone(String phone) {

		txtPhone.sendKeys(phone);
	}

	public void enterAccountNumber(String accNo) {

		txtAccountNumber.sendKeys(accNo);
	}

	public void enterVerifyAccount(String accNo) {

		txtVerifyAccount.sendKeys(accNo);
	}

	public void enterAmount(String amount) {

		txtAmount.sendKeys(amount);
	}

	public void clickSendPaymentButton() {

		btnSendPayment.click();
	}

	// Validations

	public boolean verifyBillPayPage() {

		wait.until(ExpectedConditions
				.visibilityOf(billPayHeading));

		return billPayHeading.getText()
				.contains("Bill Payment Service");
	}

	public boolean verifyPaymentSuccess() {

		wait.until(ExpectedConditions
				.visibilityOf(paymentResult));

		String text = paymentResult.getText();

		return text.contains("Bill Payment Complete");
	}

	public boolean verifyPaymentMessage() {

		wait.until(ExpectedConditions
				.visibilityOf(paymentResult));

		String text = paymentResult.getText();

		return text.contains("successful");
	}

	public boolean verifyInvalidPayment() {

		return driver.getPageSource()
				.contains("Error")
				|| driver.getPageSource()
				.contains("Bill Payment");
	}
}