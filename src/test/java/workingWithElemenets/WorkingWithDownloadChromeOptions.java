package workingWithElemenets;


import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithDownloadChromeOptions {

	ChromeDriver driver;
	private By downloadBtn = By.linkText("some-file.txt");

	public static String downloadPath = System.getProperty("user.dir")+"\\Downloads";

	public static ChromeOptions chromeOption()
	{
		ChromeOptions option = new ChromeOptions();
		HashMap<String, Object> chromPrefs = new HashMap<String, Object>();
		chromPrefs.put("profile.default.content.settings.popups", 0);
		chromPrefs.put("download.default_directory", downloadPath);
		option.setExperimentalOption("prefs", chromPrefs);
		option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		return option;
	}

	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOption());
		driver.manage().window().maximize();
		//driver.navigate().to("https://stag.4eshopping.com/ar/");
		driver.navigate().to("https://the-internet.herokuapp.com/download");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(enabled = false)
	public void testUploadFile()
	{
		WebElement downloadBtn = driver.findElement(By.linkText("some-file.txt"));
		downloadBtn.click();

	}


	@Test(enabled = true)
	public void testUploadFileAgain()
	{
		driver.findElement(downloadBtn).click();
	}





	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
