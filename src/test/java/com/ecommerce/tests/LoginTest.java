package com.ecommerce.tests;

import com.ecommerce.pages.LoginPage;
import com.ecommerce.utils.ScreenshotUtils;
import com.ecommerce.utils.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
    String emailValue;
    String passwordValue;
    LoginPage loginPage;

    public LoginTest() throws IOException {}

    @BeforeMethod(alwaysRun = true)
    public void loginPageSetup() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        loginPage = new LoginPage(driver);
        emailValue = config.getEmail();
        passwordValue = config.getUserPassword();
    }

    @Test(priority = 3)
    public void validLogin() {
        System.out.println("🔐 Starting valid login test...");
        loginPage.login(emailValue, passwordValue);
        ScreenshotUtils.takeScreenshot(driver, "Valid_Login_Attempt_Login");

        // ❌ Intentionally incorrect assertion
        System.out.println("⚠️ Intentionally failing the test...");
        Assert.assertTrue(driver.getTitle().contains("Invalid Title Text"), "❌ Login test failed intentionally!");

        System.out.println("✅ Test passed.");
    }

    @Test(priority = 1)
    public void invalidLogin() {
        System.out.println("🔐 Starting invalid login test...");
        loginPage.login("wrong@email.com", "wrongpassword");
        Assert.assertTrue(driver.getPageSource().contains("Warning"), "❌ Expected warning message not found.");
        System.out.println("✅ Invalid login warning message displayed.");
    }

    @Test(priority = 2)
    public void emptyCredentials() {
        System.out.println("🔐 Starting empty credentials test...");
        loginPage.login("", "");
        Assert.assertTrue(driver.getPageSource().contains("Warning"), "❌ Warning not displayed for empty credentials.");
        System.out.println("✅ Warning shown for empty login attempt.");
    }
}

