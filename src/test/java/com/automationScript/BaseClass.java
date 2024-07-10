package com.automationScript;

import static org.testng.Assert.assertTrue;

import com.pom.LoginPOM;

public class BaseClass extends SuperClass{

	LoginPOM login=new LoginPOM(driver);
	//HeaderPom header=new  HeaderPom(driver);
	final  String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	final String USERNAME="Admin";
	final String PASSWORD="admin123";
	final String VERIFYDASHBOARD="Dashboard";
	
	
public void userableToLogin() {
		
		//class Object
		login=new LoginPOM(driver);
		
		
		// Step 1: Open the URL
		assertTrue(login.get(url));
		
		//Step 2: Enter the User Name and Password
		assertTrue(login.Login(USERNAME,PASSWORD),"login");
		
		
		
	}
	
}
