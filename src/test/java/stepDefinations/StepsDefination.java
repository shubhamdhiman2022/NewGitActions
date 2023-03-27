package stepDefinations;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.CountryPage;
import pageObjects.ListingPage;

public class StepsDefination extends BaseClass
{
	ListingPage  lp; 
	CartPage cp;
	CountryPage cntryp;
	@Given("User launch Chrome Browser")
	public void user_launch_chrome_browser() 
	{
	 driver=browserSetup();
	}
	@When("User open the URL {string}")
	public void user_open_the_url(String Url)
	{
	    driver.get(Url);
	}
	@And("User add product {string} into the cart")
	public void user_add_product_into_the_cart(String string) 
	{
		lp= new ListingPage(driver);
		lp.addItemIntoCart(string);
	}
	@Then("User verify Item added into cart")
	public void verify_item_added_into_cart() 
	{
	   lp.verifyCartStatus();
	}
	
	@When("User click on Cart icon")
	public void user_click_on_cart_icon()
	{
	    lp.clickOnCartIcon();
	}
	@Then("User click on proceed to Checkout")
	public void user_click_on_checkout_to_proceed() 
	{
	    lp.clickOnCheckoutButton();
	}
	@When("User apply promo Code")
	public void user_apply_promo_code() 
	{
		cp= new CartPage(driver);
		cp.enterPromoCode();
		cp.applyPromoCode();
		cp.verifyElementPresent(driver,cp.promosuccess);
		System.out.println("Message: "+cp.promosuccess.getText());
	}
	
	@Then("User click on Place order button")
	public void user_click_on_place_order_button() 
	{
		
		cp.clickOnPlaceOrderButton();
	}
	
	@When("User select the shipping country")
	public void user_select_the_shipping_country() 
	{
		cntryp = new CountryPage(driver);
		cntryp.SelectCountry();
	}
	@When("User agree to the terms")
	public void user_agree_to_the_terms() 
	{
		cntryp.checkTermsAndConditions();
	}
	@Then("User click on Proceed button")
	public void user_click_on_proceed_button() 
	{
		cntryp.checkOnProceedButton();
	}
	
	@Then("User verify the order placed")
	public void user_verify_the_order_placed() 
	{
		boolean message=driver.getPageSource()
			    .contains("Thank you, your order has been placed successfully");
	    assertTrue("Order placed successfully", message);
	    //System.out.println("Order "+message);
	}

	@Then("User close the browser")
	public void user_close_the_browser()
	{
		driver.close();
	}

}
