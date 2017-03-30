package com.java.seleniumtutorials;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Eleven_Frames {
	WebDriver driver;
	@BeforeTest
	public void setup() throws Exception {
		  System.setProperty("webdriver.chrome.driver", "E://selenium-2.53.1//chromedriver.exe");
		  driver =new ChromeDriver();     
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.get("http://only-testing-blog.blogspot.in/2015/01/iframe1.html");
		 }
	@Test
	public void handleFrames() {
		driver.findElement(By.xpath("//input[@name='Town']")).sendKeys("NewJersey");
		driver.switchTo().frame("frame1");
		//driver.findElement(By.xpath("//td[contains(text(),'Cow')]/preceding-sibling::td/input[@type='checkbox']")).click();
		driver.findElement(By.xpath(".//*[@id='post-body-3107268830657760720']/div[1]/table/tbody/tr[3]/td[1]/input")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		driver.findElement(By.xpath(".//*[@id='check3']")).click();
		driver.switchTo().defaultContent();
		 driver.findElement(By.xpath("//input[@name='Country']")).sendKeys("USA");
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
