package com.seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WithPOM {

    WebDriver driver;

    WithPOM(WebDriver d){
        driver = d;
    }

    By username = By.id("user-name");
    By password = By.id("password");
    By loginBTN = By.id("login-button");

    public void enterUsername(String uname){
        driver.findElement(username).sendKeys(uname);
    }
    public void enterPassword(String pwd){
        driver.findElement(password).sendKeys(pwd);
    }
    public void clickOnLoginBTN(){
        driver.findElement(loginBTN).click();
    }

}
