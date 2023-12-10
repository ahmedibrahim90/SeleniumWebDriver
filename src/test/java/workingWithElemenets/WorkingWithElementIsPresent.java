package workingWithElemenets;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithElementIsPresent {

	ChromeDriver driver;
	private By checkbox1 = By.xpath("//*[@id=\"checkboxes\"]/input[1]");


	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");


	}


	private boolean isElementPresent(By by)
	{
		try 
		{
			driver.findElement(by);
			return true;
		}

		catch (NoSuchElementException e) {
			return false;		}
	}
	
	@Test
	public void testELEMENTIsPresent()
	{
		if (isElementPresent(checkbox1))
		{
			checkbox1.findElement(driver);
			
			if(!checkbox1.findElement(driver).isSelected())
				
			{
				checkbox1.findElement(driver).click();
			}
			
		} else {

			Assert.fail("element is not exist");
		}
	}


	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
