package jupiter.product.toys.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import common.BasePage;

public class PageObject_ContactPage{
	
	By tab_Contact= By.id("nav-contact");
	
	By btn_SubmitContact = By.xpath("//a[text()='Submit']");
	
	By lbl_Forename_Error = By.xpath("//span[text()='Forename is required']");
	
	By lbl_Email_Error = By.xpath("//span[text()='Email is required']");
	
	By lbl_Message_Error = By.xpath("//span[text()='Message is required']");
	
	By lbl_Success_Message = By.xpath("//div[@class='alert alert-success']");
	
	By txt_Forename = By.id("forename");
	
	By txt_Email = By.id("email");
	
	By txt_Message = By.id("message");
	
	//Steps
	public void ClickContact() {
		BasePage.driver.findElement(tab_Contact).click();
		System.out.println("Navigated to Contact page");
	}
	
	public void ClickSubmit() {
		BasePage.driver.findElement(btn_SubmitContact).click();
		System.out.println("Clicked Submit button");
	}
	
	public boolean IsForenameErrorDisplayed() {
		if (BasePage.driver.findElements(lbl_Forename_Error).size()>0) {
			System.out.println("Forename error is displayed");
			return true;
		} else {
			System.out.println("Forename error is NOT displayed");
			return false;
		}
	}
	
	public boolean IsEmailErrorDisplayed() {
		if (BasePage.driver.findElements(lbl_Email_Error).size()>0) {
			System.out.println("Email error is displayed");
			return true;
		} else {
			System.out.println("Email error is NOT displayed");
			return false;
		}
	}
	
	public boolean IsMessageErrorDisplayed() {
		if (BasePage.driver.findElements(lbl_Message_Error).size()>0) {
			System.out.println("Message error is displayed");
			return true;
		} else {
			System.out.println("Message error is NOT displayed");
			return false;
		}
	}
	
	public boolean IsSuccessMessageDisplayed() {
		if (BasePage.driver.findElements(lbl_Success_Message).size()>0) {
			System.out.println("Success message is displayed");
			return true;
		} else {
			System.out.println("Success message is NOT displayed");
			return false;
		}
	}
	
	public void EnterForename(String value) {
		if (BasePage.driver.findElement(txt_Forename).isEnabled()) {
			BasePage.driver.findElement(txt_Forename).sendKeys(value);
			System.out.println("Entered forename");
		}
	}
	
	public void EnterEmail(String value) {
		if (BasePage.driver.findElement(txt_Email).isEnabled()) {
			BasePage.driver.findElement(txt_Email).sendKeys(value);
			System.out.println("Entered email");
		}
	}
	
	public void EnterMessage(String value) {
		if (BasePage.driver.findElement(txt_Message).isEnabled()) {
			BasePage.driver.findElement(txt_Message).sendKeys(value);
			System.out.println("Entered message");
		}
	}
	
}
