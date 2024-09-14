package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Login or register']")
	WebElement loginOrRegister;
	
	@FindBy(xpath="//a[normalize-space()='Forgot your password?']")
	WebElement forgotPassword;
	
	public WebElement loginOrRegister() {
		
		return loginOrRegister;
	}
	
	public WebElement forgotPassword() {
		return forgotPassword;
	}
}
