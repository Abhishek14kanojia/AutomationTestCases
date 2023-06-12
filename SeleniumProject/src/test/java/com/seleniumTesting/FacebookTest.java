package com.seleniumTesting;

import com.seleniumProjects.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FacebookTest extends BaseClass {

    @Test
    public void facebookWebsite_RedirectOnScreen() {
        String fbLoginTitle = driver.getTitle();
        Assert.assertEquals("Facebook – log in or sign up", fbLoginTitle);

    }

    @Test
    public void facebookWebsite_CreateNewAccountTest() throws InterruptedException {
        Thread.sleep(500);
        WebElement createPopUp = driver.findElement(By.linkText("Create new account"));
        boolean flag = createPopUp.isDisplayed();
        Assert.assertEquals(true, flag);
        createPopUp.click();
        Thread.sleep(3000);

        driver.findElement(By.name("firstname")).sendKeys("Abhishek");
        Thread.sleep(1000);
        driver.findElement(By.name("lastname")).sendKeys("Kanojia");
        Thread.sleep(1000);
        driver.findElement(By.name("reg_email__")).sendKeys("321365465");
        Thread.sleep(1000);
        driver.findElement(By.name("reg_passwd__")).sendKeys("Asd@66456");
        Thread.sleep(1000);
        WebElement day = driver.findElement(By.id("day"));
        Select select = new Select(day);
        select.selectByValue("14");
        Thread.sleep(1000);
        WebElement month = driver.findElement(By.id("month"));
        Select select1 = new Select(month);
        select1.selectByIndex(8);
        Thread.sleep(1000);
        WebElement year = driver.findElement(By.id("year"));
        Select select2 = new Select(year);
        select2.selectByVisibleText("2000");
        Thread.sleep(1000);
        driver.findElements(By.name("sex")).get(1).click();
        Thread.sleep(1000);
        boolean flag1 = select.isMultiple();
        if (flag1) {
            System.out.println("Multiple selection in not allowed");
        }

    }

//    @Test
//    public void facebookWebsite_RadiobuttonTest() throws InterruptedException {
//        Thread.sleep(500);
//        WebElement createPopUp = driver.findElement(By.linkText("Create new account"));
//        boolean flag = createPopUp.isDisplayed();
//        Assert.assertEquals(true, flag);
//        createPopUp.click();
//        Thread.sleep(3000);
//
//        driver.findElements(By.name("sex")).get(1).click();
//    }
}