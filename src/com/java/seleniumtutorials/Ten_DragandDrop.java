package com.java.seleniumtutorials;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ten_DragandDrop {
	WebDriver driver;
//	@Test
//	public void testDragandDrop() {
//		System.setProperty("webdriver.chrome.driver", "E://selenium-2.53.1//chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.navigate().to("http://jqueryui.com/droppable/");
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
//		WebElement sourceLocator = driver.findElement(By.cssSelector("#draggable"));
//		WebElement destinationLocator = driver.findElement(By.cssSelector("#droppable"));
//		dragAndDrop(sourceLocator, destinationLocator);
//		String actualText = driver.findElement(By.cssSelector("#droppable>p")).getText();
//		Assert.assertEquals(actualText, "Dropped!");
//		driver.close();
//	}
//	private void dragAndDrop(WebElement sourceLocator, WebElement destinationLocator) {
//		(new Actions(driver)).dragAndDrop(sourceLocator,destinationLocator).perform();
//		
//	}

	
	@Test
	public void testDragAndDrop() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E://selenium-2.53.1//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement dragElement = driver.findElement(By.cssSelector("#draggable"));
		WebElement dropElement = driver.findElement(By.cssSelector("#droppable"));
		
		Actions builder = new Actions(driver);
		Action dragAndDrop = (Action) builder.clickAndHold(dragElement).moveToElement(dropElement).release(dropElement).build();
		dragAndDrop.perform();
	}
	
}
