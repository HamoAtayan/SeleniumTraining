package pom;

import helpers.ComponentHelper;
import helpers.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

/**
 * Created by Hmayak Atayan on  13, Jun, 2020
 */
public class BasePage extends LoadableComponent<BasePage> implements WaitHelpers, ComponentHelper {
    private final WebDriver driver;
    private final String serverUrl;
    private final String pagePath;

    public BasePage(WebDriver driver, String serverUrl, String pagePath) {
        this.driver = driver;
        this.serverUrl = serverUrl;
        this.pagePath = pagePath;

        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        driver.get(serverUrl + pagePath);//facebook.com/Login
    }

    @Override
    public void isLoaded() throws Error {
        assert isOnPage();
    }

    public boolean isOnPage() {
        return driver.getCurrentUrl().contains(serverUrl + pagePath);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
