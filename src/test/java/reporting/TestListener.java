package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener {

	
	 private static ExtentReports extent = ExtentManager.getInstance();
	    // store test instances per thread (parallel safe)
	    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

	    public void onStart(ITestContext context) {
	        // overall suite start
	    }

	    public void onFinish(ITestContext context) {
	        extent.flush(); // write the report
	    }

	    public void onTestStart(ITestResult result) {
	        String testName = result.getMethod().getMethodName();
	        ExtentTest test = extent.createTest(testName);
	        testThread.set(test);
	    }

	    public void onTestSuccess(ITestResult result) {
	        testThread.get().pass("Test passed");
	    }

	    public void onTestFailure(ITestResult result) {
	        Throwable t = result.getThrowable();
	        testThread.get().fail(t);

	        // Optional: attach screenshot (if you save one)
	        // String screenshotPath = takeScreenshot(result);
	        // testThread.get().addScreenCaptureFromPath(screenshotPath);
	    }

	    public void onTestSkipped(ITestResult result) {
	        testThread.get().skip("Test skipped");
	    }

	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // not used
	    }

	
}
