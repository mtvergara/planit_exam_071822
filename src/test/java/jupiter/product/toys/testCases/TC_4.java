package jupiter.product.toys.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.BasePage;
import jupiter.product.toys.pageObject.PageObject_ShopPage;


public class TC_4 {
	@Test
	public void tc_4_validate_total() {
		PageObject_ShopPage sp = new PageObject_ShopPage();
		String url = "https://jupiter.cloud.planittesting.com";
		String item1 = "Stuffed Frog";
		String item2 = "Fluffy Bunny";
		String item3 = "Valentine Bear";
		int item1qty = 2;
		int item2qty = 5;
		int item3qty = 3;
		double item1price = 10.99;
		double item2price = 9.99;
		double item3price = 14.99;
		BasePage.initializeDriver(url);
		
		System.out.println("Starting test execution of Test Case 4...");
		
		sp.ClickShop();
		sp.AddItemsToCart(item1, item1qty);
		sp.AddItemsToCart(item2, item2qty);
		sp.AddItemsToCart(item3, item3qty);
		sp.ClickCart();
		 
		 //product price
		Assert.assertTrue(sp.ValidateProductPrice(item1, item1price));
		Assert.assertTrue(sp.ValidateProductPrice(item2, item2price));
		Assert.assertTrue(sp.ValidateProductPrice(item3, item3price));
		 
		 //subtotal
		Assert.assertTrue(sp.ValidateSubTotal(item1, item1price, item1qty));
		Assert.assertTrue(sp.ValidateSubTotal(item2, item2price, item2qty));
		Assert.assertTrue(sp.ValidateSubTotal(item3, item3price, item3qty));
		 
		 //total
		Assert.assertTrue(sp.ValidateGrandTotal());
		
		System.out.println("Ending test execution of Test Case 4...");
		BasePage.terminateWebDriver();
	}
}
