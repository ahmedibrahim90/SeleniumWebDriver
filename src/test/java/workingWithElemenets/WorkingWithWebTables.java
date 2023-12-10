package workingWithElemenets;

import java.util.List;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithWebTables {

	ChromeDriver driver;

	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/tables");
	}

	@Test()
	public void testWebTables() 
	{
		WebElement mytable = driver.findElement(By.className("tablesorter"));
		List<WebElement> rows = mytable.findElements(By.tagName("tr"));
		Assert.assertEquals(5, rows.size());

		for (WebElement row : rows) 
		{
			List<WebElement> cols = row.findElements(By.tagName("td"));


			for (WebElement col : cols) 
			{
				System.out.println(col.getText());
			}
			System.out.println();
		}
		System.out.println();
	}



	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
