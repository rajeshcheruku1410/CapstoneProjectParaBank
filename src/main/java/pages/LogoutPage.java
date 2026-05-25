package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

	WebDriver driver;
	WebDriverWait wait;

	public LogoutPage(WebDriver driver) {

		this.driver = driver;

		wait = new WebDriverWait(driver,
				Duration.ofSeconds(10));

		PageFactory.initElements(driver, this);
	}

	

	@FindBy(linkText = "Log Out")
	WebElement logoutLink;

	@FindBy(name = "username")
	WebElement usernameField;

	@FindBy(name = "password")
	WebElement passwordField;

	@FindBy(xpath = "//input[@value='Log In']")
	WebElement loginButton;

	

	public void clickLogoutLink() {

		logoutLink.click();
	}

	

	public boolean verifyLogoutSuccess() {

		wait.until(ExpectedConditions
				.visibilityOf(loginButton));

		return loginButton.isDisplayed();
	}

	public boolean verifySessionTerminated() {

		String currentUrl = driver.getCurrentUrl();

		String pageSource = driver.getPageSource();

		return currentUrl.contains("index")
				|| pageSource.contains("Customer Login")
				|| pageSource.contains("Username")
				|| pageSource.contains("Password");
	}
}