package com.epam.spbgpu.test.auto.lesson6;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:lesson6"},
        glue = {"classpath:com.epam.spbgpu.test.auto.lesson6"}
)
public class RunAcceptance {

    @BeforeClass
    public static void initTest() {
        ChromeDriverManager.chromedriver().setup();
    }
}
