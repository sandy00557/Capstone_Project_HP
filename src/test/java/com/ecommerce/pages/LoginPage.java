package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By emailInput = By.id("input-email");
    private By passwordInput = By.id("input-password");
    private By loginButton = By.xpath("//input[@value='Login']");

    public void enterEmail(String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String pwd){
        driver.findElement(passwordInput).sendKeys(pwd);
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    // Convenience method to perform login
    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }
}
