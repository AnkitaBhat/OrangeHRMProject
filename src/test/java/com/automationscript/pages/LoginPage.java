package com.automationscript.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationscript.utils.TestBase;



public class LoginPage extends TestBase{
	 
	
		WebDriver driver;


		//Constructor that will be automatically called as soon as the object of the class is created
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	

		//Locator for username field
		By uName = By.xpath("//input[@name='username']");
		
		//Locator for password field
		By pswd = By.xpath("//input[@name='password']");
		
		//Locator for login button
		By loginBtn = By.xpath("//button[@type='submit']");
		
	
		//Method to enter username
		public void enterUsername(String user) {
			driver.findElement(uName).sendKeys(user);
		}

		//Method to enter password
		public void enterPassword(String pass) {
			driver.findElement(pswd).sendKeys(pass);
		}
		
		//Method to click on Login button
		public void clickLogin() {
			driver.findElement(loginBtn).click();
		}
		
	
		//login to App method
		
		public void login(String user,String pass) {
			enterUsername(user);
			enterPassword(pass);
			clickLogin();
			
		}
		
		


}