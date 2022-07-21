package jupiter.product.toys.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.BasePage;
import jupiter.product.toys.pageObject.PageObject_ContactPage;


public class TC_1 {
	@Test
	 public void tc_1_contact_page_error() {
		PageObject_ContactPage cp = new PageObject_ContactPage();
		String url = "https://jupiter.cloud.planittesting.com";
		String forename = "John Doe";
		String email = "JohnDoe@aol.com";
		String message = "Ths is a test contact.";
		
		BasePage.initializeDriver(url);
		System.out.println("Starting test execution of Test Case 1...");
		
		cp.ClickContact();
		cp.ClickSubmit();
		Assert.assertTrue(cp.IsForenameErrorDisplayed());
		Assert.assertTrue(cp.IsEmailErrorDisplayed());
		Assert.assertTrue(cp.IsMessageErrorDisplayed());
		cp.EnterForename(forename);
		cp.EnterEmail(email);
		cp.EnterMessage(message);
		Assert.assertFalse(cp.IsForenameErrorDisplayed());
		Assert.assertFalse(cp.IsEmailErrorDisplayed());
		Assert.assertFalse(cp.IsMessageErrorDisplayed());
		
		System.out.println("Ending test execution of Test Case 1...");
		BasePage.terminateWebDriver();
	 }
}
