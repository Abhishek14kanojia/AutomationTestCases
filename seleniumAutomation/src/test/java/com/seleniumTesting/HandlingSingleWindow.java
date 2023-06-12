package com.seleniumTesting;

import com.seleniumAutomation.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class HandlingSingleWindow extends BaseClass {

    @Test
    public void getWindowHandle()  {

        driver.get("https://demoqa.com/browser-window");
        driver.findElement(By.id("windowButton")).click();

        String parentWindow = driver.getWindowHandle();
        System.out.println("parent window address : " + parentWindow);

        Set<String> allWindow = driver.getWindowHandles();
        Iterator<String> iterator = allWindow.iterator();
        while(iterator.hasNext()) {
            String childWindow = iterator.next();
            if(!parentWindow.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                driver.manage().window().fullscreen();
                String text = driver.findElement(By.id("sampleHeadling")).getText();
                System.out.println("Test of child window : " + text);
            }
        }

        driver.switchTo().window(parentWindow);
//        driver.switchTo().defaultContent();
//        driver.switchTo().parentFrame();
//        driver.close();
    }

}
