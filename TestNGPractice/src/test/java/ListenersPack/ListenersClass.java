package ListenersPack;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersClass implements ITestListener{
	public ExtentSparkReporter esr;
	public ExtentReports er;
	public ExtentTest test;
	

 public void onStart(ITestContext context) {
	 
	   esr = new ExtentSparkReporter(System.getProperty("user.dir")+"\\ExtentReport\\Reports.html");
	   esr.config().setDocumentTitle("OrangeHRM Report");
	   esr.config().setReportName("Login Report");
	   esr.config().setTheme(Theme.DARK);
	   
	   er = new ExtentReports();
	   er.attachReporter(esr);
	   
	   er.setSystemInfo("Tester Name", "Aravind");
	   er.setSystemInfo("Browser", "Dummy");
	   er.setSystemInfo("Environment", "QA");
 }	

 public void onTestSuccess(ITestResult result) {
	 test = er.createTest(result.getName()); //create a new entry in the report
		test.log(Status.PASS, result.getName()); //update status p/f/s	
 }
 public void onTestFailure(ITestResult result) {
	 test = er.createTest(result.getName());
	 test.log(Status.FAIL, result.getName());
	 test.log(Status.FAIL, result.getThrowable());
 }
 public void onTestSkipped(ITestResult result) {
	 test = er.createTest(result.getName());
	 test.log(Status.SKIP, result.getName());
 }
 public void onFinish(ITestContext context) {
	   er.flush(); 
 }
 


 
}
