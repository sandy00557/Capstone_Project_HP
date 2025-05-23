package com.ecommerce.tests;

import com.ecommerce.utils.ConfigReader;
import com.ecommerce.utils.TestListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    Logger Log;
    ConfigReader config=new ConfigReader();

    public BaseTest() throws IOException {
    }


    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser){
//        ChromeOptions option=new ChromeOptions();

//        driver=new ChromeDriver(option);
        Log=Logger.getLogger("Ecommerce Application");
        Log.info("-------Launch Browser-------------");
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
        boolean isHeadless = config.isHeadless();
        ChromeOptions options=new ChromeOptions();
        if (browser.equalsIgnoreCase("chrome")) {
            if (isHeadless) {
                options.addArguments("--headless=new"); // Use "--headless" if using older Chrome
                options.addArguments("--window-size=1920,1080");
            }
            driver = new ChromeDriver(options);
        }
        else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
