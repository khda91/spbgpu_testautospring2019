package com.epam.spbgpu.test.auto.lesson1.junit;

import com.epam.spbgpu.test.auto.lesson1.SampleClass;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SampleTest {

    SampleClass sc;

    @BeforeClass
    public static void classInit() {
        System.out.println("SampleTest initDriver");
    }

    @Before
    public void setUps() {
        sc = new SampleClass();
    }

    @Test
    public void testSumDoubleMethod() {
        double result = sc.sum(3.6, 5.1);
        assertEquals(8.7, result, 0.1);
    }

    @Test
    public void testSumIntMethod() {
        int result = sc.sum(3, 5);
        assertEquals(8, result);
    }

    @After
    public void tearDown() {
        System.out.println("Test complete");
    }

    @AfterClass
    public static void classTearDown() {
        System.out.println("SampleTest tear down");
    }

}
