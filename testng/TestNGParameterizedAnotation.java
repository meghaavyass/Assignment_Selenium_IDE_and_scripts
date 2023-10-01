package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameterizedAnotation {
	
	WebDriver driver;
	
	@BeforeClass
	public void ini() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation FIles\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.lubipumps.com/contact-us/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
	}

	@Test
	@Parameters({"fname", "lname", "phone", "email", "address", "state", "cname", "msg"})
	public void form(String fname, String lname, String phone, String email, String address, String state, String cname, String msg) throws InterruptedException 
	{
		driver.findElement(By.id("id_first_name")).sendKeys(fname);
		Thread.sleep(1000);
		driver.findElement(By.id("id_last_name")).sendKeys(lname);
		Thread.sleep(1000);
		driver.findElement(By.name("phone")).sendKeys(phone);
		Thread.sleep(1000);
		driver.findElement(By.name("email")).sendKeys(email);
		Thread.sleep(1000);
		driver.findElement(By.name("address")).sendKeys(address);
		Thread.sleep(1000);
		driver.findElement(By.name("state")).sendKeys(state);
		Thread.sleep(1000);
		Select dropdown=new Select(driver.findElement(By.id("id_inquiry_for")));
		dropdown.selectByValue("135");
		Thread.sleep(3000);
		driver.findElement(By.name("company_name")).sendKeys(cname);
		Thread.sleep(1000);
		driver.findElement(By.name("message")).sendKeys(msg);
		Thread.sleep(1000);
	}
	@AfterClass
	public void close() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
}
