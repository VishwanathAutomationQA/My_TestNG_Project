	package utilities;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
   
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext context) {
		String path = System.getProperty("user.dir");
		sparkReporter = new ExtentSparkReporter(path+File.separator+"reports"+File.separator+"extent.html");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Regression");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer name", "locathost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester name", "Vishwajit");
		extent.setSystemInfo("Browser Name", "Chrome");
	}
	
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName()); //create new entry in a report
		test.log(Status.PASS, "Test case passed is : "+ result.getName()); // update status P/F/S
		
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
	     test.log(Status.FAIL, "failed test is : "+ result.getName());
	     test.log(Status.FAIL, "failed test cause is : "+ result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		 test = extent.createTest(result.getName());
	     test.log(Status.SKIP, "Skipped test is : "+ result.getName());	  
	}

	public void onFinish(ITestContext context) {
		extent.flush();	 
	}
}
