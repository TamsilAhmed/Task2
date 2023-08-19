package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Utility;

public class BrowserOpen extends Utility{
	
	public static WebDriver driver;
	@BeforeMethod
	public void Start() {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
	
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
	}
   @AfterMethod
	public void close() {
		driver.close();
	}
	
	
	
}
