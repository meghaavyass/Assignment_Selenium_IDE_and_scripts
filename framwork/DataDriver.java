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

public class DataDriver {
	
	@Test
	public String[][] readexcle() throws InvalidFormatException, IOException
	{
		String data[][]=null;
		//two dimential array ma data aatyare null rakhyo che
		String filepath="D:\\data\\Framwork.xlsx";
		//new version hoy excle nu to .xlsx extension lakhay
		//excle no filepath aapyo
		File file=new File(filepath);
		//inbuilt java.io no class che File karine eena lidhe filepath per jaine file open kari
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		//workbook open thai eene store kari
		Sheet sheet=workbook.getSheet("Sheet1");
		//inbulit java.ss.io no class che eema this seet1 per apdo data che so eene sheet object ma store karavi
		
		int rows=sheet.getPhysicalNumberOfRows();
		//sheet ma particular lakheli row read karvi hoy to getphysicalnumberofrows use karvu pade
		System.out.println("Total Number Of Rows : "+rows);
		data=new String[rows][];
		//data null hato bt have aapdi jode rows che so rows ne read karavi 
		for(int i=0;i<data.length;i++)
		{
			Row row=sheet.getRow(i);
			//Row inbuilt class che ss vado, eema je physical number vadi rows harti eema first row get karavi
			int cols=row.getPhysicalNumberOfCells();
			//row per thi column ne read karavi
			System.out.println("Total Number Of Columns : "+cols);
			data[i]=new String[cols];
			//i aatyare first time 0 che so eema cols ne read karavi
			
			for(int j=0;j<data[i].length;j++)
				//row eek select thay tyare ee row ni j coloumn select kare eena mate data[0] and eeni column
			{
				Cell cell=row.getCell(j);
				//0 number ni row ma 0 number column and ee banne no cell get karva
				cell.setCellType(CellType.STRING);
				//cell ni datatype change kari
				data[i][j]=cell.getStringCellValue();
				//finally value get kari aakhi cell ni 
			}
		}
		return data;
		
	}
	
	WebDriver driver;
	@Test
	public void test() throws InvalidFormatException, IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation FIles\\chromedriver.exe");
		
		String[][] data=readexcle();
		for(int i=0;i<data.length;i++)
		{
			driver=new ChromeDriver();
			driver.get("https://www.saucedemo.com/v1/");
			Thread.sleep(2000);
			driver.manage().window().maximize();
			driver.findElement(By.id("user-name")).sendKeys(data[i][0]);
			Thread.sleep(2000);
			driver.findElement(By.id("password")).sendKeys(data[i][1]);
			Thread.sleep(2000);
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(2000);
			driver.close();
		}
	}

}
