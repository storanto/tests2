package com.devops.autotests.storanto.assignment;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class LoginTest
{
	  private WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	
	  @Before
	  public void setUp() {
		//String binaryPath = "C:\\Users\\Anton\\AppData\\Local\\Mozilla Firefox\\firefox.exe";
		String binaryPath = System.getProperty("binaryPath");
		 System.out.println("------------------ ATTEMTPING TO USE " + binaryPath);
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary(binaryPath);
		  
	    driver = new FirefoxDriver(options);
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  
    @Test
    public void login() {
    	   driver.get("https://www.saucedemo.com/");
    	   driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
    	   driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
    	   driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
    	   driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
    	   {
    	     List<WebElement> elements = driver.findElements(By.cssSelector(".title"));
    	     assert(elements.size() > 0);
    	   }
    	   {
    	     List<WebElement> elements = driver.findElements(By.cssSelector(".app_logo"));
    	     assert(elements.size() > 0);
    	   }
    }
}
