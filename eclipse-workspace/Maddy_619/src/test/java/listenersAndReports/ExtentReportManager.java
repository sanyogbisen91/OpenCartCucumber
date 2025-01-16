package listenersAndReports;

import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.ITestContext;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter; // UI of report
	public ExtentReports extent; //populate common info on report
	public ExtentTest test; //creating test case entries in the report and update status of the test methods
  
	public void onStart(ITestContext context) {
		 
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html"); // specified location of the report
		
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Sanyog");
		extent.setSystemInfo("OS", "Windows 11");
			
		
	  }
	
	
	 public void onTestSuccess(ITestResult result) {
		 
		 test=extent.createTest(result.getName());// create a new entry in report
		 test.log(Status.PASS, "Test case PASSED is :"+result.getName());
	  }
	
	 public void onTestFailure(ITestResult result) {
		 
		 test=extent.createTest(result.getName());
		 test.log(Status.FAIL, "Test case FAILED is:"+result.getName());
		 test.log(Status.FAIL,"Test case FAILED cause is:"+result.getThrowable());
	    
	  }
	
	 public void onTestSkipped(ITestResult result) {
		 
		 test=extent.createTest(result.getName());
		 test.log(Status.SKIP, "Test Case SKIPPED is:"+result.getName());
		 
	    
	  }
	
	 public void onFinish(ITestContext context) {
		 extent.flush();
	    
	  }

}
