package findingElements;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByName {

	ChromeDriver driver;
	private By usernametxt = By.name("username");
	private By passwordtxt = By.name("password");
	
	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
		driver.manage().window().maximize();
	}
	@Test
	public void findElementByName()
	{
		
		//WebElement usernametxt = driver.findElement(By.name("username"));
		//WebElement passwordtxt = driver.findElement(By.name("password"));
		//System.out.println(usernametxt.getTagName());
		//System.out.println(passwordtxt.getLocation());
		
		System.out.println(driver.findElement(usernametxt).getLocation());
		System.out.println(driver.findElement(passwordtxt).getTagName());
		
	}
	
	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
	
	

}
