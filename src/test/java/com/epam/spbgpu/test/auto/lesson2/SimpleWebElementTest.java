package com.epam.spbgpu.test.auto.lesson2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class SimpleWebElementTest {

    @Test
    public void loginMantisBt() {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getClassLoader()
                        .getResource("webdriver/chrome/chromedriver.exe").getPath());
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open Mantis
        driver.get("http://localhost/mantisbt/login_page.php");

        // Check title
        assertEquals(driver.getTitle(), "MantisBT");

        // Login
        driver.findElement(By.id("username")).sendKeys("administrator");
//        driver.findElement(By.cssSelector("#username")).sendKeys("administrator");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        try {
            driver.findElement(By.cssSelector("#password11231")).sendKeys("root");
        } catch (NoSuchElementException e) {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(file, new File("C:\tmp.png"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        // Check login
        assertEquals(driver.getTitle(), "My Account - MantisBT");
        assertEquals(driver.findElement(By.className("user-info")).getText(),
                "administrator");

        // Close driver
        driver.close();
    }
}
