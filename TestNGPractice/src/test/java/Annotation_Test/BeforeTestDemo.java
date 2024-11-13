package Annotation_Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeTestDemo {
	
	@BeforeTest
	public void beforeTestMethod() {
		System.out.println("before Test Method...");
	}
	@Test
	public void testMethodOne() {
		System.out.println("test Method One");
	}
}
