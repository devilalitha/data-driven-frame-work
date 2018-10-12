package com.techm.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.techm.base.TestBase;

public class AddCustomerTest extends TestBase {
	
	
	@Test(dataProvider ="getData")
	public void Addcustomer(String FirstName, String LastName, String PostCode)
	{
		
		driver.findElement(By.cssSelector(OR.getProperty("AddCL"))).click();
		driver.findElement(By.cssSelector(OR.getProperty("FirstN"))).sendKeys(FirstName);
		driver.findElement(By.cssSelector(OR.getProperty("LastN"))).sendKeys(LastName);
		driver.findElement(By.cssSelector(OR.getProperty("PostC"))).sendKeys(PostCode);
		driver.findElement(By.cssSelector(OR.getProperty("AddButton"))).click();
	}
	
	@DataProvider
	public Object[][] getData()                  //Object here is not user defined, its predefined
	{
		String sheetname = "AddCustomerTest";
		int rows = excel.getRowCount(sheetname);
		int col = excel.getColumnCount(sheetname);
		Object[][] data =  new Object[rows-1][col];
		
		for(int rowNum =2; rowNum<=rows;rowNum++) {
			for(int colNum =2; colNum<=rows;colNum++) {
				
				data[rowNum-2][colNum] = excel.getCellData(sheetname, colNum, rowNum);
			}
		}
		
		return data;
	}

}
