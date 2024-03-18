package common;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners extends CaptureScreenshot implements ITestListener {

	public void onTestFailure(ITestResult result) {
		CaptureScreenshot.getScreenshot(result.getMethod().getMethodName());
		Reporter.log("Test Result: " + getTestStatusAsString(result.getStatus()));
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test Result: " + getTestStatusAsString(result.getStatus()));
	}

	public void onStart(ITestContext context) {
		try {
			deleteScreenshotFolder();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ON START");
		Reporter.log("Starting test suite: " + context.getSuite().getName());
		Reporter.log("Included groups: " + context.getIncludedGroups());
		Reporter.log("Excluded groups: " + context.getExcludedGroups());
		Reporter.log("Test methods: " + context.getAllTestMethods());
        Reporter.log("Test parameters: " + context.getCurrentXmlTest().getAllParameters());
	}

	public void onTestStart(ITestResult result) {
	}	

	private String getTestStatusAsString(int status) {
		switch (status) {
		case ITestResult.SUCCESS:
			return "SUCCESS";
		case ITestResult.FAILURE:
			return "FAILURE";
		case ITestResult.SKIP:
			return "SKIP";
		// Add more cases if needed
		default:
			return "UNKNOWN";
		}
	}

}
