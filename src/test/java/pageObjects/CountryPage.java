package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CountryPage 
{
	WebDriver ldriver;
	public CountryPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath ="//select")
	WebElement countryDropdown;
	
	@FindBy(xpath ="//input[@class='chkAgree']")
	WebElement checkboxAgree;
	
	@FindBy(xpath ="//button[text()='Proceed']")
	WebElement proceedBtn;
	
	public void SelectCountry()
	{
		Select select = new Select(countryDropdown);
		select.selectByValue("India");
	}
	
	public void checkTermsAndConditions()
	{
		checkboxAgree.click();
	}
	
	public void checkOnProceedButton()
	{
		proceedBtn.click();
	}
}
