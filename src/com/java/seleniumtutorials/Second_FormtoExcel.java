package com.java.seleniumtutorials;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Second_FormtoExcel {
//	@Test
//	public void readTableData() throws IOException {
//		System.setProperty("webdriver.chrome.driver", "E://selenium-2.53.1//chromedriver.exe");
//		WebDriver dr = new ChromeDriver();
//		
//		dr.get("http://stdcodes.bharatiyamobile.com");
//		dr.manage().window().maximize();
//		dr.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		
//		int rows = dr.findElements(By.xpath("html/body/table/tbody/tr[2]/td/table/tbody/tr/td[1]/table/tbody/tr")).size();	
//		System.out.println("Total rows: "+rows);
//		
//		FileInputStream file = new FileInputStream(new File("C://Users/bgraj/Desktop/Selenium_Training/FormToExcel.xlsx"));
//		XSSFWorkbook workbook = new XSSFWorkbook(file);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		file.close();
//		
//
//		int i=2, k=0;
//		while(i<=rows) {
//			String d1 = dr.findElement(By.xpath("html/body/table/tbody/tr[2]/td/table/tbody/tr/td[1]/table/tbody/tr["+i+"]/td[1]")).getText();
//			String d2 = dr.findElement(By.xpath("html/body/table/tbody/tr[2]/td/table/tbody/tr/td[1]/table/tbody/tr["+i+"]/td[2]")).getText();
//			i++;
//			
//			Row r = sheet.createRow(k++);
//			r.createCell(0).setCellValue(d1);
//			r.createCell(1).setCellValue(d2);
//			
//		}
//		FileOutputStream outfile = new FileOutputStream(new File("C://Users/bgraj/Desktop/Selenium_Training/FormToExcel.xlsx"));
//		workbook.write(outfile);
//		outfile.close();
//		dr.quit();
//	}
		
		@Test
		public void readTableData1() throws IOException, InterruptedException {
			System.setProperty("webdriver.chrome.driver", "E://selenium-2.53.1//chromedriver.exe");
			WebDriver dr1 = new ChromeDriver();
			
			dr1.get("http://stdcodes.bharatiyamobile.com");
			dr1.manage().window().maximize();
			dr1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			dr1.findElement(By.linkText("Andhra Pradesh")).click();
			
			int rows1 = dr1.findElements(By.xpath("html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr")).size();
			System.out.println("Total rows: "+rows1);
			
			FileInputStream file1 = new FileInputStream(new File("C://Users/bgraj/Desktop/Selenium_Training/FormToExcel.xlsx"));
		    XSSFWorkbook workbook1 = new XSSFWorkbook(file1);
		    XSSFSheet sh = workbook1.getSheetAt(1);
		    file1.close();
		    
		    int i=2, k=0, pos=2;
		    rows1 = 728;
		    while(i<rows1) {
		    	String s1 = dr1.findElement(By.xpath("html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr["+pos+"]/td[1]")).getText();
		    	String s2 = dr1.findElement(By.xpath("html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr["+pos+"]/td[2]")).getText();
		    	i++;								 
		    	pos++;
		    	//System.out.println("Row No: "+i+ " "+s1+" "+s2);
		    	
		    	Row r1 =sh.createRow(k++);
		    	r1.createCell(0).setCellValue(s1);
		    	r1.createCell(1).setCellValue(s2);
		   
		    	if(i == 50 && pos == 50) {
		    		dr1.findElement(By.xpath("html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a/span")).click();
		    		pos=2;					 
		    	}
		    	if(i>51 && pos == 50) {
		    		dr1.findElement(By.xpath("html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a[2]/span")).click();
		    		pos=2;					 
		       	}
		    }
		    Thread.sleep(2000);
		    
		    FileOutputStream outfile = new FileOutputStream(new File("C://Users/bgraj/Desktop/Selenium_Training/FormToExcel.xlsx"));
		    workbook1.write(outfile);
		    outfile.close();
		    
		    dr1.close();
		    }
		   		}

	
	

