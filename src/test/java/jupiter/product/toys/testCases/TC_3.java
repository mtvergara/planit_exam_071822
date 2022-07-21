package jupiter.product.toys.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.BasePage;
import jupiter.product.toys.pageObject.PageObject_ContactPage;
import jupiter.product.toys.pageObject.PageObject_ShopPage;


public class TC_3 {
	@Test
	public void tc_3_add_to_cart() {
		PageObject_ShopPage sp = new PageObject_ShopPage();
		String url = "https://jupiter.cloud.planittesting.com";
		String item1 = "Funny Cow";
		String item2 = "Fluffy Bunny";
		int item1qty = 2;
		int item2qty = 1;
		BasePage.initializeDriver(url);
		
		System.out.println("Starting test execution of Test Case 3...");
		
		sp.ClickShop();
		sp.AddItemsToCart(item1, item1qty);
		sp.AddItemsToCart(item2, item2qty);
		sp.ClickCart();
		Assert.assertTrue(sp.ValidateItemsInCart(item1, item1qty));
		Assert.assertTrue(sp.ValidateItemsInCart(item2, item2qty));
		
		System.out.println("Ending test execution of Test Case 3...");
		BasePage.terminateWebDriver();
	}
}
