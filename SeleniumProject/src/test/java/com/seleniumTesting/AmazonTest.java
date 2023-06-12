package com.seleniumTesting;

import com.seleniumProjects.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AmazonTest extends BaseClass {

    @Test
    public void amazonTesting() throws InterruptedException {
        driver.get("https://www.amazon.in/");
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("watch");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]")).click();
        Thread.sleep(2000);
    }

    @Test
    public void byNameLocatorTest() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("hello");
        Thread.sleep(2000);
        driver.findElement(By.name("btnK")).click();
        Thread.sleep(2000);

    }

    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        Thread.sleep(2000);
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\Asus\\Downloads\\Abhishek's Resume (2).pdf");
        Thread.sleep(2000);
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(3000);
    }

}