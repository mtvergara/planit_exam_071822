package jupiter.product.toys.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import jupiter.product.toys.pageObject.PageObject_ContactPage;
import jupiter.product.toys.pageObject.PageObject_ShopPage;
import jupiter.product.toys.utilities.WebDriverManager;

@Test
public class TC_3 {

	public void tc_3_add_to_cart() {
		String url = "https://jupiter.cloud.planittesting.com";
		String item1 = "Funny Cow";
		String item2 = "Fluffy Bunny";
		int item1qty = 2;
		int item2qty = 1;
		WebDriver driver = WebDriverManager.getDriver("Chrome", url);
		 
		PageObject_ShopPage obj = PageFactory.initElements(driver, PageObject_ShopPage.class);
		obj.ClickShop();
		obj.AddItemsToCart(item1, item1qty);
		obj.AddItemsToCart(item2, item2qty);
		obj.ClickCart();
		obj.ValidateItemsInCart(item1, item1qty);
		obj.ValidateItemsInCart(item2, item2qty);
	}
}
