package com.seleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestngReportsExample {

    @Test
    public void testNGReports() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Reporter.log("Chrome browser opened...");
        driver.get("https://www.google.com");
        Reporter.log("Google URL opened...");

        WebElement webElement = driver.findElement(By.name("q"));
        webElement.sendKeys("SidhuMoosewala");
        Reporter.log("SidhuMoosewala Keyword entered...");

        webElement.sendKeys(Keys.ENTER);
        Reporter.log("Enter key pressed...");

        Thread.sleep(3000);
        driver.quit();


    }

}
