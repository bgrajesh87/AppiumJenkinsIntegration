package com.java.seleniumtutorials;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Fifteen_Screenshot {
	WebDriver driver;
	
	@Test
	public void captureScreenshot() {
		System.setProperty("webdriver.chrome.driver", "E://selenium-2.53.1//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath(".//*[@id='emailasdasdas']")).sendKeys("Rajesh");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			try {
				TakesScreenshot ts =(TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source, new File("C://Users//bgraj//Desktop//ScreenShots//"+result.getName()+".png"));
				System.out.println("Screenshot taken");
			} catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
			}
			driver.quit();
		}
	}
}
