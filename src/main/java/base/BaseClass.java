package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;

public class BaseClass {

    public static WebDriver driver;

    public static void initDriver(String browser) {
        driver = DriverFactory.initializeBrowser(browser);
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
}