package com.bridgelabzSelenium;

import com.automationTestings.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class FaceBookTesting extends BaseClass {

    @Test
    public void facebookTest() throws InterruptedException {
        driver.get("https://www.facebook.com");
        WebElement forgotPass = driver.findElement(By.linkText("Forgotten password?"));
        forgotPass.click();
//      driver.findElement(By.partialLinkText("Forgotten")).click();

        driver.navigate().back();

        System.out.println("Title of the application : " + driver.getTitle());
        System.out.println("Current URL of application : " + driver.getCurrentUrl());
        System.out.println("Page Source of the application : " + driver.getPageSource());

//		driver.getWindowHandle();
//		driver.getWindowHandles();

//		driver.findElement(By.id("email")).sendKeys("abhishek14kanojia@gmail.com");
//		Thread.sleep(2000);
//		driver.findElement(By.name("pass")).sendKeys("Abhi@2000");
//		Thread.sleep(2000);

        WebElement userName = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        userName.sendKeys("abhishek14kanojia@gmail.com");
        WebElement loginBtn = driver.findElement(By.name("login"));
        System.out.println(loginBtn.getText());

//		System.out.println(userName.getText());
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button"));
        Thread.sleep(2000);


        driver.quit();

    }

}
