package ListenersPack;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class OrangeHrm_Listeners_Demo {
	WebDriver driver;
	@BeforeTest
	@Parameters({"browser"})
	public void setUp(String value) {
		switch(value) {
		case "chrome" : driver = new ChromeDriver();break;
		case "edge" : driver = new EdgeDriver(); break;
		default :System.out.println("invalid");return;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void logo_Verify() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(4000);
		WebElement logo = driver.findElement(By.xpath("//img[@src=\"/web/images/ohrm_branding.png?v=1721393199309\"]"));
		Assert.assertEquals(logo.isDisplayed(), true);
		
	}
	@Test(priority=2)
	public void field_Verify() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement userName = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		if(userName.isDisplayed()&&password.isEnabled()) {
			Assert.assertTrue(true);
		}
	}
	//I intentionally create a fail method
	@Test
	public void demo_FailMethod() {
		Assert.fail();
	}
	@Test(priority=3 ,dependsOnMethods = {"field_Verify", "demo_FailMethod"} )
	public void login_verify() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement userName = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		userName.sendKeys("Admin");
		password.sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	@AfterTest
	public void close() {
		driver.quit();
	}
}
