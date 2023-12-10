package workingWithElemenets;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHTML5Canvas {

	
	FirefoxDriver driver;
	
	private By drawList = By.id("dtool");
	private By canvas = By.id("imageView");
	
	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.firefoxdriver().setup();
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://cookbook.seleniumacademy.com/html5canvasdraw.html");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	@Test
	public void testVideoPlayer() throws InterruptedException, IOException
	{

		driver.findElement(drawList);
		Select select = new Select(driver.findElement(drawList));
		select.selectByVisibleText("Pencil");
		driver.findElement(canvas);
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(canvas)).moveByOffset(10, 50).moveByOffset(50, 10)
		.moveByOffset(-10, -50).moveByOffset(-50, -10).release().build().perform();
		Thread.sleep(3000);
		
		//Take screenShot
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File ("./ScreenShots/canvas.png"));
	}




	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
