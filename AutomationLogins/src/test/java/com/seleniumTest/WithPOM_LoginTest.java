package com.seleniumTest;

import com.seleniumClass.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WithPOM_LoginTest{

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//        WithPOM withPOM = new WithPOM(driver);
        PageFactoryLoginPage pageFactoryLoginPage = new PageFactoryLoginPage(driver);
        driver.get("https://www.saucedemo.com/v1/");
        pageFactoryLoginPage.enterUsername("standard_user");
        pageFactoryLoginPage.enterPassword("secret_sauce");
        pageFactoryLoginPage.clickOnLoginBTN();
    }
}
