package com.seleniumTesting;

import com.seleniumProjects.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class FindFrameJsExecutor extends BaseClass {

    @Test
    public void findingFrames_UsingJsExecutor() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer noOfFrames = Integer.parseInt(js.executeScript("return window.length").toString());
        System.out.println("Number of Frames : " + noOfFrames);


    }

}
