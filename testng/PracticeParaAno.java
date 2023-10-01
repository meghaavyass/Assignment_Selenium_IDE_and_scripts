package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PracticeParaAno {
	
	WebDriver driver;
	
	@BeforeClass
	public void geturl() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation FIles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		Thread.sleep(2000);
		driver.manage().window().maximize();
	}

	@Test
	@Parameters({"author", "fname", "lname", "phone", "email", "address", "city", "state", "pcode"})
	public void form(String author, String fname, String lname, String phone, String email, String address, String city, String state, String pcode) throws InterruptedException 
	{
		driver.findElement(By.name("firstName")).sendKeys(fname);
		Thread.sleep(2000);
		driver.findElement(By.name("lastName")).sendKeys(lname);;
		Thread.sleep(2000);
		driver.findElement(By.name("phone")).sendKeys(phone);;
		Thread.sleep(2000);
		driver.findElement(By.name("userName")).sendKeys(email);;
		Thread.sleep(2000);
		driver.findElement(By.name("address1")).sendKeys(address);;
		Thread.sleep(2000);
		driver.findElement(By.name("city")).sendKeys(city);;
		Thread.sleep(2000);
		driver.findElement(By.name("state")).sendKeys(state);;
		Thread.sleep(2000);
		driver.findElement(By.name("postalCode")).sendKeys(pcode);;
		Thread.sleep(2000);
		
		System.out.println("welcome : "+author);
		System.out.println("your inputs is : ");
		System.out.println("first name : "+fname);
		System.out.println("last name : "+lname);
		System.out.println("phone : "+phone);
		System.out.println("email : "+email);
		System.out.println("address : "+address);
		System.out.println("city : "+city);
		System.out.println("state : "+state);
		System.out.println("pcode : "+pcode);
		
	}
	@AfterClass
	public void close()
	{
		driver.close();
	}
}
