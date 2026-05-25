package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    WebElement txtUsername;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Log In']")
    WebElement btnLogin;

    @FindBy(xpath = "//p[@class='error']")
    WebElement errorMessage;

    @FindBy(linkText = "Register")
    WebElement registerLink;

    

    public void enterUsername(String username) {

        txtUsername.clear();
        txtUsername.sendKeys(username);
    }

    public void enterPassword(String password) {

        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void clickLoginButton() {

        btnLogin.click();
    }

    public String getErrorMessage() {

        return errorMessage.getText();
    }

    public void clickRegisterLink() {

        registerLink.click();
    }

    

    public boolean verifyUsernameTextbox() {

        return txtUsername.isDisplayed();
    }

    public boolean verifyPasswordTextbox() {

        return txtPassword.isDisplayed();
    }

    public boolean verifyLoginButton() {

        return btnLogin.isDisplayed();
    }

    public boolean verifyRegisterLink() {

        return registerLink.isDisplayed();
    }

    public void loginToApplication(String username,
                                   String password) {

        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
    
}