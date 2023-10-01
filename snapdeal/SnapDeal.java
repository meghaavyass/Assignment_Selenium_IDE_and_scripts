package com.snapdeal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SnapDeal {
	
	WebDriver driver;
	
	@BeforeClass
	public void geturl() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation FIles\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	@Test
	public void inputtext() throws InterruptedException
	{
		driver.findElement(By.id("pincode-check-nba")).sendKeys("382449");
		Thread.sleep(2000);
	}
	@Test
	public void submit() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"stack_yuda\"]/li[1]/div[7]/button[1]")).click();
		Thread.sleep(2000);
	}
	@AfterClass
	public void close()
	{
		driver.close();
	}
  
}
