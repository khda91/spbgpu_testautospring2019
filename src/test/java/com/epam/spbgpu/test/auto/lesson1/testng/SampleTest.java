package com.epam.spbgpu.test.auto.lesson1.testng;

import com.epam.spbgpu.test.auto.lesson1.SampleClass;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleTest {

    private SampleClass sc;

    @BeforeClass
    public void classInit() {
        System.out.println("SampleClass initDriver");
    }

    @BeforeMethod
    public void setUp() {
        sc = new SampleClass();
    }

    @Test
    public void testSumDoubleMethod() {
        double result = sc.sum(3.1, 4.3);
        assertEquals(result, 7.4);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Test complete");
    }

    @AfterClass
    public void classTearDown() {
        System.out.println("SampleClass tear down");
    }
}
