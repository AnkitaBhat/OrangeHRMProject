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
		
		
		By PIM=By.xpath("(//a[@class='oxd-main-menu-item'])[2]");
		
		By addButton=By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
		
		By firstName=By.name("firstName");
		
		By lastName=By.name("lastName");
		
		By SaveButton=By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
		
		By employeeId=By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
		

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
		
		
		//method to enter First Name
		public void enterFirstname(String Fname) {
			driver.findElement(firstName).sendKeys(Fname);
		}

		//Method to enter Last Name
		public void enterLastName(String Lname) {
			driver.findElement(lastName).sendKeys(Lname);
		}
		
		
		//Method to get Employee ID
		
		public String getEmployeeID() {
			String empID=driver.findElement(employeeId).getText();
			return empID;
		}
		
		public void clickSave() {
			driver.findElement(SaveButton).click();
		}
		
		public void clickPIM() {
			driver.findElement(PIM).click();
		}
		
		public void clickAdd() {
			driver.findElement(addButton).click();
		}
		
		
		//login to App method
		
		public void login(String user,String pass) {
			enterUsername(user);
			enterPassword(pass);
			clickLogin();
			
		}
		
		// AddEmployee method
		public void AddEmployee(String Fname,String Lname) {
			clickPIM();
			clickAdd();
			enterFirstname(Fname);
			enterLastName(Lname);
			String empID=getEmployeeID();
			clickSave();
		}


}