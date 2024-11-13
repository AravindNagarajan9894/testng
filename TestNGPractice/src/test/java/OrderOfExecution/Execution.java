package OrderOfExecution;

import org.testng.annotations.*;

public class Execution {
	
	@BeforeSuite
	public void beforSuite() {
		System.out.println("before Suite");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("before Test");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before Method");
	}
	@Test
	public void test() {
		System.out.println("test");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("after Method");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("after class");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("after Test");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("after Suite");
	}
}
