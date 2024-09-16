package tests;

import java.io.IOException;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.RegisterPage;
import resources.Base;

public class RegisterTest extends Base {

    public WebDriver driver;
    WebDriverWait wait;
    Logger log;

    @Parameters({"browsername", "version", "platform"})
    @BeforeMethod
    public void openApplication(String browsername, String version, String platform) throws IOException {
        log = LogManager.getLogger(RegisterTest.class);
        driver = initializeDriver(browsername, version, platform);
        log.debug("Opening browser and navigating to the application");
        driver.get(prop.getProperty("url"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void register() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.loginOrRegister().click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.registerButton().click();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.firstName().sendKeys(registerPage.generateRandomFName());
        registerPage.lasttName().sendKeys(registerPage.generateRandomLName());
        registerPage.emailAddress().sendKeys(registerPage.generateRandomEmail());
        registerPage.telePhone().sendKeys(registerPage.generateRandomTelephone());
        registerPage.faxNumber().sendKeys(registerPage.generateRandomFaxNumber());
        registerPage.companyName().sendKeys("Google Inc");
        registerPage.addressLine1().sendKeys("A/17 Harimandir Socity");
        registerPage.addressLine2().sendKeys("opp. Elite hotel");
        registerPage.cityName().sendKeys("Ahmedabad");
        registerPage.postCode().sendKeys("382424");
        registerPage.selectCountry(registerPage.countryName(), "India");
        registerPage.selectState(registerPage.stateName(), "Gujarat");
        registerPage.loginName().sendKeys(registerPage.generateRandomFName() + "2024" + registerPage.generateRandomLName());
        registerPage.password().sendKeys("Admin@123");
        registerPage.confirmPassword().sendKeys("Admin@123");
        registerPage.selectRadioButton(registerPage.subscribeNo());
        registerPage.selectRadioButton(registerPage.privacyPolicy());
        registerPage.continueButton().click();

        log.info("Registration process completed");
    }
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
        log.debug("Browser closed");
    }
}
