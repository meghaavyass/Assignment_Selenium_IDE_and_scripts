package com.framwork;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CarrerCenter {
	
	@Test
	public String[][] readfile() throws InvalidFormatException, IOException
	{
		String data[][]=null;
		String filepath="D:\\data\\CarrerCenter.xlsx";
		File file=new File(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		Sheet sheet=workbook.getSheet("Sheet1");
		int rows=sheet.getPhysicalNumberOfRows();
		data=new String[rows][];
		for(int i=0;i<data.length;i++)
		{
			Row row=sheet.getRow(i);
			int cols=row.getPhysicalNumberOfCells();
			data[i]=new String[cols];
			for(int j=0;j<data[i].length;j++)
			{
				Cell cell=row.getCell(j);
				cell.setCellType(CellType.STRING);
				data[i][j]=cell.getStringCellValue();
			}
		}
		return data;
	}
	
	WebDriver driver;
	@Test
	
	public void shreyansh() throws InvalidFormatException, IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation FIles\\chromedriver.exe");
		
		String data[][]=readfile();
		for(int i=0;i<data.length;i++)
		{
			driver=new ChromeDriver();
			driver.get("https://careercenter.tops-int.com/");
			Thread.sleep(2000);
			driver.findElement(By.id("mobile")).sendKeys(data[i][0]);
			Thread.sleep(2000);
			driver.findElement(By.id("password")).sendKeys(data[i][1]);
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input.btn.btn-brand.btn-block.w-75.mx-auto")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("profileDropdown")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"main-header\"]/div/div/div[2]/div[1]/ul/li[4]/a")).click();
			Thread.sleep(2000);
			driver.close();
		}
	}
	
	@Test
	public void megha() throws InvalidFormatException, IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation FIles\\chromedriver.exe");
		
		String data[][]=readfile();
		for(int i=0;i<data.length;i++)
		{
			driver=new ChromeDriver();
			
			driver.findElement(By.id("mobile")).sendKeys(data[i][0]);
			Thread.sleep(2000);
			driver.findElement(By.id("password")).sendKeys(data[i][1]);
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input.btn.btn-brand.btn-block.w-75.mx-auto")).click();
			Thread.sleep(2000);
			driver.close();
		}
	}

}


   