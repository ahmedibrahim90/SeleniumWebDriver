package findingElements;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementByClassName {

	ChromeDriver driver;
	private By loginBtn = By.className("radius");
	
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
	public void findElementByClassName()
	{
		try {
			
			System.out.println(driver.findElement(loginBtn).getTagName());
			System.out.println(driver.findElement(loginBtn).getText());
			
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
