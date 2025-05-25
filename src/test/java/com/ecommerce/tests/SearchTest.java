package com.ecommerce.tests;

import com.ecommerce.pages.Helper;
import com.ecommerce.pages.SearchPage;
import com.ecommerce.utils.ScreenshotUtils;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchTest extends BaseTest {

    public SearchTest() throws IOException {
    }

    @Test
    public void Searching() throws InterruptedException {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/account");
        ScreenshotUtils.takeScreenshot(driver, "01_PageLoaded_Search");
        Log.info("Launch Browser");

        Actions actions = new Actions(driver);
        SearchPage search = new SearchPage(driver, actions);

        search.click("allcategories");
        ScreenshotUtils.takeScreenshot(driver, "02_AllCategoriesClicked_Search");

        Log.info("All Categories Clicked");
        search.click("Search");
        search.click("Apple");
        ScreenshotUtils.takeScreenshot(driver, "03_AppleFilterApplied_Search");
        Log.info("Apple Clicked");
        Thread.sleep(5000);
        search.enterKeys("CinemaValue", "Cinema");
        search.pressEnter("CinemaValue");
        ScreenshotUtils.takeScreenshot(driver, "04_CinemaSearch_Search");
        Log.info("Cinema Value Entered");



        search.click("Blue");
        System.out.println("Blue Clicked");
        ScreenshotUtils.takeScreenshot(driver, "05_BlueFilter_Search");
        Log.info("Blue Color Clicked");

        search.click("InStock");
        System.out.println("Instock clicked");
        ScreenshotUtils.takeScreenshot(driver, "06_InStockFilter_Search");

        Helper.scrollByPixels(driver, 0, 300);
        Thread.sleep(5000);

        String hoverXpath = "//*[@id=\"mz-product-grid-image-42-212469\"]/div/div[1]/img";
        String clickXpath = "//*[@id=\"entry_212469\"]/div/div/div/div[1]/div[2]/button[1]/i";
        search.hoverAndClick(hoverXpath, clickXpath);
        ScreenshotUtils.takeScreenshot(driver, "07_HoverAddToCart_Search");

        System.out.println("Hovered and clicked Add to Cart");

        Helper.scrollByPixels(driver, 0, 400);

        search.click("Select");
        search.click("SelectMedium");
        ScreenshotUtils.takeScreenshot(driver, "08_SizeMediumSelected_Search");

        search.click("AddToCart");
        ScreenshotUtils.takeScreenshot(driver, "09_FinalAddToCart_Search");
    }
}

