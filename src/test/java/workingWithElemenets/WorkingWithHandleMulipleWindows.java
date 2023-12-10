package workingWithElemenets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithHandleMulipleWindows {

	ChromeDriver driver;

	private By helpPage = By.id("helpbutton");


	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");
	}
	
	@Test(priority = 1)
	public void testMulipleWindowsUsingTitle() 
	{
		String mainWindow = driver.getWindowHandle();
		WebElement windowBtn = driver.findElement(By.id("visitbutton"));
		windowBtn.click();
		for (String WindowID : driver.getWindowHandles()) 
		{
			String title = driver.switchTo().window(WindowID).getTitle();

			if (title.equals("Visit Us"))
			{
				Assert.assertEquals("Visit Us", driver.getTitle());
				driver.close();
				break;
			}
		}

		driver.switchTo().window(mainWindow);
	}

	@Test(priority = 2,enabled = false)
	public void testMulipleWindowsByName() 
	{
		String currentWindowID = driver.getWindowHandle();
		helpPage.findElement(driver).click();
		driver.switchTo().window("HelpWindow");
		System.out.println(driver.getTitle());
		Assert.assertEquals("Help", driver.getTitle());
		driver.close();
		driver.switchTo().window(currentWindowID);
	}
	

	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
