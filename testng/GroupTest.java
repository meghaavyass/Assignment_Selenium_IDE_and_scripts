package com.testng;

import org.testng.annotations.Test;

public class GroupTest {
	
	@Test(groups = { "red" })
	public void red1() {
		System.out.println("red 1");
	}
	@Test(groups = { "red" })
	public void red2() {
		System.out.println("red 2");
	}
	@Test(groups = { "red" })
	public void red3() {
		System.out.println("red 3");
	}
	
	@Test(groups = { "green" })
	public void green1() {
		System.out.println("green 1");
	}
	@Test(groups = { "green" })
	public void green2() {
		System.out.println("green 2");
	}
	@Test(groups = { "green" })
	public void green3() {
		System.out.println("green 3");
	}
	
	@Test(groups = { "green","red" })
	public void green_red() {
		System.out.println("green_red");
	}
}
