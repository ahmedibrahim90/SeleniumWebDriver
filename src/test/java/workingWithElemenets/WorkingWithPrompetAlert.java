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

public class WorkingWithPrompetAlert {

	ChromeDriver driver;
	private By alertBtn = By.id("prompt");
	private By message = By.id("prompt_demo");


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
	public void testPrometAlertt() 
	{

		WebElement alertBtn = driver.findElement(By.id("prompt"));
		alertBtn.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Hello Ahmed");
		alert.accept();
		WebElement message = driver.findElement(By.id("prompt_demo"));
		Assert.assertEquals("Hello Hello Ahmed! How are you today?", message.getText());


	}

	@Test(enabled=true)
	public void testPrompetAlert() 
	{
		alertBtn.findElement(driver).click();
		Alert alert = driver.switchTo().alert();
		String AlertText = alert.getText();
		Assert.assertEquals("Please enter your name", AlertText);
		alert.sendKeys("test");
		alert.accept();
		String SentMsg = message.findElement(driver).getText();
		Assert.assertEquals("Hello test! How are you today?", SentMsg);
	}

	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
