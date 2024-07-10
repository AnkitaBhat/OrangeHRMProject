package com.utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WebElement implements ConstantValue {
	protected ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public ThreadLocal<Integer> noOfRecords=new ThreadLocal<Integer>();

	/*
	 * public boolean visibilityofElement(String xpath) { try { Wait<WebDriver> wait
	 * = new
	 * FluentWait<WebDriver>(driver.get()).withTimeout(Duration.ofSeconds(120))
	 * .pollingEvery(Duration.ofSeconds(10)).ignoring(Exception.class);
	 * 
	 * return true; } catch (Exception e) { // TODO: handle exception return false;
	 * } }
	 */

	
	public boolean clickToElement(String xpath) {
		try {
			driver.get().findElement(By.xpath(xpath)).click();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean enterToText(String xpath, String value) {
		try {
			driver.get().findElement(By.xpath(xpath)).sendKeys(value);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean get(String url) {
		try {
			driver.get().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.get().manage().window().maximize();
			driver.get().get(url);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	
	
	

	
}
