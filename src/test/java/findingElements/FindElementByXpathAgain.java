package findingElements;




import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementByXpathAgain {

	ChromeDriver driver;
	private By searchTxt = By.xpath("//input[@name='ss']");
	
	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.booking.com/index.ar.html?label=gen173nr-1BCAEoggI46AdIM1gEaEOIAQGYAQG4ARfIAQzYAQHoAQGIAgGoAgO4ArO6iaoGwAIB0gIkYmNhOTMzYmYtZDI2Zi00YTE4LWJiNmMtYjNlZTg2MWM1ZWQ12AIF4AIB&sid=22e55f4d169b0dfdaea61e3a93db8bd1&keep_landing=1&sb_price_type=total&");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testXPATH()
	{
		searchTxt.findElement(driver).sendKeys("shram");
		System.out.println(searchTxt.findElement(driver).getAttribute("value"));
	}
	
	@AfterTest
	public void closeDRIVER()
	
	{
		driver.quit();
	}
}
