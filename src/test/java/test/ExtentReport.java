package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pages.AddUserPage;
import pages.UserValidation;
import pages.Validation;

public class ExtentReport {
	
	
	
	WebDriver driver=null;
	AddUserPage usrobj=new AddUserPage(driver);
	Validation valob=new Validation();
	
	static Logger logger=LogManager.getLogger(EmpTest.class);
	
	@Test
	public void test() throws IOException, ParseException
	{
		logger.info("Generating the extent Report");
		ExtentHtmlReporter Reporter=new ExtentHtmlReporter("FirstHtmlReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(Reporter);
		ExtentTest logger1 = extent.createTest("EmployeeTest");
		boolean res1=Validation.check();
		if(res1==true)
		{
			logger1.log(Status.PASS,"Employee has been successfully added");
			logger1.addScreenCaptureFromPath("C:\\Users\\komalatha\\Downloads\\Employee.png");
			
		}
		
		else
		{
			logger1.log(Status.FAIL,"Employee has not been added");	
			 logger.error("Error occured while adding an employee");
		}
		
		extent.flush();
		
		ExtentTest logger2 = extent.createTest("UserTest");
		boolean res2=UserValidation.check();
		if(res2==true)
		{			
			logger2.log(Status.PASS,"User has been successfully added");
			logger2.addScreenCaptureFromPath("C:\\Users\\komalatha\\Downloads\\user.png");
		}
		
		else
		{
			logger2.log(Status.FAIL,"User has not been added");	
			logger.error("Error occured while adding User");
		}
		
		
		extent.flush();
		
	}

}