package com.techm.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.techm.base.TestBase;

public class ScreenshotCapture extends TestBase{
	
	public void CaptureScreenshot()
	{
	File scrfile =	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir" )+"//path where we want to store"));
	}

}
