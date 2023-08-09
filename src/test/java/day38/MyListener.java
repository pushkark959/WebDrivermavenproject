package day38;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener 
{
	 public void onTestStart(ITestResult result) 
	 {
		  System.out.println("on test start....");  
	  }
	 
	 public void onTestSuccess(ITestResult result) 
	 {
		  System.out.println("on test Success....");  
	  }
	 
	 public void onTestFailure(ITestResult result) 
	 {
		  System.out.println("on test Failure....");  
	  }
	 
	 public void onTestSkipped(ITestResult result) 
	 {
		  System.out.println("on test Skipped....");  
	  }

	 public void onFinish(ITestResult Context) 
	 {
		  System.out.println("on test Finish....");  
	  }
	
	
}
