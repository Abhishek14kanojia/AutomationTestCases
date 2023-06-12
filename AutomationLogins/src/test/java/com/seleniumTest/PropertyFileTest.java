package com.seleniumTest;

import com.sun.security.auth.login.ConfigFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class PropertyFileTest {

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.facebook.com/");
        ReadConfigFile configFile = new ReadConfigFile();

        driver.get(configFile.getURL());

        driver.findElement(By.id("email")).sendKeys(configFile.getUsername());
        driver.findElement(By.id("pass")).sendKeys(configFile.getPassword());
        Thread.sleep(2000);
        driver.findElement(By.name("login")).click();
        Thread.sleep(15000);
    }
}
