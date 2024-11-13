package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrgHRM_Dashboard_Page {
	WebDriver driver;
	
	//constructor
	OrgHRM_Dashboard_Page(WebDriver driver){
		this.driver = driver;
	}
	
	//Locators
	By profileOptions = By.xpath("//i[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]");
	By logout = By.xpath("//a[text()=\"Logout\"]");
	
	//Action Methods
	public void click_Logout() {
		driver.findElement(profileOptions).click();
		driver.findElement(logout).click();
	}
}
