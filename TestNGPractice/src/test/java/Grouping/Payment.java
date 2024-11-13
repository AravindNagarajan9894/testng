package Grouping;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Payment {
	@Test(priority=1, groups= {"sanity","regression","functional"})
	public void test_paymentByMastercard() {
		System.out.println("test_paymentByMastercard");
		Assert.assertTrue(true);
	}
	
	@Test(priority=2, groups= {"sanity","regression","functional"})
	public void test_paymentByVisa() {
		System.out.println("test_paymentByVisa");
		Assert.assertTrue(true);
	}

}
