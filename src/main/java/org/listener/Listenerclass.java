package org.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listenerclass implements ITestListener, IRetryAnalyzer {
    Logger logger = LogManager.getLogger(Listenerclass.class);
    private int count = 0;
    private int maxTry = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        // will run until it is false
        if (!iTestResult.isSuccess()) {
            if (this.count < maxTry) {
                logger.info("Retrying test " + iTestResult.getName() + " with status " + getResultStatusName(
                        iTestResult.getStatus()) + " for the " + (this.count + 1) + " time(s).");
                this.count++;
                return true;
            }
        }
        return false;

    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info("The Method called is " + iTestResult.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("The Method is " + iTestResult.getMethod().getMethodName() + "is successful");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.info("The Method is " + iTestResult.getMethod().getMethodName() + "is failed");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.info("The Method is " + iTestResult.getMethod().getMethodName() + "is skipped due to +"
                + iTestResult.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    public String getResultStatusName(final int status) {
        String resultName = null;
        if (status == 1) {
            resultName = "SUCCESS";
        }
        if (status == 2) {
            resultName = "FAILURE";
        }
        if (status == 3) {
            resultName = "SKIP";
        }
        return resultName;
    }

}
