package jupiter.product.toys.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class WebDriverManager {
	public static WebDriver getDriver(String browserType, String url) {
		WebDriver driver;
		if (browserType.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("FIREFOX")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver(); //default
		}
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(url);
	return driver;
	}	
}
