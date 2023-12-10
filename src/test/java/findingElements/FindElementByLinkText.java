package findingElements;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

     
public class FindElementByLinkText {

	ChromeDriver driver;
	private By fullLink = By.linkText("Elemental Selenium");
	private By partialLink = By.partialLinkText("Elemental");
	
	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
		driver.manage().window().maximize();
	}
	
	@Test
	public void findElementByLinkText()
	{
		try {
			
			String myLink = driver.findElement(fullLink).getAttribute("href");
			System.out.println(myLink);
			Assert.assertEquals(myLink, "http://elementalselenium.com/");
					
		} catch (NoSuchElementException e) {
			System.out.println("Elemnet Not found");
		}
	}
	
	@Test
	public void findElementByPartialLinkText()
	{
		try {
			
			String myPartialLink = driver.findElement(partialLink).getAttribute("href");
			System.out.println(myPartialLink);
			Assert.assertEquals(myPartialLink, "http://elementalselenium.com/");
			
		} catch (NoSuchElementException e) {
			System.out.println("Elemnet Not found");
		}
	}
	
	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
