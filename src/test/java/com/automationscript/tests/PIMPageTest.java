package com.automationscript.tests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationscript.pages.LoginPage;
import com.automationscript.pages.PIMPage;
import com.automationscript.utils.TestBase;

public class PIMPageTest extends TestBase {
	PIMPage pimPage;
	LoginPage loginPage;
	public PIMPageTest() {

		super();// using this it will not throw null pointer exception
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage(driver);
		pimPage = new PIMPage(driver);
	}

	@Test(priority = 1)
	public void AddUserTest() {
		loginPage.login(prop.getProperty("QA_userName"), prop.getProperty("QA_password"));
		pimPage.AddEmployee(prop.getProperty("Fname"), prop.getProperty("Lname"));

	}

	/*
	 * @AfterMethod public void tearDown() { driver.quit(); }
	 */

}
