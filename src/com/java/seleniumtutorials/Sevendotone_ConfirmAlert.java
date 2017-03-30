package com.java.seleniumtutorials;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sevendotone_ConfirmAlert {
	
	@Test
	public void confirm_alert() {
		System.setProperty("webdriver.chrome.driver", "E://selenium-2.53.1//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/");
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.xpath("//*[@id='content']/p[8]/button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		
		Alert confirmalert = driver.switchTo().alert();
		String alertText = confirmalert.getText();
		System.out.println("Alert text is " +alertText);
		confirmalert.dismiss();
		
	}
}
