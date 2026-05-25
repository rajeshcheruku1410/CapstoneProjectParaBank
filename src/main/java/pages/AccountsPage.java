package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {

	WebDriver driver;

	public AccountsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(linkText = "Accounts Overview")
	WebElement accountsOverviewLink;

	@FindBy(xpath = "//h1")
	WebElement accountsOverviewText;

	@FindBy(id = "accountTable")
	WebElement accountsTable;

	

	public void clickAccountsOverview() {

		accountsOverviewLink.click();
	}



	public String getAccountsOverviewPageText() {

		return accountsOverviewText.getText();
	}

	public boolean verifyAccountsTable() {

		return accountsTable.isDisplayed();
	}
}
