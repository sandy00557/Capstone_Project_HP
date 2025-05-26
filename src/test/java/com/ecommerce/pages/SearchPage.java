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

    @FindBy(css="div[id='entry_217822'] button[type='button']")
    private WebElement AllCategories;

    @FindBy(css ="div[id='main-header'] a:nth-child(2)")
    private WebElement Desktop;

    @FindBy(css = "div[id='entry_217822'] input[placeholder='Search For Products']")
    private WebElement AppleCinema;

    @FindBy(css="button[class='type-text']")
    private WebElement SearchIcon;


    @FindBy(css = "div[id='mz-filter-panel-0-0'] input[placeholder='Minimum Price']")
    private WebElement MinimumPrice;

    @FindBy(css="div[id='mz-filter-panel-0-0'] input[placeholder='Maximum Price']")
    private WebElement MaximumPrice;

    @FindBy(xpath = "//input[@id='button-search']")
    private WebElement SearchNew;


    @FindBy(css = "a[id='mz-product-grid-image-42-212469'] div[class='carousel-item active'] img[title='Apple Cinema 30&quot;']")
    private WebElement ProductClick;

    @FindBy(css = "#input-option231-216836")
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
            case "desktop":
                element = Desktop;
                break;
            case "searchicon":
                element = SearchIcon;
                break;
            case "searchnew":
                element = SearchNew;
                break;
            case "productclick":
                element=ProductClick;
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
            case "apple cinema":
                element = AppleCinema;
//                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400)");
                break;
            case "minimumprice":
                element = MinimumPrice;
//                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400)");
                break;
            case "maximumprice":
                element = MaximumPrice;
//                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400)");
                break;
            default:
                throw new IllegalArgumentException("No such element defined: " + elementEnter);
        }

        element.sendKeys(keys);
        Log.info("Entered keys in: " + elementEnter + " → " + keys);
    }

//    public void pressEnter(String elementName) {
//        WebElement element;
//
//        switch (elementName.toLowerCase()) {
//            case "cinemavalue":
//                element = CinemaValue;
//                break;
//            default:
//                throw new IllegalArgumentException("No such element defined: " + elementName);
//        }
//
//        element.sendKeys(Keys.ENTER);
//        Log.info("Pressed ENTER on: " + elementName);
//    }

    public void hoverAndClick(String hoverElementXpath, String clickElementXpath) {
        WebElement hoverElement = driver.findElement(By.xpath(hoverElementXpath));
        WebElement clickElement = driver.findElement(By.xpath(clickElementXpath));
        actions.moveToElement(hoverElement).moveToElement(clickElement).click().perform();
        Log.info("Hovered over element: " + hoverElementXpath + " and clicked on: " + clickElementXpath);
    }
}

