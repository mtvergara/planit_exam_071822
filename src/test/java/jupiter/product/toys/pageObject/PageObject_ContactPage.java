package jupiter.product.toys.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PageObject_ContactPage {
	WebDriver driver;
	public PageObject_ContactPage(WebDriver driver) {
		// TODO Auto-generated method stub
		this.driver=driver;
	}
	
	@FindBy(id="nav-contact")
	WebElement tab_Contact;
	
	@FindBy(xpath="//a[text()='Submit']")
	WebElement btn_SubmitContact;
	
	@FindBy(xpath="//span[text()='Forename is required']")
	WebElement lbl_Forename_Error;
	
	@FindBy(xpath="//span[text()='Email is required']")
	WebElement lbl_Email_Error;
	
	@FindBy(xpath="//span[text()='Message is required']")
	WebElement lbl_Message_Error;
	
	@FindBy(className="alert alert-success")
	WebElement lbl_Success_Message;
	
	@FindBy(id="forename")
	WebElement txt_Forename;
	
	@FindBy(id="email")
	WebElement txt_Email;
	
	@FindBy(id="message")
	WebElement txt_Message;
	
	//Steps
	public void ClickContact() {
		tab_Contact.click();
	}
	
	public void ClickSubmit() {
		btn_SubmitContact.click();
	}
	
	public boolean IsForenameErrorDisplayed() {
		if (lbl_Forename_Error.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean IsEmailErrorDisplayed() {
		if (lbl_Email_Error.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean IsMessageErrorDisplayed() {
		if (lbl_Message_Error.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean IsSuccessMessageDisplayed() {
		if (lbl_Success_Message.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void EnterForename(String value) {
		if (txt_Forename.isEnabled()) {
			txt_Forename.sendKeys(value);
		}
	}
	
	public void EnterEmail(String value) {
		if (txt_Email.isEnabled()) {
			txt_Email.sendKeys(value);
		}
	}
	
	public void EnterMessage(String value) {
		if (txt_Message.isEnabled()) {
			txt_Message.sendKeys(value);
		}
	}
	
	
	//BusinessSteps
	public void ValidateRequiredFieldsError() {
		Assert.assertTrue(IsForenameErrorDisplayed());
		Assert.assertTrue(IsEmailErrorDisplayed());
		Assert.assertTrue(IsMessageErrorDisplayed());
	}
	
	public void ValidateRequiredFieldsValid() {
		Assert.assertFalse(IsForenameErrorDisplayed());
		Assert.assertFalse(IsEmailErrorDisplayed());
		Assert.assertFalse(IsMessageErrorDisplayed());
	}
	
}
