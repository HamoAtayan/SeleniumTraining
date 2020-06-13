package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by Hmayak Atayan on  13, Jun, 2020
 */
public interface ComponentHelper {
    WebDriver getDriver();

    default void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, -Math.max(document.documentElement.scrollHeight));");
    }

    default void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, Math.max(document.documentElement.scrollHeight));");
    }
}
