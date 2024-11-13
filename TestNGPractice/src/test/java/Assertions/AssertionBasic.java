package Assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssertionBasic {
	WebDriver driver ;
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void assertionBasic() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Automation Testing Practic";
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);

	}
}
