package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.ForgotPasswordPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordTest extends Base {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void OpenApplication() throws IOException {
		
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://automationteststore.com/");
	}
	
	@Test(dataProvider = "getLoinNameEmail")
	public void ForgotPassword(String loginName, String emailAddress) {
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.loginOrRegister().click();
		landingPage.forgotPassword().click();
		
		ForgotPasswordPage forgotpasswordpage = new ForgotPasswordPage(driver);
		forgotpasswordpage.loginName().sendKeys(loginName);
		forgotpasswordpage.emailAddress().sendKeys(emailAddress);
		forgotpasswordpage.continueButton().click();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.alertMessage().isDisplayed();
		
	}
	
	@AfterMethod
	public void tearDown() {
		 driver.quit();
		
	}
	
	 @DataProvider
	    public Object[][] getLoinNameEmail() {
		 return new Object[][] {
			 {"rahul2024","rahul@yopmail.com"} 
		 };
	 }

}
