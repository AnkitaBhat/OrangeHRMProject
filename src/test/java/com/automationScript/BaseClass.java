package com.automationScript;

import static org.testng.Assert.assertTrue;

import java.io.File;

import com.pom.LoginPOM;
import com.utils.ExcelUtility;

public class BaseClass extends SuperClass{

	LoginPOM login=new LoginPOM(driver);
	//HeaderPom header=new  HeaderPom(driver);
	final  String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	//final String VERIFYDASHBOARD="Dashboard";
	final static String pathSeparator = File.separator;

	final static String filename="Test2.xls";
	final static String path=System.getProperty("user.dir")+pathSeparator+"src"+pathSeparator+"main"+pathSeparator+"resources"+pathSeparator+filename;
	

	
public void userableToLogin(String username,String password) {
		//excel object
		/*
		 * ExcelUtility reader = new ExcelUtility(path); final String USERNAME =
		 * reader.getCellData("AdminSheet", "Username", 2); final String PASSWORD =
		 * reader.getCellData("AdminSheet", "Password", 2);
		 * System.out.println(USERNAME); System.out.println(PASSWORD);
		 */
		//class Object
		login=new LoginPOM(driver);
		
		
		// Step 1: Open the URL
		assertTrue(login.get(url));
		
		//Step 2: Enter the User Name and Password
		assertTrue(login.Login(username,password),"login");
		
		
		
	}
	
}
