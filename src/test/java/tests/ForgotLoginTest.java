package tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.ForgotLoginPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class ForgotLoginTest extends Base {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void OpenApplication() throws IOException {
		
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://automationteststore.com/");
	}
	
	@Test
	public void ForgotLogin(String lastName, String emailAddress) {
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.loginOrRegister().click();
		landingPage.forgotPassword().click();
		
		
		ForgotLoginPage forgotLoginPage = new ForgotLoginPage(driver);
		forgotLoginPage.lastName().sendKeys(lastName);
		forgotLoginPage.emailAddress().sendKeys(emailAddress);
		forgotLoginPage.continueButton().click();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.alertMessage().isDisplayed();
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	public Object[][] getLastNameEmail(){
		return new Object[][] {
			{"Khanna","rahul@yopmail.com"}
		};
	}
	
}
