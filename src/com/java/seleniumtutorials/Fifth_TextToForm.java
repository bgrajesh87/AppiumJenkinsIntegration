package com.java.seleniumtutorials;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Fifth_TextToForm {
	
	@Test
	public void fill_Data() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E://selenium-2.53.1//chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		dr.get("http://www.mycontactform.com/");
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dr.manage().window().maximize();
		dr.findElement(By.linkText("Sample Forms")).click();
		
		FileReader file = new FileReader("C://Users//bgraj//Desktop//Selenium_Training//data1.txt");
		BufferedReader bfr = new BufferedReader(file);
		String x = " ";
		
		while((x=bfr.readLine())!=null) {
			Thread.sleep(1000);
			dr.navigate().refresh();
			
			String[] data = x.split(",");
			
			int no = Integer.parseInt(data[0]);
			dr.findElement(By.xpath(".//*[@id='contactForm']/table/tbody/tr[1]/td/div/input["+no+"]")).click();
			
			dr.findElement(By.id("subject")).sendKeys(data[1]);
			dr.findElement(By.id("email")).sendKeys(data[2]);
			dr.findElement(By.id("q1")).sendKeys(data[3]);
			
			no = Integer.parseInt(data[4]);
			Select sc1 = new Select(dr.findElement(By.name("q3")));
			sc1.selectByIndex(no);
			
			int no1 = Integer.parseInt(data[5]);
			dr.findElement(By.xpath("/html/body/div[3]/div[3]/form/table/tbody/tr[7]/td/div[1]/input["+no1+"]")).click();
			
			int no_chk=Integer.parseInt(data[6]);
			dr.findElement(By.xpath("/html/body/div[3]/div[3]/form/table/tbody/tr[9]/td/div[1]/input["+no_chk+"]")).click();
			
			Select sc2 = new Select(dr.findElement(By.name("q8")));
			sc2.selectByVisibleText(data[7]);
			
			Select sc3 = new Select(dr.findElement(By.name("q9")));
			sc3.selectByVisibleText(data[8]);
			
			Select sc4 = new Select(dr.findElement(By.name("q10")));
			sc4.selectByVisibleText(data[9]);
			
			dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			Select sc5 = new Select(dr.findElement(By.name("q11_title")));
			sc5.selectByVisibleText(data[10]);
			
			dr.findElement(By.name("q11_first")).sendKeys(data[11]);
			
			dr.findElement(By.name("q11_last")).sendKeys(data[12]);
			
			Select month = new Select(dr.findElement(By.name("q12_month")));
			month.selectByVisibleText(data[13]);
			
			Select day = new Select(dr.findElement(By.name("q12_day")));
			day.selectByVisibleText(data[14]);
			
			dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			Select year = new Select(dr.findElement(By.name("q12_year")));
			year.selectByVisibleText(data[15].trim());
			
			dr.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
			
		}
	}
}
