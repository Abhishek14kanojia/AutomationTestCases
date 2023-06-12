package com.seleniumTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FailedTestCase {

    @Test
    public void case1(){
        Assert.assertTrue(false);
    }
    @Test
    public void case2(){
        Assert.assertTrue(false);
    }
    @Test
    public void case3(){
        Assert.assertTrue(true);
    }

}
