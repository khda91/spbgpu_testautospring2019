package com.epam.spbgpu.test.auto.lesson6.hooks;

import com.epam.spbgpu.test.auto.lesson6.context.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CucumberHooks {

    @Before
    public void initDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.MILLISECONDS);
        TestContext.getInstance().setDriver(driver);
    }

    @After
    public void tearDown() {
        TestContext.getInstance().getDriver().close();
        TestContext.getInstance().setDriver(null);
    }
}
