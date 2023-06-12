package com.seleniumTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtendReportClass {

    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;

    @BeforeTest
    public void startReport() {
        htmlReporter = new ExtentSparkReporter("ExtentReportDemo.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        reports.setSystemInfo("Machine", "Test1");
        reports.setSystemInfo("Singer", "Punjab");
        reports.setSystemInfo("User", "Abhishek");
        reports.setSystemInfo("Browser", "Chrome");

        htmlReporter.config().setDocumentTitle("Extent Reporter Demo");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')' ");

    }

    @Test
    public void launchBrowser() {
        test = reports.createTest("Launch browser and open url..");
        Assert.assertTrue(true);
    }

    @Test
    public void verifyTitle() {
        test = reports.createTest("Verify Title..");
        Assert.assertTrue(false);
    }

    @Test
    public void verifyLogo() {
        test = reports.createTest("Verify Logo");
        Assert.assertTrue(true);
    }

    @Test
    public void verifyEmail() {
        test = reports.createTest("Verify Email");
        throw new SkipException("skipped this test case with exception..");
    }

    @Test
    public void verifyUsername() {
        test = reports.createTest("Verify Username");
        Assert.assertTrue(true);
    }

    @AfterMethod
    public void getTestResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAIL ", ExtentColor.RED));
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASS ", ExtentColor.GREEN));
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIP ", ExtentColor.BLUE));
        }
    }
    @AfterTest
    public void teatDown(){
        reports.flush();
    }

}
