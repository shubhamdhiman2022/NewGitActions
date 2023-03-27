package stepDefinations;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utitlites.VerifyElements;

public class BaseClass extends VerifyElements
{
	public static WebDriver driver;

	public WebDriver browserSetup()
	{
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	//options.addArguments("-incognito");
	options.addArguments("start-maximized");
	options.addArguments("--remote-allow-origins=*");
	options.addArguments("--headless", "--disable-gpu", "--window-size=1366,768","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
	driver = new ChromeDriver(options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
	}


}
