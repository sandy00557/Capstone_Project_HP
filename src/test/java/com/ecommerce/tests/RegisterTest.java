package com.ecommerce.tests;
import com.ecommerce.pages.RegisterPage;
import com.ecommerce.utils.ScreenshotUtils;
import com.ecommerce.utils.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(TestListener.class)
public class RegisterTest extends BaseTest {

    String firstnameValue;
    String lastnameValue;
    String emailValue;
    String passwordValue;
    String telephoneValue;

    public RegisterTest() throws IOException {}


    @BeforeMethod(alwaysRun = true)
    public void registerSetup()
    {
        driver.get(config.getAppUrl());
        firstnameValue = config.getFirstName();
        lastnameValue = config.getLastName();
        emailValue = config.getEmail();
        passwordValue = config.getUserPassword();
        telephoneValue = config.getTelephone();
    }



    @Test(priority = 1)
    public void validRegister() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerUser(firstnameValue, lastnameValue, emailValue, telephoneValue, passwordValue);

        ScreenshotUtils.takeScreenshot(driver, "Screenshot_User_Details");

        Assert.assertTrue(driver.getTitle().contains("Your Account Has Been Created"), "Registration failed");
    }


    @Test(priority = 2)
    public void invalidRegister(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerUser(firstnameValue, lastnameValue, emailValue, "", passwordValue);

        ScreenshotUtils.takeScreenshot(driver, "Screenshot_User_Details");

        Assert.assertTrue(driver.getPageSource().contains("Telephone must be"), "Registration failed");

    }
}

