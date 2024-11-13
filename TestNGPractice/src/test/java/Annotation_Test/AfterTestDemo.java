package Annotation_Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AfterTestDemo {
	@AfterTest
	public void beforeTestMethod() {
		System.out.println("After Test Method...");
	}
	@Test
	public void testMethodtwo() {
		System.out.println("test Method two");
	}
}
