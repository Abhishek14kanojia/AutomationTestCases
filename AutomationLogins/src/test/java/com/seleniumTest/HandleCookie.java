package com.seleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class HandleCookie {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        Set<Cookie> cookiesList = driver.manage().getCookies();

        System.out.println("size"+cookiesList.size());

        for (Cookie ck:cookiesList){
            System.out.println(ck.getName()+":"+ck.getValue());
        }
//            driver.quit();
    }

}
