package com.seleniumTest;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ListenerTestCase {

    @Test
    public void testMethod1() {
        System.out.println("Method1..");
        Assert.assertTrue(true);
    }

    @Test
    public void testMethod2() {
        System.out.println("Method2..");
        Assert.assertTrue(false);
    }

    @Test
    public void testMethod3() {
        System.out.println("Method3");
        Assert.assertTrue(true);
    }

    @Test
    public void testMethod4() {
        System.out.println("Method4");
        throw new SkipException("skipped this test case with exception..");
    }

    @Test
    public void testMethod5() {
        System.out.println("Method5");
        Assert.assertTrue(true);
    }

}
