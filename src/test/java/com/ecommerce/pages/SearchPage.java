package com.ecommerce.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class SearchPage {
    private WebDriver driver;
    private Actions actions;
    private static final Logger Log = Logger.getLogger(SearchPage.class);
    public SearchPage(WebDriver driver,Actions actions){
        this.driver = driver;
        this.actions=actions;
    }

    private By AllCategories=By.xpath("/html[1]/body[1]/div[1]/div[5]/header[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/button[1]");
//    private By Laptop=By.xpath("//a[text()='Laptops' and @data-category_id='18']");
    private By Search=By.xpath("//button[@class='type-text']");
    private By Apple=By.xpath("//*[@id=\"mz-filter-panel-0-1\"]/div/div[1]/div/label");
    private By CinemaValue=By.xpath("//*[@id='mz-filter-panel-0-2']/div/input");
    private By Blue=By.xpath("//*[@id=\"mz-filter-panel-0-3\"]/div/div[1]/div/label");
    private By InStock=By.xpath("//*[@id=\"mz-filter-panel-0-4\"]/div/div[1]/div/label");
//    public void clickAllCategories(){
//        driver.findElement(AllCategories).click();
//    }
//
//    public void clickLaptop()
//    {
//        driver.findElement(Laptop).click();
//    }

    public void click(String elementName) {
        By locator;

        switch(elementName.toLowerCase()) {
            case "allcategories":
                locator = AllCategories;
                break;
            case "search":
                locator=Search;
                break;
            case "apple":
                locator=Apple;
                break;
            case "blue":
                locator=Blue;
                break;
            case "instock":
                locator=InStock;
                break;
            default:
                throw new IllegalArgumentException("No such element defined: " + elementName);
        }

        driver.findElement(locator).click();
        Log.info("Clicked on: " + elementName);
    }

    public void enterKeys(String elementEnter,String keys)
    {
        By locatorz;
        switch(elementEnter.toLowerCase()){
            case "cinemavalue":
                locatorz=CinemaValue;
                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400)"); // Scroll down 500 pixels
                break;
            default:
                throw new IllegalArgumentException("No such element defined: " + elementEnter);


        }
        driver.findElement(locatorz).sendKeys(keys);
        Log.info("Clicked on: " + elementEnter);

    }

    public void pressEnter(String elementName) {
        By locator;
        switch (elementName.toLowerCase()) {
            case "cinemavalue":
                locator = CinemaValue;
                break;
            default:
                throw new IllegalArgumentException("No such element defined: " + elementName);
        }

        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    public void hoverAndClick(String hoverElementXpath, String clickElementXpath) {
        WebElement hoverElement = driver.findElement(By.xpath(hoverElementXpath));
        WebElement clickElement = driver.findElement(By.xpath(clickElementXpath));
        actions.moveToElement(hoverElement).moveToElement(clickElement).click().perform();
        Log.info("Hovered over element and clicked target element");
    }


}
