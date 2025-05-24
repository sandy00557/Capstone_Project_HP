package com.ecommerce.tests;

import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.RegisterPage;
import com.ecommerce.utils.ScreenshotUtils;
import com.ecommerce.utils.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;



@Listeners(TestListener.class)
public class LoginTest extends BaseTest{
    String emailValue;
    String passwordValue;
    LoginPage loginPage;
    public LoginTest() throws IOException {
    }


    @BeforeMethod(alwaysRun = true) //this will help us not to skip the second BeforeMethod
    public void loginpageSetup() {
        // At this point, BaseTest's @BeforeMethod has already initialized the driver
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        loginPage = new LoginPage(driver);
        emailValue = config.getEmail();
        passwordValue = config.getUserPassword();
    }
//
//    @Test
//    public void Register(){
//        driver.get(config.getAppUrl());
//        firstnameValue= config.getFirstName();
//        lastnameValue= config.getLastName();
//        emailValue=config.getEmail();
//        passwordValue= config.getUserPassword();
//        telephoneValue=config.getTelephone();
////        WebElement FirstName=driver.findElement(By.id("input-firstname"));
////        WebElement LastName=driver.findElement(By.id("input-lastname"));
////        WebElement Email=driver.findElement(By.id("input-email"));
////        WebElement telephone=driver.findElement(By.id("input-telephone"));
////        WebElement password=driver.findElement(By.id("input-password"));
////        WebElement passwordConfirm=driver.findElement(By.id("input-confirm"));
////        WebElement agree=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/label[1]"));
////        WebElement Continue=driver.findElement(By.xpath("//input[@value='Continue']"));
////        Log.info("Enter Username:"+firstnameValue);
////        FirstName.sendKeys(firstnameValue);
////        Log.info("Enter Lastname:"+lastnameValue);
////        LastName.sendKeys(lastnameValue);
////        Email.sendKeys(emailValue);
////        telephone.sendKeys(telephoneValue);
////        password.sendKeys(passwordValue);
////        passwordConfirm.sendKeys(passwordValue);
////        agree.click();
//
//        RegisterPage registerPage=new RegisterPage(driver);
//        registerPage.registerUser(firstnameValue,lastnameValue,emailValue,telephoneValue,passwordValue);
//        ScreenshotUtils.takeScreenshot(driver,"Screenshot_User_Details");
////        Continue.click();
//        Assert.assertTrue(driver.getTitle().contains("Your Account Has Been Created"), "Registration failed");
//
//
//
//    }



    @Test(priority = 3)
    public void validLogin()
    {
//        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
//        WebElement Username=driver.findElement(By.id("input-email"));
//        WebElement Password=driver.findElement(By.id("input-password"));
//        WebElement login=driver.findElement(By.xpath("//input[@value='Login']"));
//        Username.sendKeys(emailValue);
//        Password.sendKeys(passwordValue);
//        login.click();
//        LoginPage loginPage=new LoginPage(driver);
//        emailValue=config.getEmail();
//        passwordValue= config.getUserPassword();
        loginPage.login(emailValue,passwordValue);
        Assert.assertTrue(driver.getTitle().contains("My Account"),"Login failed.");
    }


    @Test(priority = 1)
    public void invalidLogin()
    {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        loginPage.login("sk2493@gmail.com","aaradhana");
        Assert.assertTrue(driver.getPageSource().contains("Warning"),"It is valid Login");
    }

    @Test(priority = 2)
    public void emptyCredentials()
    {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        loginPage.login("","");
        Assert.assertTrue(driver.getPageSource().contains("Warning"),"It is valid Login");
    }
}
