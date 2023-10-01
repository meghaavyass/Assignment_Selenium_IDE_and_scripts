package com.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class jUnitAnotationDemo {
	
	@BeforeClass
	public static void beforeclass()
	{
		System.out.println("before class");
	}
	@Before
	public void before()
	{
		System.out.println("before");
	}
	@Test
	@Ignore
	//if we don't want to execute testcase at this time we can ignore it or comment it 
	public void test1()
	{
		System.out.println("test 1");
	}
	@Test(expected = ArithmeticException.class)
	//when we know that the exception is occur then we have to write expected method and .class is inbuilt method
	public void test2()
	{
		System.out.println("test 2");
		System.out.println("Arithmetic Exception Expected");
		System.out.println(10/0);
	}
	@Test
	public void test3()
	{
		System.out.println("test 3");
	}
	@After
	public void after()
	{
		System.out.println("after");
	}
	@AfterClass
	public static void afterclass()
	{
		System.out.println("after class");
	}

}
