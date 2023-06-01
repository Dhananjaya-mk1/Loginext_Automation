package com.loginext.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
public class BaseClass 
{
	
	public JavaUtility jLib=new JavaUtility();
	public	PropertyFileUtility pLib=new PropertyFileUtility();
	public	ExcelUtility eLib=new ExcelUtility();
	public	WebDriverUtility wLib=new WebDriverUtility();
	public WebDriver driver=null;
	
	  public static WebDriver sDriver;
	
	@BeforeTest
	public void launchBrowser() throws Throwable 
	{
		//read the data from property
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
	
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		sDriver = driver;
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		Reporter.log("===Browser launch successful===",true);
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("===Browser close successful===",true);

	
}}
