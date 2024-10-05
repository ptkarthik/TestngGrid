package extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extent;
    private static ExtentTest test;

    public void onStart(ITestContext context) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-report.html");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Test Results");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Host Name", "LocalHost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "User");

        // Log to console
        System.out.println("Extent Report Initialized");
    }

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());

        // Log to console
        System.out.println("Test Started: " + result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");

        // Log to console
        System.out.println("Test Passed: " + result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Failed: " + result.getThrowable());

        // Log to console
        System.out.println("Test Failed: " + result.getMethod().getMethodName());
        System.out.println("Reason: " + result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped: " + result.getThrowable());

        // Log to console
        System.out.println("Test Skipped: " + result.getMethod().getMethodName());
    }

    public void onFinish(ITestContext context) {
        extent.flush();  // Writes the report to the file

        // Log to console
        System.out.println("Extent Report Flushed to extent-report.html");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Optional, no console output required here
    }
}
