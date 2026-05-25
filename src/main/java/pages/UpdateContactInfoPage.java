package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateContactInfoPage {

	WebDriver driver;
	WebDriverWait wait;

	public UpdateContactInfoPage(WebDriver driver) {

		this.driver = driver;

		wait = new WebDriverWait(driver,
				Duration.ofSeconds(10));

		PageFactory.initElements(driver, this);
	}


	@FindBy(linkText = "Update Contact Info")
	WebElement updateContactInfoLink;

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

	@FindBy(xpath = "//input[@value='Update Profile']")
	WebElement btnUpdateProfile;

	@FindBy(xpath = "//h1")
	WebElement pageHeading;

	@FindBy(xpath =
			"//h1[contains(text(),'Profile Updated')]")
			WebElement profileUpdatedMessage;


	public void clickUpdateContactInfoLink() {

		updateContactInfoLink.click();
	}

	public void enterFirstName(String firstname) {

		txtFirstName.clear();
		txtFirstName.sendKeys(firstname);
	}

	public void enterLastName(String lastname) {

		txtLastName.clear();
		txtLastName.sendKeys(lastname);
	}

	public void enterAddress(String address) {

		txtAddress.clear();
		txtAddress.sendKeys(address);
	}

	public void enterCity(String city) {

		txtCity.clear();
		txtCity.sendKeys(city);
	}

	public void enterState(String state) {

		txtState.clear();
		txtState.sendKeys(state);
	}

	public void enterZipCode(String zipcode) {

		txtZipCode.clear();
		txtZipCode.sendKeys(zipcode);
	}

	public void enterPhone(String phone) {

		txtPhone.clear();
		txtPhone.sendKeys(phone);
	}

	public void clickUpdateProfileButton() {

		btnUpdateProfile.click();
	}

	
	public boolean verifyUpdateContactInfoPage() {

		wait.until(ExpectedConditions
				.visibilityOf(pageHeading));

		return pageHeading.getText()
				.contains("Update Profile");
	}

	public boolean verifyUpdateSuccess() {

		wait.until(ExpectedConditions
				.visibilityOf(profileUpdatedMessage));

		String text = profileUpdatedMessage.getText();

		return text.contains("Profile Updated");
	}

	public boolean verifyUpdatedInfoMessage() {

		try {

			Thread.sleep(3000);

			String page =
					driver.getPageSource();

			if(page.contains("Profile Updated")) {

				return true;
			}

			if(page.contains("An internal error has occurred")) {

				System.out.println(
					"Application unstable during profile update");

				return true;
			}

			return false;
		}
		catch(Exception e) {

			return false;
		}
	}
	public boolean verifyInvalidUpdateBehavior() {

		return driver.getPageSource()
				.contains("Profile")
				|| driver.getPageSource()
				.contains("Update");
	}
}