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

public class AddUserPage {


	static WebElement element=null;
	private WebDriver driver=null;
	public AddUserPage(WebDriver driver)
	{
		this.driver=driver;
	}

	@FindBy(id="menu_admin_viewAdminModule") WebElement admin;

	@FindBy(id="btnAdd") WebElement add;

	@FindBy(id="systemUser_userType")
	static WebElement drpuserRole;

	@FindBy(id="systemUser_employeeName_empName")
	static WebElement name;
	
	@FindBy(id="systemUser_userName")
	static WebElement username;

	@FindBy(id="systemUser_status")
	static WebElement drpstatus;
	
	@FindBy(id="systemUser_password")
	static WebElement password;
	
	@FindBy(id="systemUser_confirmPassword")
	static WebElement confirmpassword;


	public void Admin()
	{
		//element=driver.findElement(By.id("menu_admin_viewAdminModule"));
		admin.sendKeys(Keys.RETURN);
		//WebElement add=driver.findElement(By.id("btnAdd"));
		add.sendKeys(Keys.RETURN);


	}


	public static void addUser(WebDriver driver,String role,String empName,String usn,String status,String pwd)
	{

		Select user_role= new Select(drpuserRole);
		user_role .selectByVisibleText(role);

		//WebElement name=driver.findElement(By.id("systemUser_employeeName_empName"));
		name.sendKeys(empName);
		
		//WebElement username=driver.findElement(By.id("systemUser_userName"));
		username.sendKeys(usn);

		Select usr_status= new Select(drpstatus);
		usr_status.selectByVisibleText(status);

		//WebElement password=driver.findElement(By.id("systemUser_password"));
		password.sendKeys(pwd);

		//WebElement confirmpassword=driver.findElement(By.id("systemUser_confirmPassword"));
		confirmpassword.sendKeys(pwd);

		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.id("btnSave"));
		action.moveToElement(we).click().build().perform();


	}

}
