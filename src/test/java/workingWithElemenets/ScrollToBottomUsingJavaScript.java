package workingWithElemenets;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollToBottomUsingJavaScript {

	ChromeDriver driver;
	
	

	//@SuppressWarnings("deprecation")
	@BeforeTest
	public void openURL()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://4eshopping.com/ar");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


	}

	
	
	@Test(enabled=true)
	public void testScrollingByJavaScript() throws InterruptedException 
	{
		WebElement link = driver.findElement(By.cssSelector("a._link.-pbxs"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", link);
		Thread.sleep(3000);
		System.out.println(link.getText());
		Assert.assertTrue(link.isDisplayed());
		
	}
	
	

	@AfterTest
	public void closeDriver()
	{
		//driver.quit();
	}
}
