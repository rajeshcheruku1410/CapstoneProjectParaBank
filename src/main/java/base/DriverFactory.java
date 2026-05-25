package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver initializeBrowser(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();

//            if (System.getProperty("headless", "false").equals("true")) {
//                options.addArguments("--headless");
//                options.addArguments("--no-sandbox");
//                options.addArguments("--disable-dev-shm-usage");
//            }
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless=new"); 
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.addArguments("--disable-extensions");
            chromeOptions.addArguments("--window-size=1920,1080");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--no-sandbox");           
            chromeOptions.addArguments("--disable-dev-shm-usage");

            driver = new ChromeDriver(chromeOptions);
        }
        else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        return driver;
    }
}