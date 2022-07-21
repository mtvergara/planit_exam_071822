package jupiter.product.toys.pageObject;

import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PageObject_ShopPage {
	WebDriver driver;
	long grandTotalComputed = 0;
	public PageObject_ShopPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id="nav-shop")
	WebElement tab_Shop;
	
	@FindBy(id="nav-cart")
	WebElement tab_Cart;
	
	
	public void ClickShop() {
		tab_Shop.click();
	}
	
	public void AddItemsToCart(String item, int quantity) {
		for(int i=1;i<=quantity;i++ ) {
			WebElement buyItem = driver.findElement(By.xpath("//h4[text()='"+item+"']//parent::div//a[@ng-click='add(item)']"));
			buyItem.click();
		}
	}
	
	public void ClickCart() {
		tab_Cart.click();
	}
	
	public boolean ValidateItemsInCart(String item, int quantity) {
			WebElement itemQty = driver.findElement(By.xpath("//td[contains(text(),'"+item+"')]//parent::tr/td[3]/input[@value='"+quantity+"']"));
			if (itemQty.isDisplayed()) {
				return true;
			} else {
				return false;
			}
		
	}
	
	public boolean ValidateProductPrice(String item, long price) {
		long itemPrice = Long.parseLong(driver.findElement(By.xpath("//td[contains(text(),'"+item+"')]//parent::tr/td[2]")).getText().substring(1));
		if (price==itemPrice) {
			return true;
		} else {
			return false;
		}
	
	}
	
	public boolean ValidateSubTotal(String item, long price, int quantity) {
		long subTotal = Long.parseLong(driver.findElement(By.xpath("//td[contains(text(),'Stuffed Frog')]//parent::tr/td[4]")).getText().substring(1));
		grandTotalComputed = grandTotalComputed + subTotal;
		if (price*quantity==subTotal) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean ValidateGrandTotal() {
		long grandTotalActual = Long.parseLong(driver.findElement(By.xpath("//*[@class='total ng-binding']")).getText().substring(1));
		if (grandTotalComputed==grandTotalActual) {
			return true;
		} else {
			return false;
		}
	}
	
}
