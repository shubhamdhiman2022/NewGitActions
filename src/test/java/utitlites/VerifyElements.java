package utitlites;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyElements 
{
	boolean present= false;
	public boolean verifyElementPresent(WebDriver driver, WebElement elementName)
	{
		present=elementName.isDisplayed();
		return present;
		
	}
	
	public void waitHelper(WebDriver driver, WebElement element) throws IOException
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
}
