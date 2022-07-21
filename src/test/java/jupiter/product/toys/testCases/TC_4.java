package jupiter.product.toys.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import jupiter.product.toys.pageObject.PageObject_ShopPage;
import jupiter.product.toys.utilities.WebDriverManager;

@Test
public class TC_4 {
	public void tc_4_validate_total() {
		String url = "https://jupiter.cloud.planittesting.com";
		String item1 = "Stuffed Frog";
		String item2 = "Fluffy Bunny";
		String item3 = "Valentine Bear";
		int item1qty = 2;
		int item2qty = 5;
		int item3qty = 3;
		long item1price = (long) 10.99;
		long item2price = (long) 9.99;
		long item3price = (long) 14.99;
		WebDriver driver = WebDriverManager.getDriver("Chrome", url);
		 
		PageObject_ShopPage obj = PageFactory.initElements(driver, PageObject_ShopPage.class);
		obj.ClickShop();
		obj.AddItemsToCart(item1, item1qty);
		obj.AddItemsToCart(item2, item2qty);
		obj.AddItemsToCart(item3, item3qty);
		obj.ClickCart();
		 
		 //product price
		 obj.ValidateProductPrice(item1, item1price);
		 obj.ValidateProductPrice(item2, item2price);
		 obj.ValidateProductPrice(item3, item3price);
		 
		 //subtotal
		 obj.ValidateSubTotal(item1, item1price, item1qty);
		 obj.ValidateSubTotal(item2, item2price, item2qty);
		 obj.ValidateSubTotal(item3, item3price, item3qty);
		 
		 //total
		 obj.ValidateGrandTotal();
	}
}
