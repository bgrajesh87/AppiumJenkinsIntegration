package com.java.seleniumtutorials;

import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class First_Fill_Form {
	
	@Test
	public void fill_Form() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E://selenium-2.53.1//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.mycontactform.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Sample Forms")).click();
		
		List<WebElement> chk1 = driver.findElements(By.name("email_to[]"));
		chk1.get(1).click();
		
		driver.findElement(By.name("subject")).sendKeys("Testing");
		driver.findElement(By.id("email")).sendKeys("test_selenium@test.com");
		driver.findElement(By.id("q1")).sendKeys("worked as test lead");
		driver.findElement(By.name("q2")).sendKeys("Looking for QA automation positions");
		
		WebElement slct1 = driver.findElement(By.cssSelector("#q3 option:nth-child(2)"));
		slct1.click();
		
		List<WebElement> rdbtn1 = driver.findElements(By.name("q4"));
		rdbtn1.get(1).click();
		
		List<WebElement> chk2 = driver.findElements(By.name("checkbox6[]"));
		chk2.get(1).click();
		
		WebElement myoption2 = driver.findElement(By.cssSelector("#q8 option[value='NJ']"));
		myoption2.click();

		Select slct2 = new Select(driver.findElement(By.id("q9")));
		slct2.selectByIndex(1);
		
		WebElement myoption3 = driver.findElement(By.cssSelector("#q10 option[value='Ontario']"));
		myoption3.click();
		
		Select slct3 = new Select(driver.findElement(By.name("q11_title")));
		slct3.selectByIndex(3);
		driver.findElement(By.name("q11_first")).sendKeys("Rajesh Kumar");
		driver.findElement(By.name("q11_last")).sendKeys("Kumar");
		
		Select month = new Select(driver.findElement(By.name("q12_month")));
		month.selectByIndex(11);
		Select day = new Select(driver.findElement(By.name("q12_day")));
		day.selectByVisibleText("16");
		Select year = new Select(driver.findElement(By.name("q12_year")));
		year.selectByVisibleText("1987");
		
		Thread.sleep(10000);
		
		driver.findElement(By.name("submit")).click();		
		
	}

}
