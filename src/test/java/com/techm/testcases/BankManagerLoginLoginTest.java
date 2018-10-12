package com.techm.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
import com.techm.base.TestBase;

public class BankManagerLoginLoginTest extends TestBase {
	
	@Test
	public void LoginasBankmanager() throws InterruptedException
	{
		System.setProperty("org.uncommons.reporting.escape-output", "false");
		Log.debug("Inside login test");
		driver.findElement(By.cssSelector(OR.getProperty("BmLBtn"))).click();
		Thread.sleep(1000);
		Assert.assertTrue(isElementPresent(By.cssSelector(config.getProperty("AddCL"))), "Login not successfull");
		//isElementPresent is the method which we have created inorder to check if "addcustomer" is present after loggin to bankmanager
		//isElementPresent method is created in base class as it is base for all and it is extended to all clases
		Log.debug("test case succesfully executed");
		Reporter.log("test case executed succesfully");
		//Reporter.log("<a href="abc.jpg">screenshot</a>"); // here we are using doublequotes within double quotes so follow the below
		//Reporter.log("<a href=\"abc.jpg\">screenshot</a>"); // will disply screenshot in same page
		Reporter.log("<a target=\"_blank\" href=\"abc.jpg\">screenshot</a>"); // will dispaly in another page
		Reporter.log("br"); // gives line break
		Reporter.log("<a target=\"_blank\" href=\"abc.jpg\"><img.src>\"abc.jpg\" height = 200 width=200x</img.src></a>");
	}

	
	
	
}
