package com.techm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.techm.utilities.ExcelReader;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger Log = Logger.getLogger("devpinoylogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\TestData.xlsx");
	
@BeforeSuite		
public void SetUp()
{
	
	if(driver==null)
	{
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
			Log.debug("config file loaded");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.peroperties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			OR.load(fis);
			Log.debug("config file loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	if(config.getProperty("Browser").equals("firefox"))
	{
		driver = new FirefoxDriver();
		
	}  
	else if(config.getProperty("Browser").equals("chrome"))
			{
		System.setProperty("webdriver.chrome.driver","I:\\eclipse orginal\\chromedriver.exe");
				driver = new ChromeDriver();
				Log.debug("browser loaded");
				
			}
	else if (config.getProperty("Browser").equals("InternetExplorer"))
	{
		driver = new InternetExplorerDriver();
		
	}
	driver.get(config.getProperty("TestSiteURl"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("Implicit.wait")),TimeUnit.SECONDS);
	Log.debug(config.getProperty("TestSiteURl") + "loaded");
	
}

public boolean isElementPresent(By  by)
{
	try 
	{
	driver.findElements(by);
	return true;
	}catch(NoSuchElementException e) {
	return false;	
	}
	
	
}



	@AfterSuite
	public void TearDown()
	{
		if(driver!=null)
		{
			driver.quit();
			Log.debug("browser closed after execution");
		}
	}

}
