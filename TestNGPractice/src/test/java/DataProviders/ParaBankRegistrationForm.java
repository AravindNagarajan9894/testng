package DataProviders;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class ParaBankRegistrationForm {
	WebDriver driver;
	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String value) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\DataDrivenTesting\\TestData\\Congurations.properties");
		prop.load(fis);
		String Url = prop.getProperty("ParaBankUrl");
		
		switch(value) {
		case "chrome" : driver = new ChromeDriver();break;
		case "edge"   : driver = new EdgeDriver();break;
		default : System.out.println("Invalid data");return;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Url);
		driver.manage().window().maximize();
	}
	@Test(priority=1, dataProvider="RegisterFormData")
	public void registerFormTest(String fName, String lName,String add,String cy ,String sta ,String zip,String phone,String s,String uName, String pass, String conPass ) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		WebElement firstName = driver.findElement(By.id("customer.firstName"));
		WebElement lastName = driver.findElement(By.id("customer.lastName"));
		WebElement address = driver.findElement(By.id("customer.address.street"));
		WebElement city = driver.findElement(By.id("customer.address.city"));
		WebElement state = driver.findElement(By.id("customer.address.state"));
		WebElement zipcode = driver.findElement(By.id("customer.address.zipCode"));
		WebElement phoneNumber = driver.findElement(By.id("customer.phoneNumber"));
		WebElement ssn = driver.findElement(By.id("customer.ssn"));
		WebElement userName = driver.findElement(By.id("customer.username"));
		WebElement password = driver.findElement(By.id("customer.password"));
		WebElement confirmPassword = driver.findElement(By.id("repeatedPassword"));
		WebElement registerButton = driver.findElement(By.xpath("//input[@value=\"Register\"]"));
	
		clearFields(firstName, lastName,address,city, state,zipcode,phoneNumber, ssn, userName, password, confirmPassword );
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		address.sendKeys(add);
		city.sendKeys(cy);
		state.sendKeys(sta);
		zipcode.sendKeys(zip);
		phoneNumber.sendKeys(phone);
		ssn.sendKeys(s);
		userName.sendKeys(uName);
		password.sendKeys(pass);
		confirmPassword.sendKeys(conPass);
		registerButton.click();
		
		if(driver.findElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']")).isDisplayed()) {
			System.out.println("Registered");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@id=\"leftPanel\"]/ul/li/a[text()='Log Out']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[text()='Register']")).click();
			Assert.assertTrue(true);
		}
		else if(driver.findElement(By.id("customer.username.errors")).isDisplayed()) {
			System.out.println("Already Existed");
			Assert.fail();
		}
		else {
			System.out.println("Failed");
			Assert.fail();
		}
		
	}
	public void clearFields(WebElement firstName, WebElement lastName,WebElement address,WebElement city ,WebElement state ,WebElement zipcode,WebElement phoneNumber,WebElement ssn,WebElement userName, WebElement password, WebElement confirmPassword) {
		firstName.clear();
		lastName.clear();
		address.clear();
		city.clear();
		state.clear();
		zipcode.clear();
		phoneNumber.clear();
		ssn.clear();
		userName.clear();
		password.clear();
		confirmPassword.clear();
		
	}
	@DataProvider(name="RegisterFormData")
	public String [][] registerFormData() {
		String[][] userData = {
	            {"John", "Doe", "123 Main St", "New York", "NY", "10001", "555-1234", "123-45-6789", "testja", "password1","password1"},
	            {"Jane", "Smith", "456 Oak Ave", "Los Angeles", "CA", "90001", "555-5678", "987-65-4321", "asdadasda", "password2","password2"},
	            {"Sam", "Wilson", "789 Pine Rd", "Chicago", "IL", "60601", "555-9876", "456-78-9012", "iasd", "password3","password3"},
	            {"Anna", "Taylor", "321 Elm Dr", "Houston", "TX", "77001", "555-6543", "789-12-3456", "hasdb", "password4","password4"},
	            {"Mark", "Johnson", "654 Cedar St", "Phoenix", "AZ", "85001", "555-8765", "234-56-7890", "jvadkhuasvd", "password5","password5"},
	            {"Lisa", "Brown", "987 Birch Ln", "Philadelphia", "PA", "19101", "555-4321", "321-65-9874", "lisabnd", "password6","password6"},
	            {"Tom", "Davis", "246 Spruce St", "San Diego", "CA", "92101", "555-7654", "567-89-0123", "tovisf", "password7","password7"},
	            {"Nancy", "White", "135 Maple Dr", "Dallas", "TX", "75201", "555-2345", "890-12-3456", "nahitef", "password8","password8"},
	            {"James", "Clark", "864 Palm St", "Miami", "FL", "33101", "555-6789", "678-90-1234", "jamarkf", "password9","password9"},
	            {"Emily", "Lewis", "753 Willow Rd", "Seattle", "WA", "98101", "555-9870", "543-21-0987", "emewisg", "password10","password10"}
	           
	        };
		return userData;
				
	}
	
}
