package Dependency;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependenciesMethods {
	
	@Test(priority=1)
	public void test_setup() {
		Assert.assertTrue(true);
	}
	
	@Test(priority=2)
	public void test_login() {
		Assert.assertTrue(false);
	}
	
	@Test(priority=3, dependsOnMethods= {"test_setup","test_login"})
	public  void test_search(){
		Assert.assertTrue(true);
	}
}
