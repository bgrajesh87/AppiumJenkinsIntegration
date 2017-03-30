package com.java.seleniumtutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Eleven_simpleIframe {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E://selenium-2.53.1//chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.get("http://www.guru99.com/selenium-tutorial.html");
		driver.manage().window().maximize();
		
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total frames are: "+size);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("html/body/a/img")).click();
	}
}
