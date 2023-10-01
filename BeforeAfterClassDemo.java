package com.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BeforeAfterClassDemo {
	
	static ChromeDriver driver=null;
	//we have to put static method as Chromedriver driver=new Chromedriver();
	@BeforeClass
	public static void beforeclass() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\champion\\Desktop\\Automation Tools\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://careercenter.tops-int.com/");
		Thread.sleep(2000);
	}
	@Before
	public void beforetest()
	{
		System.out.println(driver.getCurrentUrl());
	}
	@Test
	public void login() throws InterruptedException
	{
		driver.findElement(By.id("mobile")).sendKeys("9157238002");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("9157238002");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/ul/li[2]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/ul/li[4]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/ul/li[5]/a")).click();
		Thread.sleep(5000);
		System.out.println("Open Dropdown");
		driver.findElement(By.xpath("//*[@id=\"profileDropdown\"]")).click();
		Thread.sleep(2000);
		System.out.println("Clicked on Dropdown");
		System.out.println("Click on Logout");
		driver.findElement(By.xpath("//*[@id=\"main-header\"]/div/div/div[2]/div[1]/ul/li[4]/a")).click();
		Thread.sleep(2000);
		System.out.println("Clicked on Logout");
	}
	@Test
	public void logout() throws InterruptedException
	{
		
	}
	@After
	public void aftertest()
	{
		System.out.println(driver.getCurrentUrl());
	}
	@AfterClass
	public static void afterclass()
	{
		driver.close();
	}
}
