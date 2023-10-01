package com.swaglab;

import java.io.File;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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

public class SwagLab {
	
	@Test
	public String[][] fileread() throws InvalidFormatException, IOException
	{
		String data[][]=null;
		String filepath="D:\\data\\SwagLab.xlsx";
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
	public void login() throws InvalidFormatException, IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation FIles\\chromedriver.exe");
		String data[][]=fileread();
		for(int i=0;i<data.length;i++)
		{
			driver=new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			Thread.sleep(1000);
			driver.findElement(By.id("user-name")).sendKeys(data[i][0]);
			Thread.sleep(1000);
			driver.findElement(By.id("password")).sendKeys(data[i][1]);
			Thread.sleep(1000);
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(2000);
			driver.close();
		}
		
	}

}
