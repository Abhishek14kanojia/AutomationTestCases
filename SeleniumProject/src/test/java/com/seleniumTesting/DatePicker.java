package com.seleniumTesting;

import com.seleniumProjects.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DatePicker extends BaseClass {

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/");
        Thread.sleep(1000);
    }

    @Test
    public void enterDateAndTime() throws InterruptedException {
        WebElement dateCalender = driver.findElement(By.name("bdaytime"));
        dateCalender.sendKeys("03282023");
        Thread.sleep(1000);
        dateCalender.sendKeys(Keys.TAB);
        dateCalender.sendKeys("1252am");
        Thread.sleep(1000);

    }

}
