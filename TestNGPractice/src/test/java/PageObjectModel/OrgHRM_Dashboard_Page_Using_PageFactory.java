package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgHRM_Dashboard_Page_Using_PageFactory {
	WebDriver driver;
	
	//constructor
	OrgHRM_Dashboard_Page_Using_PageFactory(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Finding WebElements
	@FindBy(xpath="//input[@placeholder='Username']") WebElement userName;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement password;
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement loginButton;
	
	//Action Methods
	public void setUserName(String value) {
		userName.sendKeys(value);
	}
	public void setPassword(String value) {
		password.sendKeys(value);
	}
	public void clickLogin() {
		loginButton.click();
	}
}
