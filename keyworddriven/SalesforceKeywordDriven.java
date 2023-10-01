package com.keyworddriven;

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

public class SalesforceKeywordDriven {
	
	@DataProvider(name="salesforce")
	public Object[][] readfile() throws InvalidFormatException, IOException
	{
		Object data[][]=null;
		String filepath="D:\\data\\Salesforce.xlsx";
		File file=new File(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		Sheet sheet=workbook.getSheet("Sheet2");
		int rows=sheet.getPhysicalNumberOfRows();
		data=new Object[rows][];
		for(int i=0;i<data.length;i++)
		{
			Row row=sheet.getRow(i);
			int cols=row.getPhysicalNumberOfCells();
			data[i]=new Object[cols];
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
	@DataProvider(name="Salesforce")
	public void test(String keyword) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation FIles\\chromedriver.exe");
		if(keyword.equals("open browser"))
		{
			driver=new ChromeDriver();
			Thread.sleep(2000);
		}
		else if(keyword.equals("enter url"))
		{
			driver.get("https://login.salesforce.com/");
			Thread.sleep(2000);
		}
		else if(keyword.equals("enter username"))
		{
			driver.findElement(By.id("username")).sendKeys("bittu@ritesh.com");
			Thread.sleep(1000);
		}
		else if(keyword.equals("enter password"))
		{
			driver.findElement(By.id("password")).sendKeys("Shreyansh@agola2411");
			Thread.sleep(1000);
		}
		else if(keyword.equals("click login"))
		{
			driver.findElement(By.id("Login")).click();
		}
		else if(keyword.equals("close browser"))
		{
			driver.close();
		}
	}

}
