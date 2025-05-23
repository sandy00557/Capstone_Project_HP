package com.ecommerce.tests;

import com.ecommerce.utils.ScreenshotUtils;
import com.ecommerce.utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(TestListener.class)
public class Login extends BaseTest{
    String firstnameValue;
    String lastnameValue;
    String emailValue;
    String passwordValue;
    public Login() throws IOException {
    }

    @Test
    public void Register(){
        driver.get(config.getAppUrl());
        firstnameValue= config.getFirstName();
        lastnameValue= config.getLastName();
        emailValue=config.getEmail();
        passwordValue= config.getUserPassword();
        String telephoneValue=config.getTelephone();
        WebElement FirstName=driver.findElement(By.id("input-firstname"));
        WebElement LastName=driver.findElement(By.id("input-lastname"));
        WebElement Email=driver.findElement(By.id("input-email"));
        WebElement telephone=driver.findElement(By.id("input-telephone"));
        WebElement password=driver.findElement(By.id("input-password"));
        WebElement passwordConfirm=driver.findElement(By.id("input-confirm"));
        WebElement agree=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/label[1]"));
        WebElement Continue=driver.findElement(By.xpath("//input[@value='Continue']"));
        Log.info("Enter Username:"+firstnameValue);
        FirstName.sendKeys(firstnameValue);
        Log.info("Enter Lastname:"+lastnameValue);
        LastName.sendKeys(lastnameValue);
        Email.sendKeys(emailValue);
        telephone.sendKeys(telephoneValue);
        password.sendKeys(passwordValue);
        passwordConfirm.sendKeys(passwordValue);
        agree.click();
        ScreenshotUtils.takeScreenshot(driver,"Screenshot_User_Details");
        Continue.click();
        Assert.assertTrue(driver.getTitle().contains("Your Account Has Been Created"), "Registration failed");



    }

    @Test
    public void login()
    {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        WebElement Username=driver.findElement(By.id("input-email"));
        WebElement Password=driver.findElement(By.id("input-password"));
        WebElement login=driver.findElement(By.xpath("//input[@value='Login']"));
        Username.sendKeys(emailValue);
        Password.sendKeys(passwordValue);
        login.click();
        Assert.assertTrue(driver.getTitle().contains("My Account"),"Login failed.");




    }
}
