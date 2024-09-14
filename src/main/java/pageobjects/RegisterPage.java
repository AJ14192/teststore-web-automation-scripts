package pageobjects;

import java.util.Random;

import org.openqa.selenium.By;
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
	WebElement lasttName;
	
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
	
	
	public WebElement firstName(){
		return firstName;
	}
	
	public WebElement lasttName(){
		return lasttName;
	}
	
	public WebElement emailAddress(){
		return emailAddress;
	}
	
	public WebElement telePhone(){
		return telePhone;
	}
	
	public WebElement faxNumber(){
		return faxNumber;
	}
	
	public WebElement companyName(){
		return companyName;
	}
	
	public WebElement addressLine1(){
		return addressLine1;
	}
	
	public WebElement addressLine2(){
		return addressLine2;
	}
	
	public WebElement cityName(){
		return cityName;
	}
	
	public WebElement stateName() {
		return stateName;
	}
	
	public WebElement countryName(){
		return countryName;
	}
	
	public WebElement postCode(){
		return postCode;
	}
	
	public WebElement loginName(){
		return loginName;
	}
	
	public WebElement password(){
		return password;
	}
	
	public WebElement confirmPassword(){
		return confirmPassword;
	}
	
	public WebElement subscribeNo(){
		return subscribeNo;
	}
	
	public WebElement privacyPolicy(){
		return privacyPolicy;
	}
	
	public WebElement continueButton(){
		return continueButton;
	}
	
	 public String generateRandomEmail() {
	        String emailPrefix = "John";
	        String emailDomain = "@yopmail.com";
	        int randomNum = new Random().nextInt(1000); // Generate a random number
	        return emailPrefix + randomNum + emailDomain;
	    }

	 public String generateRandomTelephone() {
	        Random random = new Random();
	        long min = 1000000000L; // 10-digit minimum
	        long max = 9999999999L; // 10-digit maximum
	        long randomNumber = min + (long) (random.nextDouble() * (max - min));
	        return String.valueOf(randomNumber);
	    }

	    public String generateRandomFName() {
	        String[] firstNames = { "John", "Jane", "Alex", "Emily", "Michael", "Sarah" };
	        Random random = new Random();
	        String firstName = firstNames[random.nextInt(firstNames.length)];
	        return firstName;
	    }

	    public String generateRandomLName() {
	        String[] lastNames = { "Doe", "Smith", "Johnson", "Williams", "Jones", "Brown" };
	        Random random = new Random();
	        String lastName = lastNames[random.nextInt(lastNames.length)];
	        return lastName;
	    }

	    public String generateRandomFaxNumber() {
	        Random random = new Random();
	        // Generate a 3-digit area code (e.g., 555)
	        int areaCode = 100 + random.nextInt(900);
	        // Generate a 3-digit prefix (e.g., 123)
	        int prefix = 100 + random.nextInt(900);
	        // Generate a 4-digit line number (e.g., 4567)
	        int lineNumber = 1000 + random.nextInt(9000);
	        // Format the fax number as +1 (XXX) YYY-ZZZZ
	        return String.format("+1 (%03d) %03d-%04d", areaCode, prefix, lineNumber);
	    }
	
	 public void selectRadioButton(WebElement webElement) {
	    	
	    	WebElement radiobutton = driver.findElement((By) webElement);
	    	
	    	if (!radiobutton.isSelected()) {
	    		radiobutton.click();
	        }
	    }
	    
	    public void selectCountry(WebElement webElement, String countryName) {
	        WebElement dropdownElement = driver.findElement((By) webElement);
	        Select dropdown = new Select(dropdownElement);
	        dropdown.selectByVisibleText(countryName);
	    }
	    
	    public void selectState(WebElement webElement, String stateName) {
	        WebElement dropdownElement = driver.findElement((By) webElement);
	        Select dropdown = new Select(dropdownElement);
	        dropdown.selectByVisibleText(stateName);
	    }
	    

	
}
