package com.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SalesForce {
	
	WebDriver driver;
	
	@BeforeClass
	public void init() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation FIles\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	@Test(priority = 0)
	public void login() throws InterruptedException
	{
		driver.findElement(By.id("username")).sendKeys("bittu@ritesh.com");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("Shreyansh@agola2411");
		Thread.sleep(2000);
		driver.findElement(By.id("Login")).click();;
		Thread.sleep(3000);
	}
	@Test(priority = 1)
	public void home() throws InterruptedException
	{
		System.out.println("click on object manager");
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[1]/div[2]/div/div/ul[2]/li[3]/a")).click();
		Thread.sleep(2000);
		System.out.println("clicked on object manager");
	}
//	@Test(priority = 2)
//	public void enaudit() throws InterruptedException
//	{
//		System.out.println("click on energy audit");
//		driver.findElement(By.linkText("Energy Audit")).click();
//		Thread.sleep(2000);
//		System.out.println("clicked on energy audit");
//	}
	@Test(priority = 2)
	public void profile() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"oneHeader\"]/div[2]/span/div[2]/ul/li[8]/span/button")).click();
		Thread.sleep(2000);
	}
//	@Test(priority = 3)
//	public void logout() throws InterruptedException
//	{
//		driver.findElement(By.xpath("//*[@id=\"content_116:13452;a\"]/div/div[2]/div/a[2]")).click();
//		Thread.sleep(2000);
//	}
	@AfterClass
	public void close() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
}
