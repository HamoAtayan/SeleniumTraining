package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Hmayak Atayan on  13, Jun, 2020
 */
public class LoginPage extends BasePage {

    @FindBy(css = "input[name='userName']")
    private WebElement userName;

   	By uername = By.cssSelector("input[name='userName']");


    @FindBy(css = "a[href='mercurysignon.php']")
    private WebElement signOnButton;

    @FindBy(css = "input[name='login']")
    private WebElement loginButton;

    @FindBy(css = "input[type='password']")
    private WebElement password;

    @FindBy(xpath = "//a[text()='REGISTER']")
    private WebElement registerLinkText;

    public LoginPage(WebDriver driver, String serverUrl) {
        super(driver, serverUrl, "/");
    }

    public void setUserName(String userName) {
        this.userName.sendKeys(userName);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickOnRegisterLinkText() {
        waitForElementToBeClickable(getDriver(), registerLinkText);
        registerLinkText.click();
    }

    @Override
    protected void load() {
        super.load();
        waitUntilPageLoads(getDriver(), 10);
    }

   public boolean isPasswordEnabled(){
        try {
            password.isDisplayed();
            return true;
        }
        catch (NoSuchElementException exception){
            return false;
        }
   }
}
