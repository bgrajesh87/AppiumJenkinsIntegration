package com.java.seleniumtutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Twelve_tooltip {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E://selenium-2.53.1//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default");
		driver.findElement(By.xpath(".//*[@id='GmailAddress']")).click();
		
		Actions builder = new Actions(driver);
		WebElement username_tooltip = driver.findElement(By.xpath("html/body/div[3]"));
		builder.moveToElement(username_tooltip).perform();
		
		String tooltip_msg = username_tooltip.getText();
		System.out.println("Tooltip message is "+tooltip_msg);
	}
}
