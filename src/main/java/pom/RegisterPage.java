package pom;

import org.openqa.selenium.WebDriver;

/**
 * Created by Hmayak Atayan on  13, Jun, 2020
 */
public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver, String serverUrl) {
        super(driver, serverUrl, "/mercuryregister.php");
    }
}
