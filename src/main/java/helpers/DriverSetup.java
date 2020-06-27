package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Hmayak Atayan on  27, Jun, 2020
 */
public class DriverSetup {
    private static WebDriver driver;

    public static void initDriver() {
        String browser = Config.getConfig("driver");
        switch (browser) {
            case "chrome": {
                if (driver == null) {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
                    break;
                }
            }
            case "firefox": {
                if (driver == null) {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
                }
            }
            default: {
                if (driver == null) {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
                    break;
                }
            }
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    private DriverSetup() {
        throw  new UnsupportedOperationException("unable to create instance of this object");
    }
}
