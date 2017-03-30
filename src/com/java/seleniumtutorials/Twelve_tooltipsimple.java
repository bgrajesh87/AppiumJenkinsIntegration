package com.java.seleniumtutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Twelve_tooltipsimple {
	String seleniumURL =  "http://docs.seleniumhq.org";
	String jQueryURL = "https://jqueryui.com/tooltip/";
	public WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E://selenium-2.53.1//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void toolTipcase1() {
		driver.navigate().to(seleniumURL);
		WebElement element = driver.findElement(By.cssSelector("#header>h1 a"));
		String tooltipText = element.getAttribute("title");
		System.out.println("Tooltip text is "+tooltipText);
		
		Assert.assertEquals("return to selenium home page", tooltipText);
	}
	
	@Test
	public void toolTipcase2() {
		driver.navigate().to(jQueryURL);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
		
		WebElement element = driver.findElement(By.id("age"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		WebElement toolTipElement = driver.findElement(By.cssSelector(".ui-tooltip"));
		
		String tooltipMsg = toolTipElement.getText();
		Assert.assertEquals("We ask for your age only for statistical purposes.", tooltipMsg);
	}
	
	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
}


