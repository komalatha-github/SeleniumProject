
package test;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import Utils.ExcelUtils;
import pages.AddEmployeePage;
import pages.OrangeHRMHomePage;

public class EmpTest {
	static WebDriver driver=null;
	
	@BeforeTest
	public void setUp()
	{
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\komalatha\\Documents\\workspace-spring-tool-suite-4-4.7.1.RELEASE\\OrangeHRMDemo\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();

	}
	
	
	@Test
	public static void EmployeeTest() throws IOException, ParseException
	{
		
		
		AddEmployeePage employee_page=PageFactory.initElements(driver, AddEmployeePage.class);
		
		

		
		
		JSONParser jsonparser=new JSONParser();

		FileReader reader=new FileReader("C:\\Users\\komalatha\\Documents\\workspace-spring-tool-suite-4-4.7.1.RELEASE\\OrangeHRMDemo\\JsonFiles\\employee.json");

		Object obj=jsonparser.parse(reader);

		JSONObject empjsonob=(JSONObject)obj;

		String firstName=(String) empjsonob.get("FirstName");
		String lastName=(String) empjsonob.get("LastName");
		String usn=(String) empjsonob.get("Emp_UserName");
		String pswd=(String) empjsonob.get("Emp_Password");
		String JTitle=(String) empjsonob.get("JobTitle");
		String EmpStatus=(String) empjsonob.get("Emp_Status");
		String SbUnit=(String) empjsonob.get("SubUnit");
		String JoiningMethod=(String) empjsonob.get("JoinMethod");
		
		
		
		/*Excel Data Provider
		String projectpath=System.getProperty("user.dir");
		ExcelUtils excel=new ExcelUtils(projectpath+"/Excel/data.xlsx","Sheet1");
		*/
				
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		OrangeHRMHomePage.username(driver).sendKeys("Admin");
		
		OrangeHRMHomePage.password(driver).sendKeys("admin123");
		
		OrangeHRMHomePage.login(driver).click();
		
		employee_page.PIM();
		employee_page.AddEmployee();
		
		
		employee_page.Details(driver,firstName,lastName);
		employee_page.checkcreatelogin();
		employee_page.LoginDetails(driver,usn,pswd,pswd);
		employee_page.save();
		employee_page.Job();
		
		
		employee_page.select(JTitle,EmpStatus,SbUnit);
		employee_page.save();
		employee_page.ReportTo();
		
		//String JoiningMethod=excel.getCellDataString(1,10);
		
		employee_page.addSupervisor("John Smith",JoiningMethod);
		
		  
		
	}
	@AfterTest
	public void tearDown()
	{
		//pageobj.report1();
		
				System.out.println("Done");
				
				
				driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList");
				
				//driver.close();
	}

	

}
