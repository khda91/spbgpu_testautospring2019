package com.epam.spbgpu.test.auto.lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class SimpleTestPODefaultLocators {

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
        LoginPageDefaultLocators lpv = new LoginPageDefaultLocators(driver);
        assertEquals(lpv.getPageTitle(), "MantisBT");

        // Login
        lpv.login("administrator", "root");

        // Check login
        assertEquals(driver.getTitle(), "My Account - MantisBT");
        assertEquals(driver.findElement(By.className("user-info")).getText(),
                "administrator");

        // Close driver
        driver.close();
    }

}
