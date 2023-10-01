package com.junit;
import static org.junit.Assert.*;

import org.junit.Test;

public class jUnitAssertDemo {
	@Test
	public void test()
	{
		String s1="jUnit";
		String s2="jUnit";
		String s3="test";
		String s4="test";
		String s5=null;
		
		int i1=1;
		int i2=2;
		int[] Arrary1= {1,2,3,4};
		int[] Arrary2= {1,2,3,4};
	
		//Expected result and Actual result check karva mate use thayyy
		//the result is not define in console 
		
		assertEquals(s1,s2);
		assertNotEquals(s1,s3);
		assertEquals(s3,s4);
		assertNotEquals(s3,s1);
		assertEquals(s3,s4);
		assertNull(s5);
		assertTrue(i1<i2);
		//assertFalse(i1<i2);
		assertArrayEquals(Arrary1, Arrary2);
		
	}	
}
