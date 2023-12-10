package workingWithElemenets;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingJavaScriptAlert {

	ChromeDriver driver;
	private By alertBtn = By.id("simple");


	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");


	}

	@Test(enabled=false)
	public void testAlertt() 
	{

		WebElement alertBtn = driver.findElement(By.id("simple"));
		alertBtn.click();
		Alert alert = driver.switchTo().alert();
		String alertTxt = alert.getText();
		Assert.assertEquals("Hello! I am an alert box!", alertTxt);
		alert.accept();

	}

	@Test(enabled=true)
	public void testAlert() 
	{
		alertBtn.findElement(driver).click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		Assert.assertEquals("Hello! I am an alert box!", alertText);
		alert.accept();
			
		
//		driver.findElement(alertBtn).click();
//		Alert alert = driver.switchTo().alert();
//		String alertTxt = alert.getText();
//		Assert.assertEquals("Hello! I am an alert box!", alertTxt);
//		alert.accept();

	}

	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
