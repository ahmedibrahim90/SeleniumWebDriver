package findingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByID {

	ChromeDriver driver;
	private By usernametxt = By.id("username");
	private By passwordtxt = By.id("password");
	
	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void findElementByID()
	{
		
		//WebElement usernametxt = driver.findElement(By.id("username"));
		//WebElement passwordtxt = driver.findElement(By.id("password"));
		//System.out.println(usernametxt.getTagName());
		//System.out.println(passwordtxt.getLocation());
		
		System.out.println(driver.findElement(usernametxt).getTagName());
		System.out.println(driver.findElement(passwordtxt).getLocation());
			
	}
	
	
	
	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
