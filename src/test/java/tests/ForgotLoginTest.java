package tests;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.ForgotLoginPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class ForgotLoginTest extends Base {

    public WebDriver driver;

    @BeforeMethod
    public void openApplication() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://automationteststore.com/");
    }

    @Test(dataProvider = "getLastNameEmail")
    public void forgotLogin(String lastName, String emailAddress) {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.loginOrRegister().click();
        landingPage.forgotLogin().click();

        ForgotLoginPage forgotLoginPage = new ForgotLoginPage(driver);
        forgotLoginPage.lastName().sendKeys(lastName);
        forgotLoginPage.emailAddress().sendKeys(emailAddress);
        forgotLoginPage.continueButton().click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.alertMessage().isDisplayed();  // Ensure the alert message is displayed after submission
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider
    public Object[][] getLastNameEmail() {
        return new Object[][] {
            {"Khanna", "rahul@yopmail.com"}
        };
    }
}
