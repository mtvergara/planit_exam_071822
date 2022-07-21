package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	public static WebDriver driver;
	public static void initializeDriver(String url) {
		Property config = new Property("src/main/resources/config.properties");
		  String browserType = config.ReadProperty("browserType");
		  String chromeLocation = config.ReadProperty("chromeDriver");
		  
		  System.out.println("Starting "+browserType+" WebDriver intance...");
			if (browserType.equalsIgnoreCase("CHROME")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browserType.equalsIgnoreCase("FIREFOX")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else {
				driver = new ChromeDriver(); //default
			}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	public static void terminateWebDriver() {
		System.out.println("Terminating WebDriver intance...");
		driver.close();
		driver.quit();
	}
}
