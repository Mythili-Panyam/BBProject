package Com.Test.BlueBadge.Listeners;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tesults.tesults.Results;

import Com.Test.BlueBadge.Base.BasePage;

public class TesultsReportListener extends BasePage implements ITestListener{
	// A list to hold your test cases.
	  List<Map<String,Object>> testCases = new ArrayList<Map<String, Object>>();

	  private static String getTestMethodName(ITestResult iTestResult) {
	    return iTestResult.getMethod().getConstructorOrMethod().getName();
	  }

	  @Override
	  public void onFinish(ITestContext iTestContext) {
	    // Map<String, Object> to hold your test results data.
	    Map<String, Object> data = new HashMap<String, Object>();
	    data.put("target", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IjY0YTllZmNkLTBkY2UtNGZjNS04YWY0LTBiODU1ZWZiMGNmNS0xNTg2ODk4MDU5NTk3IiwiZXhwIjo0MTAyNDQ0ODAwMDAwLCJ2ZXIiOiIwIiwic2VzIjoiZGYzOTdjOWMtZWM1Ny00YWZlLWI0ZTUtZGEwNmM2YjkzYTRkIiwidHlwZSI6InQifQ.MdFyECpSHsV7JqFhBJvaP0l0z0Tywz3Mhjqr6MAFJdI");

	    Map<String, Object> results = new HashMap<String, Object>();
	    results.put("cases", testCases);
	    data.put("results", results);

	    // Upload
	    Map<String, Object> response = Results.upload(data);
	    System.out.println("success: " + response.get("success"));
	    System.out.println("message: " + response.get("message"));
	    System.out.println("warnings: " + ((List<String>) response.get("warnings")).size());
	    System.out.println("errors: " + ((List<String>) response.get("errors")).size());
	  }

	  @Override
	  public void onTestSuccess(ITestResult iTestResult) {
	    System.out.println("I am in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
	    Map<String, Object> testCase = new HashMap<String, Object>();
	    testCase.put("name", getTestMethodName(iTestResult));
	    testCase.put("suite", "TesultsExample");
	    testCase.put("result", "pass");
	    testCases.add(testCase);
	  }

	  @Override
	  public void onTestFailure(ITestResult iTestResult) {
	    System.out.println("I am in onTestFailure method " +  getTestMethodName(iTestResult) + " failed");
	    Map<String, Object> testCase = new HashMap<String, Object>();
	    testCase.put("name", getTestMethodName(iTestResult));
	    testCase.put("suite", "TesultsExample");
	    testCase.put("result", "fail");
	    testCases.add(testCase);
	  }

	  @Override
	  public void onTestSkipped(ITestResult iTestResult) {
	    System.out.println("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
	    Map<String, Object> testCase = new HashMap<String, Object>();
	    testCase.put("name", getTestMethodName(iTestResult));
	    testCase.put("suite", "TesultsExample");
	    testCase.put("result", "unknown");
	    testCases.add(testCase);
	  }

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
