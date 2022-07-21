package jupiter.product.toys.pageObject;

import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import common.BasePage;

public class PageObject_ShopPage {
	
	double grandTotalComputed = 0;


	By tab_Shop = By.id("nav-shop");
	
	By tab_Cart = By.id("nav-cart");
	
	
	public void ClickShop() {
		BasePage.driver.findElement(tab_Shop).click();
		System.out.println("Navigated to Shop page");
	}
	
	public void AddItemsToCart(String item, int quantity) {
		for(int i=1;i<=quantity;i++ ) {
			WebElement buyItem = BasePage.driver.findElement(By.xpath("//h4[text()='"+item+"']//parent::div//a[@ng-click='add(item)']"));
			buyItem.click();
		}
		System.out.println("Item: "+item+" with Quantity: "+quantity+" is added to cart.");
	}
	
	public void ClickCart() {
		BasePage.driver.findElement(tab_Cart).click();
		System.out.println("Navigated to Cart page");
	}
	
	public boolean ValidateItemsInCart(String item, int quantity) {
			WebElement itemQty = BasePage.driver.findElement(By.xpath("//td[contains(text(),'"+item+"')]//parent::tr/td[3]/input[@value='"+quantity+"']"));
			if (itemQty.isDisplayed()) {
				System.out.println("Item: "+item+" with Quantity: "+quantity+" is present in the cart.");
				return true;
			} else {
				System.out.println("Item: "+item+" with Quantity: "+quantity+" is NOT present in the cart.");
				return false;
			}
		
	}
	
	public boolean ValidateProductPrice(String item, double price) {
		double itemPrice = Double.parseDouble(BasePage.driver.findElement(By.xpath("//td[contains(text(),'"+item+"')]//parent::tr/td[2]")).getText().substring(1));
		if (price==itemPrice) {
			System.out.println("Item: "+item+" with Price: "+itemPrice+" is correct in the cart. Expected is "+price);
			return true;
		} else {
			System.out.println("Item: "+item+" with Price: "+itemPrice+" is incorrect in the cart. Expected is "+price);
			return false;
		}
	
	}
	
	public boolean ValidateSubTotal(String item, double price, int quantity) {
		double subTotal = Double.parseDouble(BasePage.driver.findElement(By.xpath("//td[contains(text(),'"+item+"')]//parent::tr/td[4]")).getText().substring(1));
		grandTotalComputed = grandTotalComputed + subTotal;
		if (price*quantity==subTotal) {
			System.out.println("Item: "+item+" with SubTotal: "+subTotal+" is correct in the cart. Expected is "+price*quantity);
			return true;
		} else {
			System.out.println("Item: "+item+" with SubTotal: "+subTotal+" is incorrect in the cart. Expected is "+price*quantity);
			return false;
		}
	}
	
	public boolean ValidateGrandTotal() {
		double grandTotalActual = Double.parseDouble(BasePage.driver.findElement(By.xpath("//*[@class='total ng-binding']")).getText().substring(7));
		if (grandTotalComputed==grandTotalActual) {
			System.out.println("GrandTotal: "+grandTotalActual+" is correct in the cart. Expected is "+grandTotalComputed);
			return true;
		} else {
			System.out.println("GrandTotal: "+grandTotalActual+" is incorrect in the cart. Expected is "+grandTotalComputed);
			return false;
		}
	}
	
}
