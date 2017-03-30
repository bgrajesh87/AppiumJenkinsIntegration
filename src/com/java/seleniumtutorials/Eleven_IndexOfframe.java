package com.java.seleniumtutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Eleven_IndexOfframe {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E://selenium-2.53.1//chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.get("http://www.guru99.com/selenium-tutorial.html");  
		 driver.manage().window().maximize();
		 
		 int size = driver.findElements(By.tagName("iframe")).size();
		 System.out.println("Total frames are: "+size);
		 
		 for(int i=0; i<=size; i++) {
			 driver.switchTo().frame(i);
			 int total = driver.findElements(By.xpath("html/body/a/img")).size();
			 System.out.println(total);
			 driver.switchTo().defaultContent();
		 }
	}
}
