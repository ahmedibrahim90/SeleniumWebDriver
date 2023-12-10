package findingElements;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsTest {

	ChromeDriver driver;

	private By allLinks = By.tagName("a");

	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();

	}

	@Test
	public void findElementsTest()
	{
		//List<WebElement> links = driver.findElements(By.tagName("a"));
		List<WebElement> links = driver.findElements(allLinks);
		System.out.println(links.size());
		Assert.assertEquals(46, links.size());
		
		for (WebElement link : links) {
			
			System.out.println(link.getAttribute("href"));
		}
	}



	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
