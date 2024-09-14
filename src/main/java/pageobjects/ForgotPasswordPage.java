package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

	WebDriver driver;
	
	public ForgotPasswordPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);		
		
	}
	
	
	@FindBy(id="forgottenFrm_loginname")
	WebElement loginName;
	
	@FindBy(id="forgottenFrm_email")
	WebElement emailAddress;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement continueButton;
	
	
	public WebElement loginName() {
		
		return loginName;
	}
	
	public WebElement emailAddress() {
		
		return emailAddress;
	}
	
	public WebElement continueButton() {
		
		return continueButton;
	}
	
}
