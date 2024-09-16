package pageobjects;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

    public WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "AccountFrm_firstname")
    WebElement firstName;

    @FindBy(id = "AccountFrm_lastname")
    WebElement lastName;  // Fixed typo

    @FindBy(id = "AccountFrm_email")
    WebElement emailAddress;

    @FindBy(id = "AccountFrm_telephone")
    WebElement telePhone;

    @FindBy(id = "AccountFrm_fax")
    WebElement faxNumber;

    @FindBy(id = "AccountFrm_company")
    WebElement companyName;

    @FindBy(id = "AccountFrm_address_1")
    WebElement addressLine1;

    @FindBy(id = "AccountFrm_address_2")
    WebElement addressLine2;

    @FindBy(id = "AccountFrm_city")
    WebElement cityName;

    @FindBy(id = "AccountFrm_zone_id")
    WebElement stateName;

    @FindBy(id = "AccountFrm_country_id")
    WebElement countryName;

    @FindBy(id = "AccountFrm_postcode")
    WebElement postCode;

    @FindBy(id = "AccountFrm_loginname")
    WebElement loginName;

    @FindBy(id = "AccountFrm_password")
    WebElement password;

    @FindBy(id = "AccountFrm_confirm")
    WebElement confirmPassword;

    @FindBy(id = "AccountFrm_newsletter0")
    WebElement subscribeNo;

    @FindBy(id = "AccountFrm_agree")
    WebElement privacyPolicy;

    @FindBy(xpath = "//*[@title='Continue']")
    WebElement continueButton;

    public WebElement firstName() {
        return firstName;
    }

    public WebElement lastName() {  // Renamed method to lastName()
        return lastName;
    }

    public WebElement emailAddress() {
        return emailAddress;
    }

    public WebElement telePhone() {
        return telePhone;
    }

    public WebElement faxNumber() {
        return faxNumber;
    }

    public WebElement companyName() {
        return companyName;
    }

    public WebElement addressLine1() {
        return addressLine1;
    }

    public WebElement addressLine2() {
        return addressLine2;
    }

    public WebElement cityName() {
        return cityName;
    }

    public WebElement stateName() {
        return stateName;
    }

    public WebElement countryName() {
        return countryName;
    }

    public WebElement postCode() {
        return postCode;
    }

    public WebElement loginName() {
        return loginName;
    }

    public WebElement password() {
        return password;
    }

    public WebElement confirmPassword() {
        return confirmPassword;
    }

    public WebElement subscribeNo() {
        return subscribeNo;
    }

    public WebElement privacyPolicy() {
        return privacyPolicy;
    }

    public WebElement continueButton() {
        return continueButton;
    }

    public String generateRandomEmail() {
        String emailPrefix = "Sam";
        String emailDomain = "@yopmail.com";
        int randomNum = new Random().nextInt(1000);
        return emailPrefix + randomNum + emailDomain;
    }

    public String generateRandomTelephone() {
        Random random = new Random();
        long min = 1000000000L;
        long max = 9999999999L;
        long randomNumber = min + (long) (random.nextDouble() * (max - min));
        return String.valueOf(randomNumber);
    }

    public String generateRandomFName() {
        String[] firstNames = { "John", "Jane", "Alex", "Emily", "Michael", "Sarah" };
        Random random = new Random();
        return firstNames[random.nextInt(firstNames.length)];
    }

    public String generateRandomLName() {
        String[] lastNames = { "Doe", "Smith", "Johnson", "Williams", "Jones", "Brown" };
        Random random = new Random();
        return lastNames[random.nextInt(lastNames.length)];
    }

    public String generateRandomFaxNumber() {
        Random random = new Random();
        int areaCode = 100 + random.nextInt(900);
        int prefix = 100 + random.nextInt(900);
        int lineNumber = 1000 + random.nextInt(9000);
        return String.format("+1 (%03d) %03d-%04d", areaCode, prefix, lineNumber);
    }

    public void selectRadioButton(WebElement webElement) {
        if (!webElement.isSelected()) {
            webElement.click();  // Directly click the WebElement
        }
    }

    public void selectCountry(WebElement webElement, String countryName) {
        Select dropdown = new Select(webElement);  // Corrected usage
        dropdown.selectByVisibleText(countryName);
    }

    public void selectState(WebElement webElement, String stateName) {
        Select dropdown = new Select(webElement);  // Corrected usage
        dropdown.selectByVisibleText(stateName);
    }
}
