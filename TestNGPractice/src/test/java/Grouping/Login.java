package Grouping;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
	@Test(priority=1, groups= {"sanity"})
	public void test_LoginViaEmail() {
		System.out.println("test_LoginViaEmail");
		Assert.assertTrue(true);
	}
	@Test(priority=2, groups= {"sanity"})
	public void test_LoginViaNumber() {
		System.out.println("test_LoginViaNumber");
		Assert.assertTrue(true);
	
	}
	@Test(priority=3, groups= {"sanity"})
	public void test_LoginViaFacebook() {
		System.out.println("test_LoginViaFacebook");
		Assert.assertTrue(true);
	}
}
