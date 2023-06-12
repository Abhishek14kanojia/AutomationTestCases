package com.seleniumTest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int countForRetryAttempts = 0;
    int setMaxLimitForRetry = 3;


    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()){
            if (countForRetryAttempts < setMaxLimitForRetry){
                countForRetryAttempts++;
                return true;
            }
        }
        return false;
    }
}
