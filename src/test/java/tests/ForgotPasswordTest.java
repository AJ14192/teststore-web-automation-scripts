package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.ForgotPasswordPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ForgotPasswordTest extends Base {

    public WebDriver driver;
    Logger log;

    @Parameters({"browsername", "version", "platform"})
    @BeforeMethod
    public void openApplication(String browsername, String version, String platform) throws IOException {
        log = LogManager.getLogger(ForgotPasswordTest.class);
        driver = initializeDriver(browsername, version, platform);
        log.debug("Opening browser and navigating to the application");
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(dataProvider = "getLoginNameEmail")
    public void forgotPassword(String loginName, String emailAddress) {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.loginOrRegister().click();
        landingPage.forgotPassword().click();

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.loginName().sendKeys(loginName);
        forgotPasswordPage.emailAddress().sendKeys(emailAddress);
        forgotPasswordPage.continueButton().click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.alertMessage().isDisplayed();

        log.info("Forgot Password process completed");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        log.debug("Browser closed");
    }

    @DataProvider
    public Object[][] getLoginNameEmail() {
        return new Object[][] {
            {"rahul2024", "rahul@yopmail.com"}
        };
    }
}
