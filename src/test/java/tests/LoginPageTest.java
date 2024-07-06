package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.TestBase;

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
	
	@Test(priority=1)
	public void AddUserTest(){
		
		
		
	}
	

	
	 @AfterMethod 
	 public void tearDown(){ 
		 driver.quit(); 
		 }
	 
}




