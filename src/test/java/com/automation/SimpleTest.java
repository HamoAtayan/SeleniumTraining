package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.LoginPage;
import pom.RegisterPage;

/**
 * Created by Hmayak Atayan on  13, Jun, 2020
 */
public class SimpleTest {

    WebDriver driver;

    @BeforeClass
    void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test ()
    public void simpleLogin() {

        LoginPage loginPage = new LoginPage(driver, "http://newtours.demoaut.com");
        RegisterPage registerPage = new RegisterPage(driver, "http://newtours.demoaut.com");

        loginPage.get();
        loginPage.clickOnRegisterLinkText();

//        loginPage.scrollUp();
        loginPage.scrollDown();

//        loginPage.setUserName("a");
//        loginPage.setPassword("a");
//        loginPage.clickLoginButton();

        Assert.assertTrue(registerPage.isOnPage());

        driver.quit();


    }

}
