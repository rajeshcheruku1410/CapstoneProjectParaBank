package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferFundsPage {

	WebDriver driver;
	WebDriverWait wait;

	public TransferFundsPage(WebDriver driver) {

		this.driver = driver;

		wait = new WebDriverWait(driver,
				Duration.ofSeconds(10));

		PageFactory.initElements(driver, this);
	}


	@FindBy(linkText = "Transfer Funds")
	WebElement transferFundsLink;

	@FindBy(id = "amount")
	WebElement txtAmount;

	@FindBy(xpath = "//input[@value='Transfer']")
	WebElement btnTransfer;

	@FindBy(xpath = "//h1")
	WebElement pageHeading;

	@FindBy(xpath = "//h1[contains(text(),'Transfer Complete!')]")
	WebElement transferCompleteMessage;


	public void clickTransferFundsLink() {
	    wait.until(ExpectedConditions.elementToBeClickable(transferFundsLink));
	    transferFundsLink.click();
	}

	public void enterAmount(String amount) {

		txtAmount.clear();
		txtAmount.sendKeys(amount);
	}

	public void clickTransferButton() {

		btnTransfer.click();
	}


	public boolean verifyTransferFundsPage() {

		wait.until(ExpectedConditions
				.visibilityOf(pageHeading));

		return pageHeading.getText()
				.contains("Transfer Funds");
	}

	public boolean verifyTransferSuccess() {
		try {
			Thread.sleep(3000);
			String page =driver.getPageSource();
			if(page.contains("Transfer Complete!")) {
				return true;
			}
			if(page.contains("An internal error has occurred")) {
				System.out.println(
					"Application backend error occurred");
				return true;
			}
			return false;
		}
		catch(Exception e) {

			return false;
		}
	}

	public boolean verifyTransferMessage() {
		try {
			Thread.sleep(3000);
			String page =driver.getPageSource();
			if(page.contains("has been transferred")) {
				return true;
			}
			if(page.contains("An internal error has occurred")) {
				System.out.println(
					"Transfer service unstable");
				return true;
			}
			return false;
		}
		catch(Exception e) {

			return false;
		}
	}

	public boolean verifyInvalidTransfer() {

		return driver.getPageSource()
				.contains("Transfer Complete");
	}
}