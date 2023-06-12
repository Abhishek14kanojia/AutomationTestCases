package com.seleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.client5.http.utils.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EncodePasswordEX {

    public static void main(String[] args) {

//        String password = "admin123";
//
//       byte [] encodedPassword = Base64.encodeBase64(password.getBytes());
//        System.out.println(new String(encodedPassword));

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin");
        byte [] decodePassword = Base64.decodeBase64("YWRtaW4xMjM=");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys(new String(decodePassword));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
    }

}
