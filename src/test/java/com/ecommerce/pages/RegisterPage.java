//package com.ecommerce.pages;
//
//import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//public class RegisterPage {
//    private WebDriver driver;
//    private static final Logger Log = Logger.getLogger(RegisterPage.class);
//
//    public RegisterPage(WebDriver driver){
//        this.driver = driver;
//    }
//
//    private By firstName = By.id("input-firstname");
//    private By lastName = By.id("input-lastname");
//    private By email = By.id("input-email");
//    private By telephone = By.id("input-telephone");
//    private By password = By.id("input-password");
//    private By passwordConfirm = By.id("input-confirm");
//    private By agreeCheckbox = By.xpath("/html[1]/body[1]/div[1]/div[5]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/label[1]");
//    private By continueButton = By.xpath("//input[@value='Continue']");
//
//    public void enterFirstName(String fname) {
//        Log.info("Enter First Name: " + fname);
//        driver.findElement(firstName).sendKeys(fname);
//    }
//
//    public void enterLastName(String lname) {
//        Log.info("Enter Last Name: " + lname);
//        driver.findElement(lastName).sendKeys(lname);
//    }
//
//    public void enterEmail(String emailValue) {
//        Log.info("Enter Email: " + emailValue);
//        driver.findElement(email).sendKeys(emailValue);
//    }
//
//    public void enterTelephone(String phone) {
//        Log.info("Enter Telephone: " + phone);
//        driver.findElement(telephone).sendKeys(phone);
//    }
//
//    public void enterPassword(String pwd) {
//        Log.info("Enter Password");
//        driver.findElement(password).sendKeys(pwd);
//    }
//
//    public void enterPasswordConfirm(String pwd) {
//        Log.info("Confirm Password");
//        driver.findElement(passwordConfirm).sendKeys(pwd);
//    }
//
//    public void clickAgree() {
//        Log.info("Click Agree checkbox");
//        driver.findElement(agreeCheckbox).click();
//    }
//
//    public void clickContinue() {
//        Log.info("Click Continue button");
//        driver.findElement(continueButton).click();
//    }
//
//    public void registerUser(String fname, String lname, String emailVal, String phone, String pwd) {
//        enterFirstName(fname);
//        enterLastName(lname);
//        enterEmail(emailVal);
//        enterTelephone(phone);
//        enterPassword(pwd);
//        enterPasswordConfirm(pwd);
//        clickAgree();
//        clickContinue();
//    }
//}



package com.ecommerce.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    private WebDriver driver;
    private static final Logger Log = Logger.getLogger(RegisterPage.class);

    // Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators using @FindBy
    @FindBy(id = "input-firstname")
    private WebElement firstName;

    @FindBy(id = "input-lastname")
    private WebElement lastName;

    @FindBy(id = "input-email")
    private WebElement email;

    @FindBy(id = "input-telephone")
    private WebElement telephone;

    @FindBy(id = "input-password")
    private WebElement password;

    @FindBy(id = "input-confirm")
    private WebElement passwordConfirm;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[5]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/label[1]")
    private WebElement agreeCheckbox;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;

    // Action methods
    public void enterFirstName(String fname) {
        Log.info("Enter First Name: " + fname);
        firstName.sendKeys(fname);
    }

    public void enterLastName(String lname) {
        Log.info("Enter Last Name: " + lname);
        lastName.sendKeys(lname);
    }

    public void enterEmail(String emailVal) {
        Log.info("Enter Email: " + emailVal);
        email.sendKeys(emailVal);
    }

    public void enterTelephone(String phone) {
        Log.info("Enter Telephone: " + phone);
        telephone.sendKeys(phone);
    }

    public void enterPassword(String pwd) {
        Log.info("Enter Password");
        password.sendKeys(pwd);
    }

    public void enterPasswordConfirm(String pwd) {
        Log.info("Confirm Password");
        passwordConfirm.sendKeys(pwd);
    }

    public void clickAgree() {
        Log.info("Click Agree checkbox");
        agreeCheckbox.click();
    }

    public void clickContinue() {
        Log.info("Click Continue button");
        continueButton.click();
    }

    // Combined method
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

