package com.ecommerce.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((com.ecommerce.tests.BaseTest) testClass).driver;
        String testName = result.getName();
        ScreenshotUtils.takeScreenshot(driver, testName);
    }
}
