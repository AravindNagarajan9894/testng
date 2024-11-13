package Annotations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Before_After_Method {
	
	@BeforeMethod
	public void login() {
		System.out.println("login");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("Logout");
	}
	
	@Test(priority=1)
	public void search() {
		System.out.println("search");
	}
	@Test(priority=2)
	public void adv_search() {
		System.out.println("adv search");
	}

}
