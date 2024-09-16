package resources;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;




public class Base {
	
	public Properties prop;
	
	public static RemoteWebDriver driver;	
	public static final String USERNAME = "oauth-adjadeja14192-05f71";
    public static final String ACCESS_KEY = "9253d44b-e245-456e-a55e-cb3f4812aabf";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	
	@Parameters({"browsername","version","plateform"})
	public WebDriver initializeDriver(String browsername, String version, String plateform) throws IOException {
		
		
		prop = new Properties();
		String propPath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		
//		String browsername = prop.getProperty("browser");
		
		
		if(browsername.equalsIgnoreCase("chrome")) {
			
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPlatformName(plateform);
			chromeOptions.setBrowserVersion(version);
			URL url = new URL(URL);
			driver = new RemoteWebDriver(url, chromeOptions);
			
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
			
		}
		
		else if(browsername.equalsIgnoreCase("firefox")){
			
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if(browsername.equalsIgnoreCase("ie")) {
			
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		else if(browsername.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
	
public String takeScreenshot(String testName,WebDriver driver) throws IOException {
		
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		FileUtils.copyFile(SourceFile,new File(destinationFilePath));
		return destinationFilePath;
	}

}
