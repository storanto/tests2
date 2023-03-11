package com.devops.autotests.storanto.assignment;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class FlowTest {
private WebDriver driver;
private Map<String, Object> vars;
JavascriptExecutor js;
@Before
public void setUp() {
//String binaryPath = "C:\\Users\\Anton\\AppData\\Local\\Mozilla Firefox\\firefox.exe";
String binaryPath = System.getProperty("binaryPath");
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
public void flow() {
 driver.get("https://www.saucedemo.com/");
 driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
 driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
 driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
 driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
 {
   List<WebElement> elements = driver.findElements(By.cssSelector("*[data-test=\"login-button\"]"));
   assert(elements.size() == 0);
 }
 driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-backpack\"]")).click();
 driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
 driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
 driver.findElement(By.cssSelector("*[data-test=\"remove-sauce-labs-bolt-t-shirt\"]")).click();
 driver.findElement(By.cssSelector(".shopping_cart_badge")).click();
 driver.findElement(By.cssSelector("*[data-test=\"continue-shopping\"]")).click();
 driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-bike-light\"]")).click();
 driver.findElement(By.linkText("3")).click();
 driver.findElement(By.cssSelector("*[data-test=\"checkout\"]")).click();
 driver.findElement(By.cssSelector("*[data-test=\"firstName\"]")).click();
 driver.findElement(By.cssSelector("*[data-test=\"firstName\"]")).sendKeys("fname");
 driver.findElement(By.cssSelector("*[data-test=\"lastName\"]")).sendKeys("lname");
 driver.findElement(By.cssSelector("*[data-test=\"postalCode\"]")).sendKeys("01010");
 driver.findElement(By.cssSelector("*[data-test=\"continue\"]")).click();
 driver.findElement(By.cssSelector("*[data-test=\"finish\"]")).click();
 {
   List<WebElement> elements = driver.findElements(By.xpath("//h2[contains(.,\'Thank you for your order!\')]"));
   assert(elements.size() > 0);
 }
 driver.findElement(By.cssSelector("*[data-test=\"back-to-products\"]")).click();
}
}
