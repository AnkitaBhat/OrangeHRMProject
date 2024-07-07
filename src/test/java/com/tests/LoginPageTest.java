package com.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utils.TestBase;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	public LoginPageTest(){
		super();//using this it will not throw null pointer exception
	}
	
	@BeforeMethod
	public void setUp() throws IOException{
		 
		initialization();
		loginPage = new LoginPage(driver);
	}

		
	

	@Test(priority=1)
	public void loginTest(){
		loginPage.login(prop.getProperty("QA_userName"), prop.getProperty("QA_password"));
		String Actual=driver.getTitle();
		String Expected="OrangeHRM";
		Assert.assertEquals(Actual, Expected);
		
	}
	
	@Test(priority=2)
	public void AddUserTest(){
		loginPage.AddEmployee(prop.getProperty("Fname"), prop.getProperty("Lname"));
		
		
	}
	

	
	/*
	 * @AfterMethod public void tearDown(){ driver.quit(); }
	 */
	 
}




