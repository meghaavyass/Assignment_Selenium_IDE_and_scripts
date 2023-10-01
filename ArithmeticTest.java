package com.junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
//parameterized inbuilt class che

public class ArithmeticTest {
	
	private int fno;
	//koi access nahi kar paye iisliye private
	private int sno;
	private int result;
	
	private Arithmetic arith;
	//it is a refrance of Arithmetic class
	
	public ArithmeticTest(int fno, int sno, int result)
	{
		System.out.println("Parameterized Constructor Called");
		this.fno = fno;
		this.sno = sno;
		this.result = result;
	}
	
	@Before
	public void initialize()
	{
		System.out.println("Before Called");
		this.arith = new Arithmetic();
		//pela khali refrance hato have object che kem ke eene memory mali new na lidhe
	}
	@Parameterized.Parameters
	public static Collection input()
	//collection of multiple data keje list return kare
	{
		System.out.println("Input Called");
		return Arrays.asList(new Object[][] {{1,2,3},{10,20,30},{23,23,46}});
		//two daimentional array
	}
	
	@Test
	public void parameterizedTest()
	{
		System.out.println("Sum : "+result);
		assertEquals(result, arith.sum(fno, sno));
		//result he wo expected result hoga or arith.sum wali method he wo dusre class se actual result check karga
	}

}
