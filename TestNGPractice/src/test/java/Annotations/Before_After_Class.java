package Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Before_After_Class {
	
	@BeforeClass
	public void beforeClassMethod() {
		System.out.println("before Class Method");
	}
	@AfterClass
	public void afterClassMethod() {
		System.out.println("after Class Method");
	}
	@Test
	public void testMethodOne() {
		System.out.println("test Method One");
	}
	@Test
	public void testMethodTwo() {
		System.out.println("test Method Two");
	}
}
