package pages;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import Utils.ExcelUtils;
//import test.AddEmployeeTest;

public class Validation {

	static WebDriver driver =null;

	static String res;
	static boolean f=false;

	public static void main(String[] args) throws IOException, ParseException {

		//validate();
		check();

	}
	public static boolean validate() throws IOException, ParseException
	{
/*
		String projectpath=System.getProperty("user.dir");
		ExcelUtils excel=new ExcelUtils(projectpath+"/Excel/data.xlsx","Sheet1");
		*/
		
		

		System.setProperty("webdriver.chrome.driver","C:\\Users\\komalatha\\Documents\\workspace-spring-tool-suite-4-4.7.1.RELEASE\\OrangeHRMDemo\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();

		System.out.println("Yes Iam in");



		driver.get("https://opensource-demo.orangehrmlive.com/");

		OrangeHRMHomePage.username(driver).sendKeys("Admin");

		OrangeHRMHomePage.password(driver).sendKeys("admin123");

		OrangeHRMHomePage.login(driver).click();

		driver.findElement(By.id("menu_pim_viewPimModule")).click();




		//String name=excel.getCellDataString(1,15);
		
		
		JSONParser jsonparser=new JSONParser();

		FileReader reader=new FileReader("C:\\Users\\komalatha\\Documents\\workspace-spring-tool-suite-4-4.7.1.RELEASE\\OrangeHRMDemo\\JsonFiles\\employee.json");

		Object obj=jsonparser.parse(reader);

		JSONObject empjsonob=(JSONObject)obj;
		
		String name=(String) empjsonob.get("ValidEmployee");


		List<WebElement> allRows = driver.findElements(By.xpath("//table[@class='table hover']//tr")); 

		// And iterate over them and get all the cells 

		for (WebElement row : allRows) { 
			List<WebElement> cells = row.findElements(By.tagName("td")); 

			// Print the contents of each cell
			for (WebElement cell : cells) {         

				if(cell.getText().equals(name)) {
					//System.out.println(cell.getText());
					return true;
				}


			}


		}

		return false;



	}

	public static boolean check() throws IOException, ParseException
	{
		boolean flg=Validation.validate();
		//System.out.println(flg);
		if(flg)
		{
			System.out.println("Employee was added successfully");

			return true;
		}
		else
		{
			System.out.println("Employee was not added");
			return false;
		}
	}
}	
