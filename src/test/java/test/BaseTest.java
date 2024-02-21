package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	String browser = "chrome";
	String url = "https://www.facebook.com";
	public static WebDriver driver;
	
	public void setupBrowser() {
		if(browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if(browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else {
			System.out.println("valid browser is not provided, hence quitting the automation run");
			System.exit(0);
		}
		
		driver.get(url);
	}

	
	@BeforeTest
	public void beforeTest() {
		setupBrowser();
		
	}
	
	@AfterTest
	public void afterTest() {
		//close the browser
		driver.quit();
	}

}
