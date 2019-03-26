package com.epam.spbgpu.test.auto.lesson3.fluent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPageFluent {

    private WebDriver driver;

    private WebElement userInfoElement;
    private WebElement viewIssuesElement;

    public AccountPageFluent(WebDriver driver) {
        this.driver = driver;
        this.userInfoElement = driver.findElement(By.className("user-info"));
        viewIssuesElement = driver.findElement(By.xpath("//span[contains(., 'View Issues')]"));
    }

    public AccountPageFluent clickViewIssuesElement() {
        viewIssuesElement.click();
        return new AccountPageFluent(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getTextUserInfoElement() {
        return userInfoElement.getText();
    }
}
