package com.java.seleniumtutorials;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Fourth_ExceltoForm {
	
	@Test
	public void excelToForm() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E://selenium-2.53.1//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://www.mycontactform.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sample Forms")).click();
		
		String excelFilePath = "C://Users//bgraj//Desktop//Selenium_Training//ExcelToForm_data.xlsx";
		FileInputStream inputstream = new FileInputStream(new File(excelFilePath));
		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		for(int i=1; i<=3; i++) {
			Thread.sleep(1000);
			driver.navigate().refresh();
			
			Row r = sheet.getRow(i);
			Cell c;
			
			int no = (int) r.getCell(0).getNumericCellValue();
			driver.findElement(By.xpath("/html/body/div[3]/div[3]/form/table/tbody/tr[1]/td/div/input["+no+"]")).click();
			
			c=r.getCell(1);
			driver.findElement(By.id("subject")).sendKeys(c.getStringCellValue());
			
			c=r.getCell(2);
			driver.findElement(By.id("email")).sendKeys(c.getStringCellValue());
			
			c=r.getCell(3);
			driver.findElement(By.id("q1")).sendKeys(c.getStringCellValue());
			
			c=r.getCell(4);
			Select sc1 = new Select(driver.findElement(By.id("q3")));
			sc1.selectByVisibleText(c.getStringCellValue());
			
			no = (int) r.getCell(5).getNumericCellValue();
			driver.findElement(By.xpath("/html/body/div[3]/div[3]/form/table/tbody/tr[7]/td/div[1]/input["+no+"]")).click();
			
			no = (int) r.getCell(6).getNumericCellValue();
			driver.findElement(By.xpath("/html/body/div[3]/div[3]/form/table/tbody/tr[9]/td/div[1]/input["+no+"]")).click();
			
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		    
			c=r.getCell(7);
			Select sc2 = new Select(driver.findElement(By.name("q8")));
			sc2.selectByVisibleText(c.getStringCellValue());
			
			c=r.getCell(8);
			Select sc3 = new Select(driver.findElement(By.name("q9")));
			sc3.selectByVisibleText(c.getStringCellValue());
			
			c=r.getCell(9);
			Select sc4 = new Select(driver.findElement(By.name("q10")));
			sc4.selectByVisibleText(c.getStringCellValue());
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			c=r.getCell(10);
			Select sc5 = new Select(driver.findElement(By.name("q11_title")));
			sc5.selectByVisibleText(c.getStringCellValue());
			
			c=r.getCell(11);
			driver.findElement(By.name("q11_first")).sendKeys(c.getStringCellValue());
			
			c=r.getCell(12);
			driver.findElement(By.name("q11_last")).sendKeys(c.getStringCellValue());
			
					
		    c=r.getCell(13);
			Select month=new Select(driver.findElement(By.name("q12_month")));
     		month.selectByIndex((int)c.getNumericCellValue()-1);
			
			c=r.getCell(14);
			Select day=new Select(driver.findElement(By.name("q12_day")));
			day.selectByIndex((int)c.getNumericCellValue()-1);
			
			c=r.getCell(15);
			Select year=new Select(driver.findElement(By.name("q12_year")));
			int s=(int) c.getNumericCellValue();
			String ss=String.valueOf(s);
			year.selectByVisibleText(ss);
			   
	   }
   workbook.close();
   inputstream.close();
		
		
	}
}
