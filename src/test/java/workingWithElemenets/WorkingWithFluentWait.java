package workingWithElemenets;


import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithFluentWait {

	ChromeDriver driver;

	//private By Btn = By.linkText("Page 2");
	//private By Msg = By.id("page2");

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://cookbook.seleniumacademy.com/AjaxDemo.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


	}



	@Test(enabled=true)
	public void testFluentWait() 
	{
		WebElement link = driver.findElement(By.linkText("Page 4"));
		link.click();
		Wait<WebDriver> Fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		WebElement Msg = Fwait.until(new Function<WebDriver, WebElement>() 

		{
			public WebElement apply(WebDriver d)
			{
				return d.findElement(By.id("page4"));
			}
		}

				);
		Assert.assertTrue(Msg.getText().contains("Nunc nibh tortor,"));

	}



	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
