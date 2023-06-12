package com.seleniumTesting;

import com.seleniumProjects.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class FaceBookLoginTest extends BaseClass {

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver.get("https://facebook.com/");
        Thread.sleep(1000);
    }
    @Test
    public void faceBookLogin_Success() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.findElement(By.id("email")).sendKeys("abhishek14kanojia@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Abhi@2000");
        WebElement loginBtn = driver.findElement(By.name("login"));
        js.executeScript("arguments[0].click()",loginBtn);
        Thread.sleep(2000);

        String homeTitle = driver.getTitle();
        Assert.assertEquals("Facebook", homeTitle);
        Thread.sleep(1000);

//        js.executeScript("window.scrollBy(0,500)");
//        Thread.sleep(1000);//down
//        js.executeScript("window.scrollBy(0,-500)");
//        Thread.sleep(1000);//up

        js.executeScript("alert('Logged in successfully');");
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

    }

    @Test
    public void photoUploadFacebook_AutoIT() throws InterruptedException, IOException {

        WebElement choosePhoto = driver.findElement(By.xpath("//span[contains(text(),'Photo/video')]"));
        choosePhoto.click();
        WebElement choosePhoto1 = driver.findElement(By.xpath("//span[@class='x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x1lliihq x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x xudqn12 x676frb x1lkfr7t x1lbecb7 xk50ysn xzsf02u']"));
        choosePhoto1.click();
        Thread.sleep(1000);
        Runtime.getRuntime().exec("C:\\Users\\Asus\\OneDrive\\Documents\\autoIT\\facebookPhoto.exe");
        Thread.sleep(5000);
        System.out.println("Photo Successfully uploaded ..");

    }


}
