package workingWithElemenets;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBrokenLinks {

	ChromeDriver driver;



	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.navigate().to("https://stag.4eshopping.com/ar/");
		driver.navigate().to("https://the-internet.herokuapp.com/");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void testBrokenLinks() 
	{
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total link are " + allLinks.size());

		for (int i = 0; i < allLinks.size(); i++) 
		{
			WebElement element = allLinks.get(i);
			String url = element.getAttribute("href");
			verifyURLLink(url);
		}
	}


	public static void verifyURLLink(String UrlLink)
	{
		try {
			URL url = new URL(UrlLink);

			//Create a connection using URL object
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setConnectTimeout(2000);
			httpConn.connect();

			//get response code

			if (httpConn.getResponseCode() == 200) 
			{
				System.out.println(UrlLink +" - "+ httpConn.getResponseMessage());
			}
			if (httpConn.getResponseCode() == 400) 
			{
				System.out.println(UrlLink +" - "+ httpConn.getResponseMessage());
			}

		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
