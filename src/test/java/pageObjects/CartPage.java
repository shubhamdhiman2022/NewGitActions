package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utitlites.VerifyElements;

public class CartPage extends VerifyElements
{
	WebDriver ldriver;
	public CartPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath = "//input[@placeholder='Enter promo code']")
	WebElement promoCode;
	
	@FindBy(xpath = "//button[text()='Apply']")
	WebElement applyPromo;
	
	@FindBy(xpath ="//button[text()='Place Order']")
	WebElement placeOrderBtn;
	
	@FindBy(xpath = "//span[@class='promoInfo']")
	public WebElement promosuccess;
	
	public void clickOnPlaceOrderButton()
	{
		placeOrderBtn.click();
	}
	
	public void enterPromoCode()
	{
		promoCode.sendKeys("rahulshettyacademy");
	}
	
	public void applyPromoCode()
	{
		applyPromo.click();
	}
}
