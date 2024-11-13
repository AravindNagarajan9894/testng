package Grouping;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Signup {
	@Test(priority=1, groups= {"Regression"})
	public void test_SignupViaEmail() {
		System.out.println("test_SignupViaEmail");
		Assert.assertTrue(true);
	}
	@Test(priority=2, groups= {"regression"})
	public void test_SignupViaNumber() {
		System.out.println("test_SignupViaNumber");
		Assert.assertTrue(true);
	
	}
	@Test(priority=3, groups= {"regression"})
	public void test_SignupViaFacebook() {
		System.out.println("test_SignupViaFacebook");
		Assert.assertTrue(true);
	}
}
