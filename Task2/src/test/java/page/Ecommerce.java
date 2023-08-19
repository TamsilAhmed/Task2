package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BrowserOpen;

public class Ecommerce extends BrowserOpen{
	
	@FindBy(xpath = "//a[@href='/login?returnUrl=%2F']")
	WebElement loginbutton;
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement Email;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement Password;
	
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	WebElement login;
	
	@FindBy(xpath = "//a[@href='/computers']")
	WebElement computers;
	
	@FindBy(xpath = "//img[@alt='Picture for category Desktops']")
	WebElement desktop;
	
	@FindBy(xpath = "(//button[contains(text(),'Add to cart')])[2]")
	WebElement cart1;
	
	@FindBy(xpath = "//a[@href='/cart']")
	WebElement shoppingcart;
	
	@FindBy(xpath = "//input[@id='termsofservice']")
	WebElement checkbox;
	
	@FindBy(xpath ="//button[@id='checkout']")
	WebElement checkout;
	
	@FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']")
	WebElement selectcountry;
	
	@FindBy(xpath = "//input[@id='BillingNewAddress_City']")
	WebElement city;
	
	@FindBy(xpath = "//input[@id='BillingNewAddress_Address1']")
	WebElement address;
	
	@FindBy(xpath = "//input[@id='BillingNewAddress_ZipPostalCode']")
	WebElement pincode;
	
	@FindBy(xpath = "//input[@id='BillingNewAddress_PhoneNumber']")
	WebElement number;
	
	@FindBy(xpath = "(//button[@name='save'])[1]")
	WebElement Save;
	
	@FindBy(xpath = "//button[@class='button-1 shipping-method-next-step-button']")
	WebElement Continue1;;
	
	@FindBy(xpath = "//button[@class='button-1 payment-method-next-step-button']")
	WebElement Continue2;
	
	@FindBy(xpath ="//button[@class='button-1 payment-info-next-step-button']")
	WebElement Continue3;
	
	@FindBy(xpath = "//button[@class='button-1 confirm-order-next-step-button']")
	WebElement Continue4;

	public Ecommerce() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void login(String mail, String pass) throws Exception {
		
		loginbutton.click();
		
		Email.sendKeys(mail);
		Password.sendKeys(pass);
		
		login.click();
		
	}
	
	public void shop() {
		
		computers.click();
		desktop.click();
	}
		public void Scrolldown() {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
		   
			js.executeScript("window.scrollBy(0,500)");

		}
		
		public void cart() throws Exception {
			
		cart1.click();
		
		}
		
public void Scrollup() {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
		   
			js.executeScript("window.scrollBy(0,-500)");

		}

public void shopping() {
	shoppingcart.click();
	
}

public void checkout() {
	checkbox.click();
	checkout.click();
}
public void billing(String cityname,String add,String pin,String num) throws Exception {
	Thread.sleep(1000);
	dropdown(selectcountry);
	city.sendKeys(cityname);
	address.sendKeys(add);
	pincode.sendKeys(pin);
	dropdown(number);
	number.sendKeys(num);
	Save.click();
}

public void confirm() {
	
	Continue1.click();
	Continue2.click();
	Continue3.click();
	Continue4.click();
}


}
