package com.techm.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBaseexecute {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.getProperty("user.dir"); // gives the path of the system till our project path and can be use in fileinputstream
		Properties config = new Properties();
		Properties OR = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
	    fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.peroperties");
		config.load(fis);
		OR.load(fis);
		System.out.println(config.getProperty("Browser"));
		System.out.println(config.getProperty("BmLBtn"));
		
		
		
	}

}
