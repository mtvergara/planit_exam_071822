package jupiter.product.toys.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import jupiter.product.toys.pageObject.PageObject_ContactPage;
import jupiter.product.toys.utilities.WebDriverManager;

@Test
public class TC_1 {
	 public void tc_1_contact_page_error() {
		String url = "https://jupiter.cloud.planittesting.com";
		String forename = "John Doe";
		String email = "JohnDoe@aol.com";
		String message = "Ths is a test contact.";
		WebDriver driver = WebDriverManager.getDriver("Chrome", url);
		 
		PageObject_ContactPage obj = PageFactory.initElements(driver, PageObject_ContactPage.class);
		obj.ClickContact();
		obj.ClickSubmit();
		obj.ValidateRequiredFieldsError();
		obj.EnterForename(forename);
		obj.EnterEmail(email);
		obj.EnterMessage(message);
		obj.ValidateRequiredFieldsValid();
	 }
}
