package tests;

import java.io.IOException;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.ForgotLoginPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class ForgotLoginTest extends Base {

    public WebDriver driver;
    Logger log;

    @Parameters({"browsername", "version", "platform"})
    @BeforeMethod
    public void openApplication(String browsername, String version, String platform) throws IOException {
        log = LogManager.getLogger(ForgotLoginTest.class);
        driver = initializeDriver(browsername, version, platform);
        log.debug("Opening browser and navigating to the application");
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void forgotLogin(String lastName, String emailAddress) {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.loginOrRegister().click();
        landingPage.forgotPassword().click();

        ForgotLoginPage forgotLoginPage = new ForgotLoginPage(driver);
        forgotLoginPage.lastName().sendKeys(lastName);
        forgotLoginPage.emailAddress().sendKeys(emailAddress);
        forgotLoginPage.continueButton().click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.alertMessage().isDisplayed();

        log.info("Forgot Login process completed");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        log.debug("Browser closed");
    }
}
