package com.java.seleniumtutorials;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sevendotthree_Alert {
	
	@Test
	public static void alertDemcEx() throws InterruptedException {	
		System.setProperty("webdriver.chrome.driver", "E://selenium-2.53.1//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/V4/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("uid")).sendKeys("mngr67094");
		driver.findElement(By.name("password")).sendKeys("yqypuhA");
		driver.findElement(By.name("btnLogin")).submit();
		driver.findElement(By.linkText("Delete Customer")).click();
		driver.findElement(By.name("cusid")).sendKeys("mngr53920");
		driver.findElement(By.name("AccSubmit")).click();
		
		//switching to alert
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		Thread.sleep(4000);
		alert.accept();
	}
}
