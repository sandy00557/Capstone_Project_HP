package com.ecommerce.tests;

import com.ecommerce.pages.RegisterPage;
import com.ecommerce.utils.ScreenshotUtils;
import com.ecommerce.utils.TestListener;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(TestListener.class)
public class RegisterTest extends BaseTest {

    private static final Logger Log = Logger.getLogger(RegisterTest.class);

    String firstnameValue;
    String lastnameValue;
    String emailValue;
    String passwordValue;
    String telephoneValue;

    public RegisterTest() throws IOException {}

    @BeforeMethod(alwaysRun = true)
    public void registerSetup() {
        driver.get(config.getAppUrl());
        Log.info("Navigated to URL: " + config.getAppUrl());

        firstnameValue = config.getFirstName();
        lastnameValue = config.getLastName();
        emailValue = config.getEmail();
//        emailValue="santhossk45676@gmail.com";
        passwordValue = config.getUserPassword();
        telephoneValue = config.getTelephone();

        Log.info("Test data loaded: FirstName=" + firstnameValue + ", Email=" + emailValue);
    }

    @Test(priority = 1)
    public void validRegister() {
        Log.info("Starting Valid Registration Test");

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.enterFirstName(firstnameValue);
        ScreenshotUtils.takeScreenshot(driver, "Step_01_FirstName_Register");

        registerPage.enterLastName(lastnameValue);
        ScreenshotUtils.takeScreenshot(driver, "Step_02_LastName_Register");

        registerPage.enterEmail(emailValue);
        ScreenshotUtils.takeScreenshot(driver, "Step_03_Email_Register");

        registerPage.enterTelephone(telephoneValue);
        ScreenshotUtils.takeScreenshot(driver, "Step_04_Telephone_Register");

        registerPage.enterPassword(passwordValue);
        registerPage.enterPasswordConfirm(passwordValue);
        registerPage.clickAgree();
        registerPage.clickContinue();

        ScreenshotUtils.takeScreenshot(driver, "Step_05_After_Submit_Register");

        String actualTitle = driver.getTitle();
        Log.info("Page Title after registration: " + actualTitle);


        // ❌ Intentional failure for practice
        Log.warn("Intentional Failure: Asserting incorrect title for demo purposes.");
        Assert.assertTrue(actualTitle.contains("Wrong Title"), "Intentional Assertion Failure");

        Log.info("Valid Registration Test Completed");
    }

    @Test(priority = 2)
    public void invalidRegister() {
        Log.info("Starting Invalid Registration Test");

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerUser(firstnameValue, lastnameValue, emailValue, "", passwordValue);

        ScreenshotUtils.takeScreenshot(driver, "Invalid_Telephone_Register");

        boolean errorPresent = driver.getPageSource().contains("Telephone must be");

        Log.info("Error Message Found: " + errorPresent);
        Assert.assertTrue(errorPresent, "Expected error message not found for missing telephone");

        Log.info("Invalid Registration Test Completed");
    }
}

