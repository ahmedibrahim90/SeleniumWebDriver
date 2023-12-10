package workingWithElemenets;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithTextBoxAndButtons2 {

	ChromeDriver driver;

	private By textArea = By.id("APjFqb");


	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://google.com");


	}

	@Test
	public void searchFor() 
	{
		textArea.findElement(driver).clear();
		textArea.findElement(driver).sendKeys("Selenium Webdriver");
		textArea.findElement(driver).submit();
		System.out.println(textArea.findElement(driver).getText());
		Assert.assertTrue(textArea.findElement(driver).getText().contains("Selenium"));
		textArea.findElement(driver).clear();
		textArea.findElement(driver).sendKeys("Appium");
		textArea.findElement(driver).submit();
		Assert.assertTrue(textArea.findElement(driver).getText().contains("Appium"));
	}


	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
