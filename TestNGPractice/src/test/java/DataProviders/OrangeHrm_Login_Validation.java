package DataProviders;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.Assert;

public class OrangeHrm_Login_Validation {
	WebDriver driver ; 
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String browserValue) throws IOException {
		
		switch(browserValue){
			case "chrome" : driver=  new ChromeDriver();break;
			case "edge" : driver=  new EdgeDriver();break;
			case "firefox" : driver = new FirefoxDriver();break;
			default : System.out.println("Invalid VALUE");return;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	@Test(priority=1, dataProvider="LoginCred")
	public void LoginValidation(String userName, String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		String dashboardUrl ="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		if(driver.getCurrentUrl().equals(dashboardUrl)) {
			driver.findElement(By.xpath("//span[@class=\"oxd-userdropdown-tab\"]/i")).click();
			driver.findElement(By.xpath("//ul[@class=\"oxd-dropdown-menu\"]/li/a[text()='Logout']")).click();
			Assert.assertTrue(true);
		}
		else
			Assert.fail();
	}
	@DataProvider(name ="LoginCred", indices= {0,1,2,3})
	public String[][] loginCredentials() {
		String [][] creds = {{"Admin","admin123"},{"admin123","admin123"},
							 {"123admin","123hello"},{"Admi","admin123"}};
		return creds;
	}

}
