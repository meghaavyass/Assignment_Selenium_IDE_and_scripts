package com.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
//runwith anotation thi suit inblilt class che je merge kare 

@SuiteClasses({Test1.class,Test2.class})
//jetla pan class ne merge karva hoy ee lakhvana {} karli bracket ma

public class TestSuitDemo {
	

}
