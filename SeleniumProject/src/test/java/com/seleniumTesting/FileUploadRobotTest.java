package com.seleniumTesting;

import com.seleniumProjects.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static com.seleniumProjects.BaseClass.driver;

public class FileUploadRobotTest extends BaseClass {

    @Test
    public void uploadFiles() throws AWTException {
        driver.get("https://www.foundit.in/seeker/registration");

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_UP);

        StringSelection selection = new StringSelection("\"C:\\Users\\Asus\\Downloads\\Abhishek's Resume (2).pdf\"");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        WebElement webElement1 = driver.findElement(By.xpath("//*[@id=\"registerThemeDefault\"]/div/div[4]/div/div/div/form/div[1]/div[2]/div/div/div[1]/div/label/span"));
        webElement1.click();

        robot.delay(1000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.delay(1000);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(1000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        driver.findElement(By.name("fullname")).sendKeys("Abhishek");
        robot.delay(1000);

        driver.findElement(By.name("email")).sendKeys("abhishek@gmail.com");
        robot.delay(1000);


        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.delay(2000);

        driver.findElement(By.name("Password")).sendKeys("Abhishek@123");
        robot.delay(1000);

        driver.findElement(By.name("Mobile Number")).sendKeys("9846522600");
        robot.delay(3000);

//        driver.findElement(By.name("location")).sendKeys("Ujjain");
//        robot.delay(3000);
//
//        driver.findElement(By.className("modal-ref-class")).sendKeys("Mumbai");
//        robot.delay(3000);
//
//          driver.findElement(By.cssSelector(".multiselect__single.modal-ref-class.textWrapperBold")).sendKeys("Mumbai");
//          robot.delay(3000);
        driver.close();

//          driver.findElement(By.xpath("//span[@class='multiselect__single modal-ref-class textWrapperBold']")).sendKeys("Ujjain");
//          robot.delay(3000);

//        driver.findElement(By.xpath("//*[@id=\"registerThemeDefault\"]/div/div[4]/div/div/div/form/div[2]/div[7]/div/div/div/div/div/div[2]/span")).sendKeys("Fresher");
//        robot.delay(1000);
//
//        driver.findElement(By.xpath("//*[@id=\"registerThemeDefault\"]/div/div[4]/div/div/div/form/div[3]/div[1]/div[1]/div/div/div[1]")).sendKeys("Selenium Web");
//        robot.delay(1000);
//
//        driver.findElement(By.xpath("//*[@id=\"registerThemeDefault\"]/div/div[4]/div/div/div/form/div[3]/div[2]/div[2]/div[1]/div/div[2]")).sendKeys("IT/Computers - Software");
//        robot.delay(1000);
//
//        driver.findElement(By.xpath("//*[@id=\"registerThemeDefault\"]/div/div[4]/div/div/div/form/div[3]/div[3]/div[2]/div[1]/div/div[2]/span")).sendKeys("IT");
//        robot.delay(1000);

    }


}
