package com.ecommerce.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    private WebDriver driver;
    private Actions actions;
    private static final Logger Log = Logger.getLogger(SearchPage.class);

    public SearchPage(WebDriver driver, Actions actions) {
        this.driver = driver;
        this.actions = actions;
        PageFactory.initElements(driver, this);
        Log.info("SearchPage initialized.");
    }

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[5]/header[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/button[1]")
    private WebElement AllCategories;

    @FindBy(xpath = "//button[@class='type-text']")
    private WebElement Search;

    @FindBy(xpath = "//*[@id=\"mz-filter-panel-0-1\"]/div/div[1]/div/label")
    private WebElement Apple;

    @FindBy(xpath = "//*[@id='mz-filter-panel-0-2']/div/input")
    private WebElement CinemaValue;

    @FindBy(xpath = "//*[@id=\"mz-filter-panel-0-3\"]/div/div[1]/div/label")
    private WebElement Blue;

    @FindBy(xpath = "//*[@id=\"mz-filter-panel-0-4\"]/div/div[1]/div/label")
    private WebElement InStock;

    @FindBy(xpath = "//select[@id='input-option231-216836']")
    private WebElement Select;

    @FindBy(xpath = "//select[@id='input-option231-216836']/option[2]")
    private WebElement SelectMedium;

    @FindBy(xpath = "//*[@id=\"entry_216842\"]/button")
    private WebElement AddToCart;

    public void click(String elementName) {
        WebElement element;

        switch (elementName.toLowerCase()) {
            case "allcategories":
                element = AllCategories;
                break;
            case "search":
                element = Search;
                break;
            case "apple":
                element = Apple;
                break;
            case "blue":
                element = Blue;
                break;
            case "instock":
                element = InStock;
                break;
            case "select":
                element = Select;
                break;
            case "selectmedium":
                element = SelectMedium;
                break;
            case "addtocart":
                element = AddToCart;
                break;
            default:
                throw new IllegalArgumentException("No such element defined: " + elementName);
        }

        element.click();
        Log.info("Clicked on: " + elementName);
    }

    public void enterKeys(String elementEnter, String keys) {
        WebElement element;

        switch (elementEnter.toLowerCase()) {
            case "cinemavalue":
                element = CinemaValue;
                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400)");
                break;
            default:
                throw new IllegalArgumentException("No such element defined: " + elementEnter);
        }

        element.sendKeys(keys);
        Log.info("Entered keys in: " + elementEnter + " → " + keys);
    }

    public void pressEnter(String elementName) {
        WebElement element;

        switch (elementName.toLowerCase()) {
            case "cinemavalue":
                element = CinemaValue;
                break;
            default:
                throw new IllegalArgumentException("No such element defined: " + elementName);
        }

        element.sendKeys(Keys.ENTER);
        Log.info("Pressed ENTER on: " + elementName);
    }

    public void hoverAndClick(String hoverElementXpath, String clickElementXpath) {
        WebElement hoverElement = driver.findElement(By.xpath(hoverElementXpath));
        WebElement clickElement = driver.findElement(By.xpath(clickElementXpath));
        actions.moveToElement(hoverElement).moveToElement(clickElement).click().perform();
        Log.info("Hovered over element: " + hoverElementXpath + " and clicked on: " + clickElementXpath);
    }
}

