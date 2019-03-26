package com.epam.spbgpu.test.auto.lesson3.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageStatic {
    private static WebDriver driver;
    public static WebElement usernameTextField;
    public static WebElement passwordTextField;
    public static WebElement loginButton;

    public static void initDriver(WebDriver webdDriver) {
        driver = webdDriver;
    }

    public static void initLogin() {
        usernameTextField = driver.findElement(By.id("username"));
        loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
    }

    public static void initPassword() {
        loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        passwordTextField = driver.findElement(By.id("password"));
    }

    public static String getPageTitle() {
        return driver.getTitle();
    }
}
