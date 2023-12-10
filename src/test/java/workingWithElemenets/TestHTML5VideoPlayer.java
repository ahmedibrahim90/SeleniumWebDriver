package workingWithElemenets;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHTML5VideoPlayer {

	//ChromeDriver driver;
	//FirefoxDriver driver;
	EdgeDriver driver;
	//private By videoPlayer = By.id("vplayer");

	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		//driver.navigate().to("https://cookbook.seleniumacademy.com/html5video.html");
		driver.navigate().to("https://codepen.io/cgraffeo/pen/ygNxaB");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	@Test
	public void testVideoPlayer() throws InterruptedException, IOException
	{


		// WebElement videoPlayer = driver.findElement(By.id("vplayer"));
		WebElement videoPlayer = driver.findElement(By.xpath("//video[@class='video']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String source = (String) js.executeScript("return arguments[0].currentSrc", videoPlayer);
		long duration = (long) js.executeScript("return arguments[0].duration", videoPlayer);
		Assert.assertEquals("http://html5demos.com/assets/dizzy.mp4", source);
		System.out.println(source);
		Assert.assertEquals(25, duration);
		//Assert.assertEquals(20, duration);
		js.executeScript("return arguments[0].play", videoPlayer);
		Thread.sleep(7000);
		js.executeScript("return arguments[0].pause", videoPlayer);

		//Take screenShot
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File ("./Videoplayer/canvas.png"));
	}




	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
