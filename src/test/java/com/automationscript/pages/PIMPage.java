package com.automationscript.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automationscript.utils.TestBase;

public class PIMPage extends TestBase {
WebDriver driver;

By PIM=By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span");

By addButton=By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");

By firstName=By.name("firstName");

By lastName=By.name("lastName");

By SaveButton=By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");

By employeeId=By.xpath("(//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//following-sibling::input[@class='oxd-input oxd-input--active'])[1]");

By employeeName=By.xpath("(//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active'])[1]");

//By searchButton=By.xpath(")

public PIMPage(WebDriver driver) {
	this.driver=driver;
}


//method to enter First Name
public void enterFirstname(String Fname) {
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(firstName));
	driver.findElement(firstName).sendKeys(Fname);
}

//Method to enter Last Name
public void enterLastName(String Lname) {
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));

	wait.until(ExpectedConditions.elementToBeClickable(lastName));
	driver.findElement(lastName).sendKeys(Lname,Keys.TAB);
}

/*
 * public void enterEmployeeName(String Ename) {
 * 
 * driver.findElement(Ename).sendKeys(Lname,Keys.TAB); }
 */
//Method to get Employee ID

public String getEmployeeID() {

	
	String empID=driver.findElement(employeeId).getText();
	System.out.println("++++++++++++++++++++"+empID);
	return empID;
}

public void clickSave() {
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));

	wait.until(ExpectedConditions.elementToBeClickable(SaveButton));
	driver.findElement(SaveButton).click();
}

public void clickPIM() {
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(PIM));
	driver.findElement(PIM).click();
}

public void clickAdd() {
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(addButton));
	driver.findElement(addButton).click();
}

//AddEmployee method
		public void AddEmployee(String Fname,String Lname) {
			clickPIM();
			clickAdd();
			enterFirstname(Fname);
			enterLastName(Lname);
			clickSave();
			//String empID=getEmployeeID();
			clickPIM();
			driver.findElement(employeeName).sendKeys(Fname+" "+Lname);
			//driver.findElement(PIM)
			

		}
 
}
