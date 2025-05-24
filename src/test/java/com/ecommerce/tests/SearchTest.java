package com.ecommerce.tests;

import com.ecommerce.pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.event.KeyEvent;
import java.io.IOException;

public class SearchTest extends BaseTest{

    public SearchTest() throws IOException {
    }


    @Test
    public void Searching() throws InterruptedException {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/account");

        Actions actions=new Actions(driver);

        SearchPage search=new SearchPage(driver,actions);
        search.click("allcategories");
//        search.click("Phones & PDAs");
        search.click("Search");
        search.click("Apple");
        Thread.sleep(5000);
        search.enterKeys("CinemaValue","Cinema");
        search.pressEnter("CinemaValue");
        System.out.println("Cinema Value Entered");
        search.click("Blue");
        System.out.println("Blue Clicked");
        search.click("InStock");
        System.out.println("Instock clicked");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)"); // Scroll down 500 pixels
        Thread.sleep(5000);

        String hoverXpath = "//*[@id=\"mz-product-grid-image-42-212469\"]/div/div[1]/img";
        String clickXpath = "//*[@id=\"entry_212469\"]/div/div/div/div[1]/div[2]/button[1]/i";
        search.hoverAndClick(hoverXpath, clickXpath);
        System.out.println("Hovered and clicked Add to Cart");




    }
}
