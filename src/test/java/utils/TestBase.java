package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestBase {

	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources"
					+ "/config/login.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			driver = new FirefoxDriver(); 
		}
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("QA_URL"));
		try {
			Thread.sleep(5000);
			/*
			 * WebElement username=driver.findElement(By.name("username")); Wait<WebDriver>
			 * wait = new WebDriverWait(driver, Duration.ofSeconds(2)); wait.until(d ->
			 * username.isDisplayed()); username.sendKeys("Admin"); WebElement
			 * password=driver.findElement(By.xpath("//input[@name='password']"));
			 * password.sendKeys("admin123");
			 * 
			 * WebElement
			 * submitElement=driver.findElement(By.xpath("//button[@type='submit']"));
			 * submitElement.submit();
			 */
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
