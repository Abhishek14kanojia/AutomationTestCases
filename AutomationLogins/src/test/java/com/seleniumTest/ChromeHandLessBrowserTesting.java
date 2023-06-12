package com.seleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeHandLessBrowserTesting {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");

        System.out.println("Before search :- " + driver.getTitle());

        WebElement webElement = driver.findElement(By.name("q"));
        webElement.sendKeys("SidhuMoosewala");
        webElement.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        System.out.println("After search :- " + driver.getTitle());

    }

}
