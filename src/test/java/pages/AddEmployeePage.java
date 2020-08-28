package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployeePage {



	static WebElement element=null;
	private WebDriver driver=null;
	public AddEmployeePage(WebDriver driver)
	{
		this.driver=driver;
	}

	@FindBy(id="menu_pim_viewPimModule") WebElement pim;

	@FindBy(id="menu_pim_addEmployee") WebElement addemp;

	@FindBy(id="firstName")
	static WebElement firstname;

	@FindBy(id="lastName")
	static WebElement lastname;

	@FindBy(id="chkLogin") WebElement checklogin;

	@FindBy(id="user_name")
	static WebElement username;

	@FindBy(id="user_password")
	static WebElement password;

	@FindBy(id="re_password")
	static WebElement confirmpassword;
	
	@FindBy(id="btnSave") WebElement savebutton;
	
	@FindBy(id="btnSave") WebElement edit;
	
	@FindBy(id="job_job_title") WebElement drpJobTitle;

	@FindBy(id="job_emp_status") WebElement empstatus;

	@FindBy(id="job_sub_unit") WebElement subunit;

	@FindBy(linkText="Report-to")
	WebElement report;

	@FindBy(id="btnAddSupervisorDetail") WebElement add;

	@FindBy(id="reportto_supervisorName_empName") WebElement supervisorName;
	
	@FindBy(id="reportto_reportingMethodType") WebElement drpReportingMethod;
	
	@FindBy(id="btnSaveReportTo") WebElement save;
	
	

	public void PIM()
	{
		//element=driver.findElement(By.id("menu_pim_viewPimModule"));


		pim.sendKeys(Keys.RETURN);
	}


	public void AddEmployee()
	{
		//element=driver.findElement(By.id("menu_pim_addEmployee"));
		addemp.sendKeys(Keys.RETURN);

	}


	public static void Details(WebDriver driver,String fname,String lname)
	{

		//WebElement firstname=driver.findElement(By.id("firstName"));
		firstname.sendKeys(fname);

		//WebElement lastname=driver.findElement(By.id("lastName"));
		lastname.sendKeys(lname);
		

	}

	public void checkcreatelogin()
	{
		//System.out.println("Checked");
		//element=driver.findElement(By.id("chkLogin"));
		checklogin.click();
	}

	public static void LoginDetails(WebDriver driver,String usn,String pwd,String repwd)
	{

		//WebElement username=driver.findElement(By.id("user_name"));
		username.sendKeys(usn);

		//WebElement password=driver.findElement(By.id("user_password"));
		password.sendKeys(pwd);

		//WebElement confirmpassword=driver.findElement(By.id("re_password"));
		confirmpassword.sendKeys(repwd);

		//flag2=true;

	}

	public void save()
	{
		//element=driver.findElement(By.id("btnSave"));
		savebutton.sendKeys(Keys.RETURN);
		//flag3=true;
	}


	public void Job()
	{
		//driver.findElement(By.linkText("Job")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		Actions builder = new Actions(driver);

		WebElement job = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Job")));
		job.click();

		//WebElement edit=driver.findElement(By.id("btnSave"));
		edit.click();

	}

	public void select(String title,String status,String sunit)
	{
		//Select drpJobTitle = new Select(driver.findElement(By.id("job_job_title")));
		
		Select JT=new Select(drpJobTitle);
		JT.selectByVisibleText(title);

		//Select empstatus = new Select(driver.findElement(By.id("job_emp_status")));
		Select estatus=new Select(empstatus);
		estatus.selectByVisibleText(status);

		//Select subunit = new Select(driver.findElement(By.id("job_sub_unit")));
		Select unit=new Select(subunit);
		unit.selectByVisibleText(sunit);


	}

	public void ReportTo()
	{
		//element=driver.findElement(By.linkText("Report-to"));
		report.click();
		//WebElement add=driver.findElement(By.id("btnAddSupervisorDetail"));
		add.click();
		

	}

	public void addSupervisor(String name,String method)
	{
		//element=driver.findElement(By.id("reportto_supervisorName_empName"));
		supervisorName.sendKeys(name);
		//Select drpReportingMethod = new Select(driver.findElement(By.className("drpDownR")));
		 Select mthd=new Select(drpReportingMethod);
		 mthd.selectByVisibleText(method);
		//WebElement save=driver.findElement(By.id("btnSaveReportTo"));
		save.click();
		
	}

}
