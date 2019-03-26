package com.epam.spbgpu.test.auto.lesson3;

import com.epam.spbgpu.test.auto.lesson3.staticpo.LoginPageStatic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class SimpleTestStaticPO {

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
        LoginPageStatic.initDriver(driver);
        assertEquals(LoginPageStatic.getPageTitle(), "MantisBT");

        // Login
        LoginPageStatic.initLogin();
        LoginPageStatic.usernameTextField.sendKeys("administrator");
        LoginPageStatic.loginButton.click();
        LoginPageStatic.initPassword();
        LoginPageStatic.passwordTextField.sendKeys("root");
        LoginPageStatic.loginButton.click();

        // Check login
        assertEquals(driver.getTitle(), "My Account - MantisBT");
        assertEquals(driver.findElement(By.className("user-info")).getText(),
                "administrator");

        // Close driver
        driver.close();
    }

}
