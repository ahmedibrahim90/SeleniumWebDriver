package workingWithElemenets;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithJavaScript {

	ChromeDriver driver;



	//@SuppressWarnings("deprecation")
	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.google.com");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


	}



	@Test(enabled=true)
	public void testJavaScript() 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = (String) js.executeScript("return document.title");
		System.out.println(title);
		Assert.assertEquals("Google", title);

		long links = (long) js.executeScript("var links = document.getElementsByTagName('A'); return links.length");
		System.out.println(links);
		Assert.assertEquals(17, links);
	}



	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
