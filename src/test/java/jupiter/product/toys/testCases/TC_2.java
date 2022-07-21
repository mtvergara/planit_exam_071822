package jupiter.product.toys.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.BasePage;
import jupiter.product.toys.pageObject.PageObject_ContactPage;


public class TC_2 {
	@Test
	 public void tc_2_contact_page_success() {
		 PageObject_ContactPage cp = new PageObject_ContactPage();
		 String url = "https://jupiter.cloud.planittesting.com";
			String forename = "John Doe";
			String email = "JohnDoe@aol.com";
			String message = "Ths is a test contact.";
			BasePage.initializeDriver(url);
			
			System.out.println("Starting test execution of Test Case 2...");
			
			cp.ClickContact();
			cp.EnterForename(forename);
			cp.EnterEmail(email);
			cp.EnterMessage(message);
			cp.ClickSubmit();
			Assert.assertTrue(cp.IsSuccessMessageDisplayed());
			
			System.out.println("Ending test execution of Test Case 2...");
			BasePage.terminateWebDriver();
			
	 }
}
