package com.bridgelabzSelenium;

import com.automationTestings.BaseClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyBoard_Operations extends BaseClass {

    @Test
    public void keyBoard_Operations() throws AWTException {
        driver.get("https://www.facebook.com/");
        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_N);
//        robot.keyRelease(KeyEvent.VK_N);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(3000);
        robot.mouseMove(1000, 1000);
        robot.delay(2000);
        robot.mouseWheel(5000);
        robot.delay(2000);
    }

}
