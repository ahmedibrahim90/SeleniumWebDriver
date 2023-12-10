package workingWithElemenets;


import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithFrames {

	ChromeDriver driver;
	private By msg = By.tagName("p");
	private By msg1 = By.tagName("p");
	private By msg2 = By.tagName("p");


	//@SuppressWarnings("deprecation")
	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Frames.html");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}



	@Test(enabled=true)
	public void testFrameWithID() 
	{
		driver.switchTo().frame("left");
		System.out.println(msg1.findElement(driver).getText());
		Assert.assertEquals("This is Left Frame", msg1.findElement(driver).getText());
		driver.switchTo().defaultContent();
	}

	@Test(enabled=true)
	public void testFrameWithName() 
	{
		driver.switchTo().frame("right");
		System.out.println(msg2.findElement(driver).getText());
		Assert.assertEquals("This is Right Frame", msg2.findElement(driver).getText());
		driver.switchTo().defaultContent();
	}

	@Test(enabled=true)
	public void testFrameWithIndex() 
	{
		driver.switchTo().frame(1);
		System.out.println(msg.findElement(driver).getText());
		Assert.assertEquals("This Frame doesn't have id or name", msg.findElement(driver).getText());
		driver.switchTo().defaultContent();
	}



	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
