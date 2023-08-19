package utils;

import java.io.File;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Utility{
	
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;


	
	public void elementclickable(WebElement element) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		if(wait.until(ExpectedConditions.elementToBeClickable (element)) != null) {
			test.log(LogStatus.PASS, "The Link Is Working");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./screenshot/accountpass.png"));
			String img = test.addScreenCapture("./screenshot/accountpass.png");

			
		}else {
			test.log(LogStatus.FAIL, "The Link is Broken");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./screenshot/accountpass.png"));
			String img = test.addScreenCapture("./screenshot/accountpass.png");

			
		}
		extent.endTest(test);

		extent.flush();

		
		
	}
	
	public boolean switchTab() {
		
		String parendwindow = driver.getWindowHandle();
		
		Set<String>windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles);
		
		for(String address:windowhandles) {
			if(!address.contentEquals(parendwindow)) {
				System.out.println("The child window address is :" +address );
				driver.switchTo().window(address);
				break;
			}
		}
		return false;
	}

	

	public boolean alerthandling() {
		driver.switchTo().alert().dismiss();
		return false;
	}
	

	
	public void Dropdown1() {
		
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='state']")));
		
		sel.selectByIndex(13);
	}
public void Dropdown2() {
		
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='expMonth']")));
		
		sel.selectByIndex(11);
	}
	
public void Dropdown3() {
	
	Select sel = new Select(driver.findElement(By.xpath("//select[@id='expYear']")));
	
	sel.selectByIndex(1);
}

public void TitleCheck() throws Exception {
	extent = new ExtentReports("report.html", true);

	test = extent.startTest("Title Check", "Visibility Check");
	
	test.log(LogStatus.INFO, "Checking for the Title");
	
	driver.getTitle();
	
	if(driver.getTitle()!= null) {
	
	test.log(LogStatus.PASS, "The Title is Shown");
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("./screenshot/Title.png"));
	String img = test.addScreenCapture("./screenshot/Title.png");
	}
	
	else {
	test.log(LogStatus.FAIL, "The Title is not Shown"); 
	
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("./screenshot/TitleNotShown.png"));
	String img = test.addScreenCapture("./screenshot/TitleNotShown.png");
}
	extent.endTest(test);

	extent.flush();
}
public void Action(WebElement element) {
	Actions action = new Actions(driver);

	action.moveToElement(element).click().perform();
}


public void waitforme(WebElement element) {
	
    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.elementToBeClickable(element));

    driver.manage().logs();
}
public void dropdown(WebElement element) {
	extent = new ExtentReports("Reports.html", true);

	test = extent.startTest("Dropdown Checking", "Value Validation");
	try {
	Select select = new Select(element);
	select.selectByIndex(49);
	test.log(LogStatus.INFO, "Value Clicked");
	
}catch(Exception e) {
	e.getMessage();
}
	extent.endTest(test);

	extent.flush();
}
public void confirmation() throws Exception {
	
	extent = new ExtentReports("report.html", true);

	test = extent.startTest("Title Check", "Visibility Check");
	
	test.log(LogStatus.INFO, "Checking for the Title");
	
	WebElement confirm = driver.findElement(By.xpath("(//div[@class='title'])[1]"));
	String title = confirm.getText();
	
	if(title.contentEquals("Your order has been successfully processed!")) {
		test.log(LogStatus.PASS, "The Title is Shown");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshot/Title.png"));
		String img = test.addScreenCapture("./screenshot/Title.png");
	}else {
		test.log(LogStatus.FAIL, "The Title is not Shown"); 
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshot/TitleNotShown.png"));
		String img = test.addScreenCapture("./screenshot/TitleNotShown.png");
	}
		extent.endTest(test);

		extent.flush();
	
	
}
}
