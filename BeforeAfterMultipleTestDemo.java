package com.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BeforeAfterMultipleTestDemo {
	
	static ChromeDriver driver=null;
	@BeforeClass
	public static void beforestart() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\champion\\Desktop\\Automation Tools\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
	}
	@Before
	public void beforetest()
	{
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
	@Test
	public void loginpage() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("bittu@ritesh.com");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("Shreyansh@agola2411");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input.r4.fl.mr8")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Login")).click();
		Thread.sleep(2000);
	}
	@Test
	public void homepage() throws InterruptedException
	{
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[1]/div[2]/div/div/ul[2]/li[3]/div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[1]/div[2]/div/div/ul[2]/li[3]/div/div[2]/div/ul/li[5]/a")).click();
		Thread.sleep(5000);
	}
	@After
	public void aftertest()
	{
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
	@AfterClass
	public static void afterfinish() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}

}
