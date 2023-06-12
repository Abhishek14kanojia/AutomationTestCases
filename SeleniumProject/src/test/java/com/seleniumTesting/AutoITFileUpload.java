package com.seleniumTesting;

import com.seleniumProjects.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class AutoITFileUpload extends BaseClass {

    @BeforeTest
    public void setUp() throws InterruptedException {
//    driver.get("https://www.freepdfconvert.com/pdf-to-word");
    driver.get("https://demo.guru99.com/test/upload/");

    Thread.sleep(1000);
    }

    @Test
    public void fileUploadAutoIT() throws InterruptedException, IOException {
        WebElement chooseBtn = driver.findElement(By.xpath("//*[@id=\"top\"]/body/main/div[1]/div/div/div[2]/section/label/div/div[1]/a/span"));
        chooseBtn.click();
        Thread.sleep(1000);
        Runtime.getRuntime().exec("\"C:\\Users\\Asus\\OneDrive\\Documents\\autoIT\\guru99fileUpload.exe\"");
        Thread.sleep(1000);
        System.out.println("File Successfully uploaded....");

    }

    @Test
    public void fileUploadDemo() throws InterruptedException {
        WebElement chooseBtn1 = driver.findElement(By.name("uploadfile_0"));
        chooseBtn1.sendKeys("C:\\Users\\Asus\\Downloads\\Abhishek's Resume (2).pdf");
        Thread.sleep(2000);
        System.out.println("FileUpload Successfully..");

    }

}

