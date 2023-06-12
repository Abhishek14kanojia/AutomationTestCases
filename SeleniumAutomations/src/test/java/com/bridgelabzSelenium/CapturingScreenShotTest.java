package com.bridgelabzSelenium;

import com.automationTestings.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class CapturingScreenShotTest extends BaseClass {

    @Test
    public void screenShot() throws IOException {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("abhishek14kanojia@gmail.com");
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File("./ScreenShot/"+"fb"+".png");
        FileHandler.copy(file,destination);
        driver.close();
    }

}
