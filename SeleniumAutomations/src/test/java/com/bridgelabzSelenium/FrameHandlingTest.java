package com.bridgelabzSelenium;

import com.automationTestings.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FrameHandlingTest extends BaseClass {

    @Test
    public void frameHandlingTest(){
        driver.get("https://demo.guru99.com/test/guru99home/");
        int size = driver.findElements(By.tagName("iframe")).size();

        for (int i = 0; i < size; i++) {
            driver.switchTo().frame(i);
            int size1 = driver.findElements(By.id("a077aa5e")).size();
            System.out.println("Switched !! " + size1);

            driver.findElement(By.xpath("/html/body/a/img")).click();
        }
    }
}
