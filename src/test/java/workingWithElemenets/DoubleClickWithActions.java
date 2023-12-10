package workingWithElemenets;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClickWithActions {

	ChromeDriver driver;
	private By message = By.id("message");

	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");


	}

	@Test
	public void testDoubleClick() 
	{

		//WebElement message = driver.findElement(By.id("message"));
		//System.out.println(message.getCssValue("background-color"));
		//Assert.assertEquals("rgba(0, 0, 255, 1)", message.getCssValue("background-color"));
		//action.doubleClick(message).perform();
		//System.out.println(message.getCssValue("background-color"));
		//Assert.assertEquals("rgba(255, 255, 0, 1)", message.getCssValue("background-color"));

		message.findElement(driver);
		System.out.println(message.findElement(driver).getCssValue("background-color"));
		Actions action = new Actions(driver);
		action.doubleClick(message.findElement(driver)).build().perform();
		System.out.println(message.findElement(driver).getCssValue("background-color"));
		Assert.assertEquals("rgba(255, 255, 0, 1)", message.findElement(driver).getCssValue("background-color"));
	}


	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
