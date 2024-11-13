package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrgHRM_Login_Page {
	WebDriver driver ;
	OrgHRM_Login_Page(WebDriver driver){
		this.driver=driver;
	}
	
	By userName = By.xpath("//input[@placeholder='Username']");
	By password = By.xpath("//input[@placeholder='Password']");
	By login = By.xpath("//button[normalize-space()='Login']");
	
	public void setUserName(String value) {
		driver.findElement(userName).sendKeys(value);
	}
	public void setPassword(String value) {
		driver.findElement(password).sendKeys(value);
	}
	public void clickLogin() {
		driver.findElement(login).click();
	}
}
