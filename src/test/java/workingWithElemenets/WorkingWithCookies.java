package workingWithElemenets;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithCookies {

	ChromeDriver driver;
	
	

	@BeforeTest
	public void openURL()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://magento-demo.lexiconn.com");


	}

	@Test
	public void testCookies() 
	{
		WebElement lang = driver.findElement(By.id("select-language"));
		
		Select select = new Select(lang);
		Assert.assertEquals("English", select.getFirstSelectedOption().getText());
		//Store cookies should be null
		Cookie storeCookie = driver.manage().getCookieNamed("store");
		Assert.assertEquals(null, storeCookie);
		select.selectByVisibleText("German");
		// Cookies should be populated by selected country
		storeCookie = driver.manage().getCookieNamed("store");
		Assert.assertEquals("german", storeCookie.getValue());
		System.out.println(storeCookie.getValue());
		
		//Get all cookies
		
		Set<Cookie> cookies =  driver.manage().getCookies();
		System.out.println("Number of cookies " + cookies.size());
		Iterator<Cookie> itr = cookies.iterator();
		while (itr.hasNext()) 
		{
			Cookie cookie = (Cookie) itr.next();
			
			System.out.println(cookie.getDomain());
			System.out.println(cookie.getName());
			System.out.println(cookie.getPath());
			System.out.println(cookie.getValue());
			System.out.println(cookie.getExpiry());
		}
	}

	

	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
