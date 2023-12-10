package workingWithElemenets;

import java.io.IOException;

import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBrokenImages {

	ChromeDriver driver;
	private int BrokenimagesCount;


	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.navigate().to("https://stag.4eshopping.com/ar/");
		driver.navigate().to("https://the-internet.herokuapp.com/broken_images");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void testBrokenImages() 
	{
		BrokenimagesCount = 0;
		List<WebElement> imgList = driver.findElements(By.tagName("img"));
		for(WebElement imgElement : imgList)
		{
			if (imgElement != null) 
			{
				verifyActiveImages(imgElement);
			}
		}
		System.out.println("Total NO. of Broken Images are: " + BrokenimagesCount);
		Assert.assertEquals(2, BrokenimagesCount);
	}


	public void verifyActiveImages(WebElement imgElement)
	{
		org.apache.http.client.HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(imgElement.getAttribute("src"));

		try {
			org.apache.http.HttpResponse response = client.execute(request);

			if (response.getStatusLine().getStatusCode() != 200)
			{
				BrokenimagesCount++;
			}

		} catch (ClientProtocolException e) {
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
