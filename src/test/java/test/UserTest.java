package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import Utils.ExcelUtils;
import pages.AddEmployeePage;
import pages.AddUserPage;
import pages.OrangeHRMHomePage;

public class UserTest {

	static WebDriver driver=null;
	static Logger logger=LogManager.getLogger(EmpTest.class);

	@BeforeTest
	public void setUp()
	{


		System.setProperty("webdriver.chrome.driver","C:\\Users\\komalatha\\Documents\\workspace-spring-tool-suite-4-4.7.1.RELEASE\\OrangeHRMDemo\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		logger.info("Here we are adding the users");
	}

	@Test
	public static void UserTest() throws InterruptedException, IOException, ParseException
	{




		/*String projectpath=System.getProperty("user.dir");
		ExcelUtils excel=new ExcelUtils(projectpath+"/Excel/data.xlsx","Sheet1");*/

		driver.get("https://opensource-demo.orangehrmlive.com/");

		OrangeHRMHomePage.username(driver).sendKeys("Admin");

		OrangeHRMHomePage.password(driver).sendKeys("admin123");

		OrangeHRMHomePage.login(driver).click();


		AddUserPage user_page=PageFactory.initElements(driver, AddUserPage.class);

		//AddUserPage userobj=new AddUserPage(driver);



		JSONParser jsonparser=new JSONParser();

		FileReader reader=new FileReader("C:\\Users\\komalatha\\Documents\\workspace-spring-tool-suite-4-4.7.1.RELEASE\\OrangeHRMDemo\\JsonFiles\\employee.json");

		Object obj=jsonparser.parse(reader);

		JSONObject empjsonob=(JSONObject)obj;

		String usrRole=(String) empjsonob.get("UserRole");
		String UsName=(String) empjsonob.get("UserName");
		String sts=(String) empjsonob.get("Status");
		String psd=(String) empjsonob.get("Password");


		user_page.Admin();
		/*
		//Scanner ob=new Scanner(System.in);
		//System.out.println("Select User Role(Admin/ESS)::");
		String usrRole=excel.getCellDataString(1,11);


		//System.out.println("Enter unique User name::");
		String UsName=excel.getCellDataString(1,12);

		//System.out.println("Enter status(Enabled/Disabled)::");
		String sts=excel.getCellDataString(1,13);
		//System.out.println("Enter Password::");
		String psd=excel.getCellDataString(1,14);
*/
		Thread.sleep(3000);


		user_page.addUser(driver,usrRole,"Linda Anderson",UsName,sts,psd);

	}

	@AfterTest
	public void tearDown()
	{
		//userobj.report2();
		//driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
		System.out.println("Done");
	}


}
