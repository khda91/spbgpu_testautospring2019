package com.epam.spbgpu.test.auto.lesson4;

import com.epam.spbgpu.test.auto.lesson4.enums.MenuItem;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SimpleTestPO {

    private WebDriver driver;

    private LoginPage lpv;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        ChromeDriverManager.chromedriver().setup();
    }

    @BeforeMethod(alwaysRun = true)
    public void initDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

        // Open Mantis
        driver.get("http://localhost/mantisbt/login_page.php");
        lpv = new LoginPage(driver);
    }

    @Test
    public void loginMantisBt() {
        // Check title
//        LoginPage lpv = new LoginPage(driver);
//        LoginPage lpv = PageFactory.initElements(driver, LoginPage.class);
        assertEquals(lpv.getPageTitle(), "MantisBT");

        // Login
        lpv.login("administrator", "root");

        // Check login
        assertEquals(driver.getTitle(), "My Account - MantisBT");
        assertEquals(driver.findElement(By.className("user-info")).getText(),
                "administrator");
    }

    @Test
    public void loginMantisBtPFInsidePo() {
        // Check title
//        LoginPage lpv = new LoginPage(driver);
        assertEquals(lpv.getPageTitle(), "MantisBT");

        // Login
        lpv.login("administrator", "root");

        // Check login
        assertEquals(driver.getTitle(), "My Account - MantisBT");
        assertEquals(driver.findElement(By.className("user-info")).getText(),
                "administrator");
    }

    @Test
    public void testSideBar() {
        lpv.login("administrator", "root");
        assertEquals(driver.getTitle(), "My Account - MantisBT");

        lpv.selectMenu(MenuItem.REPORT_ISSUE);
        // Явное ожидание
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(
                        driver.findElement(By.id("select-project-id"))
                )).getText();
        assertEquals(driver.getTitle(), "Select Project - MantisBT");

        new WebDriverWait(driver, 10, 5000)
                .until(ExpectedConditions.visibilityOf(
                        driver.findElement(By.id("select-project-id"))
                )).getText();

        new WebDriverWait(driver, 10, 5000)
                .until(new ExpectedCondition<String>() {
                    @NullableDecl
                    @Override
                    public String apply(@NullableDecl WebDriver webDriver) {
                        return driver.findElement(By.id("select-project-id")).getText();
                    }
                });

        lpv.getLeftSideBar().clickMenuItem(MenuItem.VIEW_ISSUES);
        assertEquals(driver.getTitle(), "View Issues - MantisBT");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        // Close driver
        driver.close();
    }

}
