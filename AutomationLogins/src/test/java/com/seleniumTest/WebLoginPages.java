package com.seleniumTest;

import com.beust.ah.A;
import com.seleniumClass.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

//@Listeners(com.seleniumTest.Listeners.class)
public class WebLoginPages {
    WebDriver driver;
    @BeforeMethod
    public void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        driver.get("https://www.google.com/");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();    }


    @Test
    public void instagramLoginPage() throws InterruptedException {
        driver.get("https://www.instagram.com/");
        driver.findElement(By.name("username")).sendKeys("abhishek14kanojia@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Tester@2000");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class='x9f619 xjbqb8w x78zum5 x168nmei x13lgxp2 x5pf9jr xo71vjh x1xmf6yo x1e56ztr x540dpk x1m39q7l x1n2onr6 x1plvlek xryxfnj x1c4vz4f x2lah0s xdt5ytf xqjyukv x1qjc9v5 x1oa3qoh x1nhvcw1'])[1]")).click();
        Thread.sleep(10000);
    }

    @Test
    public void facebookLoginPage() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("abhishek14kanojia@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Abhi@2000");
        Thread.sleep(2000);
        driver.findElement(By.name("login")).click();
        Thread.sleep(15000);
    }

    @Test()
    public void fileUploadPage() throws AWTException {
        driver.get("https://demoqa.com/upload-download");
//        driver.findElement(By.xpath("//input[@id='uploadFile']")).sendKeys("C:\\Users\\Asus\\Downloads\\Resume.pdf");
//        Thread.sleep(5000);

        WebElement button = driver.findElement(By.xpath("//input[@id='uploadFile']"));
        Actions act = new Actions(driver);
        act.moveToElement(button).click().perform();    //click action

        // Copy path , ctrl+v , Enter

        Robot rb = new Robot();
        rb.delay(2000);

        StringSelection ss = new StringSelection("C:\\Users\\Asus\\Downloads\\Resume.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
        //CONTROL + V
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.delay(2000);

        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.delay(2000);
        //ENTER
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.delay(5000);
    }
    @Test
    public void takeScreenShots() throws InterruptedException, IOException {
        driver.get("https://www.linkedin.com");
        driver.findElement(By.xpath("//input[@id='session_key']")).sendKeys("abhishek14kanojia@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='session_password']")).sendKeys("Abhi@2000");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
        Thread.sleep(5000);
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File("./ScreenShot/"+"LD"+".png");
        FileUtils.copyFile(file,destination);
        System.out.println("Take ScreenShot Successfully....");
    }

    @Test
    public void openNewTabOrWindow() throws InterruptedException {
        //Open URL
        driver.get("https://www.google.com");
        System.out.println("first page" + driver.getTitle());

        //Open New Tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");
        System.out.println("second tab" + driver.getTitle());
        Thread.sleep(2000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.naukri.com/");
        System.out.println("second tab" + driver.getTitle());
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.get("https://www.instagram.com");
        Thread.sleep(2000);
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.linkedin.com");
        Thread.sleep(2000);
        driver.switchTo().window(tabs.get(2));
        driver.get("https://www.irctc.com");
        Thread.sleep(2000);

        //Open New Window
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com/results?search_query=root+logger+selenium");
        System.out.println("second tab" + driver.getTitle());
        Thread.sleep(2000);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com/watch?v=JMJKrPScZfI&list=PLnNg6KqJ3HGh8K2KhCCxraHh09L3LPL4E&index=17");
        System.out.println("second tab" + driver.getTitle());
        Thread.sleep(2000);
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(0));
        driver.get("https://www.instagram.com");
        Thread.sleep(2000);
//        driver.quit();
    }

    @Test
    public void scrollWebPages() throws InterruptedException {
//        driver.get("https://www.calculator.net");
        driver.get("https://www.album.alexflueras.ro/galleries/black-and-white.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(4000);
//        js.executeScript("window.scrollBy(0,500)");  //Scroll vertically
//        Thread.sleep(2000);

        //web page by the visibility of the element
//        WebElement element = driver.findElement(By.xpath("//img[@alt='All Calculators']"));
//        js.executeScript("arguments[0].scrollIntoView();",element);
//        Thread.sleep(2000);

        //web page at the bottom of the page
//        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//a[@id='a5']//img"));
        js.executeScript("arguments[0].scrollIntoView();",element);
        Thread.sleep(2000);
    }

    @Test
    public void enterDataAndTime() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/");
        WebElement dataCalendar = driver.findElement(By.name("bdaytime"));
        dataCalendar.sendKeys(new CharSequence[]{"15092000"});
        Thread.sleep(2000);
        dataCalendar.sendKeys(new CharSequence[]{Keys.TAB});
        dataCalendar.sendKeys(new CharSequence[]{"0102PM"});
        Thread.sleep(4000);

    }

    @Test
    public void givenTestNGListener() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement testNG_UserName = driver.findElement(By.name("username"));
        testNG_UserName.sendKeys("Admin");
        WebElement testNGPassword = driver.findElement(By.name("password"));
        testNGPassword.sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
        Thread.sleep(4000);

    }

    @Test
    public void failedTestNGCase(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement testNG_UserName = driver.findElement(By.name("username"));
        testNG_UserName.sendKeys("Admin");
        WebElement testNGPassword = driver.findElement(By.name("password"));
        testNGPassword.sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        System.out.println("Failed Successfully");
        Assert.assertTrue(false);


    }
    @Test
    public void skippedTestNGCase(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement testNG_UserName = driver.findElement(By.name("username"));
        testNG_UserName.sendKeys("Admin");
        WebElement testNGPassword = driver.findElement(By.name("password"));
        testNGPassword.sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        throw new SkipException("Skip exception thrown...");
    }

    @Test
    public void assertionTestNGTest(){
        driver.get("https://testautomationpractice.blogspot.com/");
        System.out.println("Verify Title...");
        String expectedTitle = "Automation Testing Practice";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle, "Title verification failed");

        System.out.println("Verify Icon");
        WebElement icon = driver.findElement(By.xpath("//img[@class='wikipedia-icon']"));
        Assert.assertTrue(icon.isDisplayed());

        System.out.println("Verify searchBTN");
        WebElement searchBTN = driver.findElement(By.className("wikipedia-search-button"));
        Assert.assertTrue(searchBTN.isDisplayed());

    }

    @Test
    public void loggerDemo(){

        Logger logger = (Logger) LogManager.getLogger("WebLoginPages");
        System.out.println("Logger 1");

        logger.info("This is information message..");
        logger.error("This is error message...");
        logger.warn("This is warning message...");
        logger.fatal("This is fatal message...");

        System.out.println("Completed..");

    }

    //POM

    @Test
    public void loginWithoutPOM() throws InterruptedException {
        driver.get("https://www.saucedemo.com/v1/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

    }

    @Test
    public void crossBrowserTesting(){

        driver.get("https://www.google.com");
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);

        driver.quit();
    }


//    @AfterMethod
//    public void browserClose(){
//        teatDown();
//    }

}
