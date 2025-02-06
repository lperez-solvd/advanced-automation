package com.solvd.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryUtil implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 10;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            System.out.printf(String.format("Try again for %d time%s", retryCount+1, retryCount+1 > 1 ? "s" : ""));
            retryCount++;
            return true;
        }
        return false;
    }
}