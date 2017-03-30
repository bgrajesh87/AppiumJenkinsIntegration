package com.java.seleniumtutorials;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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

public class Ten_RightClick {
	WebDriver driver;
	String URL = "http://medialize.github.io/jQuery-contextMenu/demo.html";
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E://selenium-2.53.1//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void rightClick() {
		driver.navigate().to(URL);
		By locator = By.cssSelector(".context-menu-one.btn.btn-neutral");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		rightClickTest(element);
//		WebElement elementEdit = driver.findElement(By.cssSelector(".context-menu-item.icon.icon-edit>span"));
//		elementEdit.click();
//		Alert alert = driver.switchTo().alert();
//		String textEdit = alert.getText();
//		Assert.assertEquals(textEdit, "clicked: edit", "Falied to click on edit link");
	}
	private void rightClickTest(WebElement element) {
		try {
			Actions action = new Actions(driver).contextClick(element);
			action.build().perform();
			System.out.println("Successfully right cliked on the element");
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document");
		}
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
		
	}

