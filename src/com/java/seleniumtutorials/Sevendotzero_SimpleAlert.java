package com.java.seleniumtutorials;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sevendotzero_SimpleAlert {
	
	@Test
	public void simple_alert() {
		System.setProperty("webdriver.chrome.driver", "E://selenium-2.53.1//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='content']/p[4]/button")).click();
		
		Alert simplealert = driver.switchTo().alert();
		String alertText = simplealert.getText();
		System.out.println("Alert text is: " +alertText);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		simplealert.accept();
	}
}
