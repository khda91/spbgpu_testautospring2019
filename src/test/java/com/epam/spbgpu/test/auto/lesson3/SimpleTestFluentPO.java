package com.epam.spbgpu.test.auto.lesson3;

import com.epam.spbgpu.test.auto.lesson3.fluent.AccountPageFluent;
import com.epam.spbgpu.test.auto.lesson3.fluent.LoginPageFluent;
import com.epam.spbgpu.test.auto.lesson3.voidpo.LoginPageVoid;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class SimpleTestFluentPO {

    @Test
    public void loginMantisBt() {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getClassLoader()
                        .getResource("webdriver/chrome/chromedriver.exe").getPath());
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open Mantis
        driver.get("http://localhost/mantisbt/login_page.php");

        // Login
        AccountPageFluent apf = new LoginPageFluent(driver)
                .login("administrator", "root");

        // Check login
        assertEquals(apf.getPageTitle(), "My Account - MantisBT");
        assertEquals(apf.getTextUserInfoElement(),
                "administrator");

        // Close driver
        driver.close();
    }

    @Test
    public void clickViewIssuesMantisBt() {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getClassLoader()
                        .getResource("webdriver/chrome/chromedriver.exe").getPath());
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open Mantis
        driver.get("http://localhost/mantisbt/login_page.php");

        // Login
        AccountPageFluent apf = new LoginPageFluent(driver)
                .login("administrator", "root")
                .clickViewIssuesElement();

        // Check login
        assertEquals(apf.getPageTitle(), "My Account - MantisBT");
        assertEquals(apf.getTextUserInfoElement(),
                "administrator");

        // Close driver
        driver.close();
    }

}
