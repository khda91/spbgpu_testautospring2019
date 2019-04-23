package com.epam.spbgpu.test.auto.lesson2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class SimpleTest {

    @Test
    public void openMantisBt() {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getClassLoader()
                        .getResource("webdriver/chrome/chromedriver.exe").getPath());
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/mantisbt/login_page.php");
        assertEquals(driver.getTitle(), "MantisBT");
        driver.close();
    }

    @BeforeSuite
    public void before() {
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("taskkill /im chromedriver.exe /f /t");
            proc.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
