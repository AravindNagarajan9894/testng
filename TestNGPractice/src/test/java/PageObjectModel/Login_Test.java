package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Login_Test {
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
	}
	@Test(dataProvider = "login data")
	public void login_Test(String userName , String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		OrgHRM_Dashboard_Page_Using_PageFactory olp = new OrgHRM_Dashboard_Page_Using_PageFactory(driver);
		olp.setUserName(userName);
		olp.setPassword(password);
		olp.clickLogin();
		if(driver.getTitle().equals("OrangeHRM")) {
			OrgHRM_Dashboard_Page odp = new OrgHRM_Dashboard_Page(driver);
			odp.click_Logout();
			Assert.assertTrue(true);
		}
		else
			Assert.fail();
	}
	@DataProvider(name="login data")
	public String[][] test_data() {
		String[][] data = {{"admin", "admin123"},{"ad","123"}};
		return data;
	}
}
