package com.epam.spbgpu.test.auto.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageDefaultLocators {

    private WebDriver driver;

    private WebElement username;

    private WebElement password;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    public LoginPageDefaultLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void login(String username, String password) {
        this.username.sendKeys(username);
        loginButton.click();
        this.password.sendKeys(password);
        loginButton.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
