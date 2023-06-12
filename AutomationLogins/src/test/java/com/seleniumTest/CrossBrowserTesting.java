package com.seleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Locale;

public class CrossBrowserTesting {
    public static WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void launchBrowser(String browser){

        switch (browser.toLowerCase()) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "msedge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;
            default:
                driver = null;
                break;

        }

    }

    @Test
    public void crossBrowserTesting(){

        driver.get("https://www.google.com");
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);
    }

}
