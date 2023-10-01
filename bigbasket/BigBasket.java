package com.bigbasket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BigBasket {
	
	WebDriver driver;
	
	@BeforeClass
	public void geturl() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation FIles\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}
	@Test
	public void addqun() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"input\"]")).sendKeys("Carrot - Orange (Loose)");
		Thread.sleep(2000);
	}
	@Test
	public void search() throws InterruptedException
	{
		driver.findElement(By.cssSelector("button.btn.btn-default.bb-search")).click();
		Thread.sleep(2000);
	}
	@AfterClass
	public void closeurl()
	{
		driver.close();
	}
}

//<?xml version="1.0" encoding="UTF-8"?>
//<suite parallel="false" name="Suite">
//
//  <test name="BigBasket">
//  <classes>
//  <class name="com.bigbasket.BigBasket"/>
//  </classes>
//  </test>
//  
//  <test name="SnapDeal">
//  <classes>
//  <class name="com.snapdeal.SnapDeal"/>
//  </classes>
//  </test>
//  
//</suite> <!-- Suite -->

