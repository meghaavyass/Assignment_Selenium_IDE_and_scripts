package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SauceDemo {
 
	WebDriver driver;
	
	@BeforeClass
	public void init() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation FIles\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	@Test(priority = 0)
	public void login() throws InterruptedException
	{
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(2000);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(4000);
	}
	@Test(priority = 1)
	public void addtocart() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")).click();
		Thread.sleep(2000);
	}
	@Test(priority = 2)
	public void logout() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
		Thread.sleep(2000);
	}
	@AfterClass
	public void close() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
}

//we should create xml file when we are create class
//<test name="SauceDemo">
//<classes>
//  <class name="com.saucedemo.SauceDemo"/>
//</classes>
//</test> <!-- Test -->
//
//<test name="SalesForce">
//<classes>
//  <class name="com.salesforce.SalesForce"/>
//</classes>
//</test>