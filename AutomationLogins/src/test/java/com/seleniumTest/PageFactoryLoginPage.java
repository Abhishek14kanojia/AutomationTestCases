package com.seleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryLoginPage {

    WebDriver driver;

    PageFactoryLoginPage(WebDriver d){
        driver = d;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    public void enterUsername(String uname){
        username.sendKeys(uname);
    }
    public void enterPassword(String pwd){
        password.sendKeys(pwd);
    }
    public void clickOnLoginBTN(){
        loginBtn.click();
    }

}
