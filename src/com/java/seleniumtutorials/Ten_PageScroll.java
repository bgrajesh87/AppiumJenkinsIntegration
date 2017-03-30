package com.java.seleniumtutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Ten_PageScroll {
	WebDriver driver;
	String URL = "https://www.linkedin.com/";
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E://selenium-2.53.1//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void test1() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "E://selenium-2.53.1//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://jqueryui.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("scroll(0,900)");
		
	}
	@Test(priority = 1)
	public void scrollToBottom() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)","");
		}
	@Test(priority = 2)
	public void scrollToElement() throws InterruptedException {
		driver.navigate().to("http://jqueryui.com/droppable/");
		WebElement element = driver.findElement(By.linkText("Dialog"));
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
	}
	@Test(priority = 3)
	public void scrollByCoordinates() throws InterruptedException {
		driver.navigate().to(URL+"job/?trk=hb_ft_jobs");
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)","");
	}
	@Test(priority=4)
	public void scrollByUsingKeys() throws InterruptedException {
		driver.navigate().to(URL+"jobs/?trk=hb_ft_jobs");
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(5000);
		action.click(driver.findElement(By.partialLinkText("Dave Ker"))).perform();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
