package day38;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkReporter;  // UI of the report
	public ExtentReports extent;  //populate common info on the report
	public ExtentTest test;  // creating test case entries in the report and update status of the test methods

	public void onTestStart(ITestContext Context)
	{
		//sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "/myReport/report1.html"); // Specify location of thje report
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/myReport.html");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer name", "Localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name","Pushkar");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("BrowserName", "Chrome, Firefox, Edge");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test = extent.createTest(result.getName()); // create a new enty in the report
		test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s
		
	}
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getName()); // create a new enty in the report
		test.log(Status.FAIL, "Test case failure is:" + result.getName()); // update status p/f/s
		test.log(Status.FAIL, "Test case Failure cause is : "+ result.getThrowable());
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test= extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case is skipped :"+ result.getName());
	}
	
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}

	
}















