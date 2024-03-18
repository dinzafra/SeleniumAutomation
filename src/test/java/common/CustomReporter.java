package common;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CustomReporter implements IReporter {

//    @Override
//    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
//        for (ISuite suite : suites) {
//            Map<String, ISuiteResult> suiteResults = suite.getResults();
//            for (ISuiteResult suiteResult : suiteResults.values()) {
//                ITestContext testContext = suiteResult.getTestContext();
//                List<ITestResult> testResults = getSortedTestResults(testContext.getPassedTests().getAllResults());
//                testResults.addAll(getSortedTestResults(testContext.getFailedTests().getAllResults()));
//                testResults.addAll(getSortedTestResults(testContext.getSkippedTests().getAllResults()));
//
//                // Output sorted test results
//                for (ITestResult testResult : testResults) {
//                    System.out.println(testResult.getInstanceName() + " - " + testResult.getMethod().getMethodName());
//                }
//            }
//        }
//    }

//    private List<ITestResult> getSortedTestResults(List<ITestResult> testResults) {
//        // Sort the test results based on some criteria
//        Collections.sort(testResults, (result1, result2) ->
//                result1.getInstanceName().compareTo(result2.getInstanceName()));
//        return testResults;
//    }
}
