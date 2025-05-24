package com.ecommerce.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RegisterPage {
    private WebDriver driver;
    private static final Logger Log = Logger.getLogger(RegisterPage.class);

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By passwordConfirm = By.id("input-confirm");
    private By agreeCheckbox = By.xpath("/html[1]/body[1]/div[1]/div[5]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/label[1]");
    private By continueButton = By.xpath("//input[@value='Continue']");

    public void enterFirstName(String fname) {
        Log.info("Enter First Name: " + fname);
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        Log.info("Enter Last Name: " + lname);
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterEmail(String emailValue) {
        Log.info("Enter Email: " + emailValue);
        driver.findElement(email).sendKeys(emailValue);
    }

    public void enterTelephone(String phone) {
        Log.info("Enter Telephone: " + phone);
        driver.findElement(telephone).sendKeys(phone);
    }

    public void enterPassword(String pwd) {
        Log.info("Enter Password");
        driver.findElement(password).sendKeys(pwd);
    }

    public void enterPasswordConfirm(String pwd) {
        Log.info("Confirm Password");
        driver.findElement(passwordConfirm).sendKeys(pwd);
    }

    public void clickAgree() {
        Log.info("Click Agree checkbox");
        driver.findElement(agreeCheckbox).click();
    }

    public void clickContinue() {
        Log.info("Click Continue button");
        driver.findElement(continueButton).click();
    }

    public void registerUser(String fname, String lname, String emailVal, String phone, String pwd) {
        enterFirstName(fname);
        enterLastName(lname);
        enterEmail(emailVal);
        enterTelephone(phone);
        enterPassword(pwd);
        enterPasswordConfirm(pwd);
        clickAgree();
        clickContinue();
    }
}
