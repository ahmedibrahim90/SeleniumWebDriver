package workingWithElemenets;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithJavaScriptAgain {

	ChromeDriver driver;
	
	private By TermsLink = By.xpath("/html/body/footer/section/div/div/div[3]/div/div[2]/ul/li[1]/a");


	//@SuppressWarnings("deprecation")
	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://4eshopping.com/ar");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


	}



	@Test(enabled=true)
	public void testJavaScriptAgain() 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", TermsLink.findElement(driver));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(TermsLink.findElement(driver)));
		TermsLink.findElement(driver).click();
	}




	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
