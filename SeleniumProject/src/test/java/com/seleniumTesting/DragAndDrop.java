package com.seleniumTesting;

import com.seleniumProjects.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDrop extends BaseClass {
    
    @BeforeTest
    public void setUps() throws InterruptedException {
//        initializationTest();
        driver.get("https://jqueryui.com/droppable/");
        Thread.sleep(2000);
    }


    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/iframe")));
        WebElement dragElement = driver.findElement(By.id("draggable"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(dragElement).perform();

        WebElement dropElement = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(dragElement,dropElement).perform();
        Thread.sleep(2000);
//        actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME);
//        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END);
//
        driver.switchTo().parentFrame();
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        Thread.sleep(1000);
        actions.keyUp(Keys.CONTROL).sendKeys(Keys.END).perform();
        Thread.sleep(1000);
    }

}
