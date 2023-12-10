package workingWithElemenets;

import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithConfirmAndDismissAlert {

	ChromeDriver driver;

	private By alertBtn = By.id("confirm");
	private By SuccesMsg = By.id("demo");

	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");


	}

	@Test(priority = 1)
	public void testconfirmAlert() 
	{
		alertBtn.findElement(driver).click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		Assert.assertEquals("Press a button!", alertText);
		alert.accept();
		String acceptMsg = SuccesMsg.findElement(driver).getText();
		Assert.assertEquals("You Accepted Alert!", acceptMsg);
	}

	@Test(priority = 2)
	public void testdismissAlert() 
	{
		alertBtn.findElement(driver).click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		Assert.assertEquals("Press a button!", alertText);
		alert.dismiss();
		String dismissMsg = SuccesMsg.findElement(driver).getText();
		Assert.assertEquals("You Dismissed Alert!", dismissMsg);
	}

	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
