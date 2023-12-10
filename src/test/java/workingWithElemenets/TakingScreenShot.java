package workingWithElemenets;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakingScreenShot {

	ChromeDriver driver;
	//private By SearchTxt = By.id("APjFqb");

	//@SuppressWarnings("deprecation")
	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


	}



	@Test(enabled=true)
	public void testScreenShotOnFailure() 
	{
		WebElement SearchTxt = driver.findElement(By.id("APjFqb1"));
		SearchTxt.sendKeys("Selenium Webdriver Book");
		SearchTxt.submit();
		Assert.assertTrue(driver.getTitle().contains("Selenium"));

	}

	@AfterMethod
	public void testScreenshot(ITestResult result) throws IOException 
	{
		if (ITestResult.FAILURE == result.getStatus()) 
		{
			//Take screenshot
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./ScreenShots/"+ result.getName()+".png"));
		}
	}



	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
