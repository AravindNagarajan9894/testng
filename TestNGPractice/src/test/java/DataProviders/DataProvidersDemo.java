package DataProviders;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DataProvidersDemo {
	WebDriver driver;
	@BeforeClass
	public void setup() throws IOException {
		driver = new ChromeDriver();
		Properties prp = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\DataDrivenTesting\\TestData\\Congurations.properties");
		prp.load(fis);
		driver.get(prp.getProperty("NinjaUrl"));
		driver.manage().window().maximize();
	}
	@Test(priority=1, dataProvider="dp")
	public void login(String email, String Password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement Email = driver.findElement(By.id("input-email"));
		WebElement password = driver.findElement(By.id("input-password"));
		Email.clear();
		password.clear();
		Email.sendKeys(email);
		password.sendKeys(Password);
		driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]")).click();
		System.out.println(driver.getCurrentUrl());
		if(driver.getCurrentUrl().equals("https://tutorialsninja.com/demo/index.php?route=account/account")) {
			driver.findElement(By.xpath("(//a[text()='Logout'])[2]")).click();
			driver.findElement(By.xpath("(//a[text()='Login'])[2]")).click();
			Assert.assertTrue(true);
		}
		else
			Assert.fail();
		
	}
	@DataProvider(name = "dp")
	public String[][] loginTestData() {
		String [][]  data = {{"cokasi2364@heweek.com","Worktual@123"},
							{"peyebog907@flexvio.com","thegs"},
							{"mowemog990@fryshare.com","jasda"},
							{"cokasi2364@heweek.com","Worktual@123"}					
								};
		return data;
	}
}
