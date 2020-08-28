package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//This page contain all the locators of OrangeHRMHomePage

public class OrangeHRMHomePage {
	static WebElement element=null;
	public static WebElement username(WebDriver driver)
	{
		element=driver.findElement(By.id("txtUsername"));
		return element;
	}
	
	public static WebElement password(WebDriver driver)
	{
		element=driver.findElement(By.id("txtPassword"));
		return element;
	}
	
	public static WebElement login(WebDriver driver)
	{
		element=driver.findElement(By.id("btnLogin"));
		return element;
	}
	
	
	
	
	
}
