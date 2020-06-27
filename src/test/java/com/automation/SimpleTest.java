package com.automation;

import helpers.Config;
import helpers.DriverSetup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;
import pom.RegisterPage;

/**
 * Created by Hmayak Atayan on  13, Jun, 2020
 */
public class SimpleTest extends BaseTest {

    @Test ()
    public void simpleLogin() {
        LoginPage loginPage = new LoginPage(DriverSetup.getDriver(), Config.getConfig("serverUrl"));
        RegisterPage registerPage = new RegisterPage(DriverSetup.getDriver(), Config.getConfig("serverUrl"));

        loginPage.get();
        loginPage.clickOnRegisterLinkText();
        loginPage.scrollDown();

        Assert.assertTrue(registerPage.isOnPage());

    }
}
