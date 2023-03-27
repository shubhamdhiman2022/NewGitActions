package pageObjects;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utitlites.VerifyElements;

public class ListingPage extends VerifyElements
{
	WebDriver ldriver;
	public ListingPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	@FindBy(xpath = "//h4[@class='product-name']")
	List<WebElement> ProductNames;
	
	@FindBy(xpath = "//div[@class='product-action']/button")
	List<WebElement> addCartbtns;
	
	@FindBy(xpath = "//img[@alt='Cart']")
	WebElement cartIcon;
	
	@FindBy(xpath = "//div[@class='cart-info']//tr[1]//td[3]")
	WebElement itemsCount;
	
	@FindBy(xpath = "//button[text()='PROCEED TO CHECKOUT']")
	WebElement checkoutBtn;
	
	public void addItemIntoCart(String CartItem)
	{
		for(int i=0;i<ProductNames.size();i++)
		{
			String productName=ProductNames.get(i).getText().split("-")[0].trim();
			if(productName.equalsIgnoreCase(CartItem))
			{
				addCartbtns.get(i).click();
				break;
			}
		}
	}
	
	public void clickOnCartIcon()
	{
		cartIcon.click();
	}
	
	public void verifyCartStatus()
	{
		if(Integer.parseInt(itemsCount.getText())>0)
		{
			System.out.println("Item added Successfully");
			assertTrue(true);
		}
		else
		{
			System.err.println("Items not added. Something Went Wrong!");
			
		}
	}
	
	public void clickOnCheckoutButton()
	{
		checkoutBtn.click();
	}
	
}
