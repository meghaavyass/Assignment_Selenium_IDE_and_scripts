package com.assesment;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserID {
	
	@DataProvider(name="Assesment")
	public String[][] readfile() throws InvalidFormatException, IOException
	{
		String[][] data=null;
		String filepath="D:\\data\\AssesmentFile.xlsx";
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
	
	@Test(dataProvider ="Assesment")
	public void test(String keyword, String data) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation FIles\\chromedriver.exe");
		
		if(keyword.equals("open browser"))
		{
			driver=new ChromeDriver();
			Thread.sleep(1000);
		}
		else if(keyword.equals("enter url"))
		{
			driver.get(data);
			Thread.sleep(1000);
		}
		else if(keyword.equals("enter username"))
		{
			driver.findElement(By.name("uid")).sendKeys(data);
			Thread.sleep(1000);
		}
		else if(keyword.equals("enter password"))
		{
			driver.findElement(By.name("password")).sendKeys(data);
			Thread.sleep(1000);
		}
		else if(keyword.equals("click on login"))
		{
			driver.findElement(By.name("btnLogin")).click();
			Thread.sleep(1000);
		}
		else if(keyword.equals("close browser"))
		{
			driver.close();
		}
		
	}
 
}
