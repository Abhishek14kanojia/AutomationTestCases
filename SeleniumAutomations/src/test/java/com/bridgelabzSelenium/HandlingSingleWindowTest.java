package com.bridgelabzSelenium;

import com.automationTestings.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class HandlingSingleWindowTest extends BaseClass {

    @Test
    public void getWindowHandle(){
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id("windowButton")).click();

        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent window address : " + parentWindow);

        Set<String> allWindow = driver.getWindowHandles();
        Iterator<String> iterator = allWindow.iterator();
        while (iterator.hasNext()){
            String childWindow = iterator.next();
            if (!parentWindow.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                driver.manage().window().fullscreen();
                String text = driver.findElement(By.id("sampleHeading")).getText();
                System.out.println("Text of child window : " + text);
            }
        }
            driver.switchTo().window(parentWindow);
    }

}
