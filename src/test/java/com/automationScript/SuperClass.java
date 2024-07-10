package com.automationScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SuperClass {
	public ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver drive = null;

	@BeforeMethod
	public void setup() {
		drive = new ChromeDriver();
		driver.set(drive);
		driver.get().manage().window().maximize();

	}

	@AfterMethod
	public void quiteBrowser() {
		driver.get().quit();;

	}
}
