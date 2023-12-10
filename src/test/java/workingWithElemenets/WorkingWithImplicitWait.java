package workingWithElemenets;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithImplicitWait {

	ChromeDriver driver;
	private By Btn = By.linkText("Page 4");
	private By msg = By.id("page4");


	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://cookbook.seleniumacademy.com/AjaxDemo.html");


	}


	@SuppressWarnings("deprecation")
	@Test(enabled=false)
	public void testImplicitWait() 
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement Btn = driver.findElement(By.linkText("Page 4"));
		Btn.click();
		WebElement msg = driver.findElement(By.id("page4"));
		System.out.println(msg.getText());
		Assert.assertTrue(msg.getText().contains("Nunc nibh tortor,"));
	}


	
	@Test@SuppressWarnings("deprecation")
	public void testImplicitWaitAgain() 
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Btn.findElement(driver).click();
		System.out.println(msg.findElement(driver));
		Assert.assertTrue(msg.findElement(driver).getText().contains("Nunc nibh tortor"));
	}

	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
