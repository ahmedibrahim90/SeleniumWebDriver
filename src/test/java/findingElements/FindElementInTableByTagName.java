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

public class FindElementInTableByTagName {

	ChromeDriver driver;

	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/tables");
		driver.manage().window().maximize();

	}

	@Test
	public void findElementInTableByTagName()
	{
		WebElement table = driver.findElement(By.id("table1"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		System.out.println(rows.get(2).getText());
		Assert.assertEquals(5, rows.size());
	}



	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
