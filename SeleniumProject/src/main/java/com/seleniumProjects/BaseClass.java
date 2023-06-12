package com.seleniumProjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;
    @BeforeTest
    public void initialization(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
//        driver.get("https://facebook.com/");
    //    driver.get("https://demoqa.com/buttons");
      //  driver.get("https://www.guru99.com/use-autoit-selenium.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
