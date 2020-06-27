package com.automation;

import helpers.Config;
import helpers.DriverSetup;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

/**
 * Created by Hmayak Atayan on  27, Jun, 2020
 */
public class BaseTest {
    private static final String SCREENSHOT_DIR = "target/screenshots";
    final private Logger LOGGER = LoggerFactory.getLogger(getClass());
//    WebDriver driver;

    @BeforeClass
    public void setupBase() {
        DriverSetup.initDriver();
        DriverSetup.getDriver().get(Config.getConfig("serverUrl"));
    }

    @AfterClass
    public void tearDown() {
        quitDriver();
    }


    private void quitDriver() {
        DriverSetup.getDriver().quit();
    }

    @AfterMethod
    public void screenshotListener(ITestResult testResult) {
        String fullTestName = testResult.getClass().getName() + "." + testResult.getName();
        if (testResult.isSuccess()) {
            LOGGER.info("===== {} test has passed =====", fullTestName);

        } else {
            LOGGER.info("===== {} test has failed =====", fullTestName);
            File screenshotFile = ((TakesScreenshot) DriverSetup.getDriver()).getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(screenshotFile, new File(SCREENSHOT_DIR + fullTestName + ".png"));
                LOGGER.info("===== Screenshot is added in /{} =====", SCREENSHOT_DIR);

            } catch (IOException e) {
                LOGGER.info(e.getMessage());

            }
        }

    }
}
