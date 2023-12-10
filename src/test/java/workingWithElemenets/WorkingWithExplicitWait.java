package workingWithElemenets;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithExplicitWait {

	ChromeDriver driver;
	private By txtArea = By.id("APjFqb");



	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/");


	}



	@Test(enabled=false)
	public void testExplicitWait() 
	{
		WebElement txtArea = driver.findElement(By.id("APjFqb"));
		txtArea.sendKeys("Selenium Webdriver");
		txtArea.submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Selenium"));
		Assert.assertTrue(driver.getTitle().toLowerCase().startsWith("selenium"));
	}



	@Test(enabled=false)
	public void testExplicitWaitAgain() 
	{
		driver.findElement(txtArea).sendKeys("Selenium Webdriver");
		driver.findElement(txtArea).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains("Selenium"));
		Assert.assertTrue(driver.getTitle().toLowerCase().startsWith("selenium"));
	}


	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
