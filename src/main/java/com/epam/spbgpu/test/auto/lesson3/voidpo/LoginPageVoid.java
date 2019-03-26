package com.epam.spbgpu.test.auto.lesson3.voidpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageVoid {

    private WebDriver driver;
    private WebElement usernameTextField;
    private WebElement passwordTextField;
    private WebElement loginButton;

    public LoginPageVoid(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        usernameTextField = driver.findElement(By.id("username"));
        usernameTextField.sendKeys(username);
        loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
        passwordTextField = driver.findElement(By.id("password"));
        passwordTextField.sendKeys(password);
        loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
