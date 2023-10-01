package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedAnotation {
	
	WebDriver driver;
	
	@BeforeClass
	public void geturl() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation FIles\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://careercenter.tops-int.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
	}

	@Test
	@Parameters({"author", "username", "password"})
	public void login(String author, String username, String password) throws InterruptedException 
	{
		driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input.btn.btn-brand.btn-block.w-75.mx-auto")).click();
		Thread.sleep(4000);
		System.out.println("welcome "+(author)+" your username : "+(username)+" and password : "+(password)+" you are sucessfully logedin");
	}
	
	
	@AfterClass
	public void close()
	{
		driver.close();
	}
}
