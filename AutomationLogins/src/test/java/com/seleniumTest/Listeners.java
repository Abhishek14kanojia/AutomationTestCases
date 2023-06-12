package com.seleniumTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.xml.transform.Result;

public class Listeners implements ITestListener {
    public void onStart(ITestContext context) {

        System.out.println("On Start method invoked");

    }

    public void onFinish(ITestContext context) {

        System.out.println("On Finish method invoked");

    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Name of test method failed : " + result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Name of test method skipped :  " + result.getName());
    }
    public void onTestStart(ITestResult result) {
        System.out.println("Name of test method start :  " + result.getName());
    }


    public void onTestSuccess(ITestResult result) {
        System.out.println("Name of test method successfully execute : " + result.getName());
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // not implemented
    }

}

