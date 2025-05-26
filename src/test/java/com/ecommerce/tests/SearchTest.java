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

        search.click("AllCategories");
        search.click("Desktop");
        ScreenshotUtils.takeScreenshot(driver, "02_Desktop_Search");

        Log.info("Desktop Clicked");

        search.enterKeys("Apple Cinema","Apple Cinema");

        search.click("SearchIcon");

        search.enterKeys("MinimumPrice","120");
        search.enterKeys("MaximumPrice","125");

        ScreenshotUtils.takeScreenshot(driver,"03_Price_Range_Search");
        search.click("SearchNew");
        Helper.scrollByPixels(driver,0,300);
        search.click("ProductClick");
        Log.info("Product Clicked");

        ScreenshotUtils.takeScreenshot(driver, "04_Product_Search");

        Helper.scrollByPixels(driver, 0, 300);

        Thread.sleep(5000);
        search.click("Select");
        search.click("SelectMedium");
        ScreenshotUtils.takeScreenshot(driver, "05_SizeMediumSelected_Search");

        search.click("AddToCart");
        ScreenshotUtils.takeScreenshot(driver, "06_FinalAddToCart_Search");
    }
}

