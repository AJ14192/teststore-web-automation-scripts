package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;
import java.io.IOException;
import java.time.Duration;

public class LoginTest extends Base {

    public WebDriver driver;
    WebDriverWait wait;
    Logger log;
    @BeforeMethod
    public void openApplication() throws IOException {
        log = LogManager.getLogger(LoginTest.class);
        driver = initializeDriver();
        log.debug("Opening browser and navigating url");
        driver.get(prop.getProperty("url"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test(dataProvider = "getLoginData")
    public void login(String loginName, String password, String expectedStatus) {
        LandingPage landingPage = new LandingPage(driver);
        log.debug("Clicking on login or register option");
        landingPage.loginOrRegister().click();


        LoginPage loginPage = new LoginPage(driver);
        log.debug("Adding LoginName");
        loginPage.loginNameField().sendKeys(loginName);
        log.debug("Adding Password");
        loginPage.passwordField().sendKeys(password);
        log.debug("Clicking on login button");
        // Ensure login button is clickable before clicking
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginButton())).click();

        AccountPage accountPage = new AccountPage(driver);
        String actualStatus;
        try {
            // Wait for the account page link to be visible
            WebElement accountElement = wait.until(ExpectedConditions.visibilityOf(accountPage.myAccountPage()));
            actualStatus = accountElement.isDisplayed() ? "Success" : "Failure";
            log.info("The user is successfully login");

        } catch (Exception e) {
            actualStatus = "Failure";
            log.error("Login attempt is fail due to incorrect email or password");

        }
        System.out.println("Actual status: " + actualStatus);
        Assert.assertEquals(actualStatus, expectedStatus);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
        log.debug("Browser closed");
    }

    @DataProvider
    public Object[][] getLoginData() {
        return new Object[][]{
                {"rahul2024", "Admin@123", "Success"},
                {"james2023", "Admin123", "Failure"}
        };
    }

}
