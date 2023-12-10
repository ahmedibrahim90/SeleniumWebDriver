package workingWithElemenets;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithDownloadFirefoxOptions {

	FirefoxDriver driver;
	private By downloadBtn = By.linkText("some-file.txt");
	
	public static String downloadPath = System.getProperty("user.dir")+"\\Downloads";
	
	public static FirefoxOptions firefoxOption()
	{
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		return option;
	}

	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\firefoxdriver.exe");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(firefoxOption());
		driver.manage().window().maximize();
		//driver.navigate().to("https://stag.4eshopping.com/ar/");
		driver.navigate().to("https://the-internet.herokuapp.com/download");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(enabled = false)
	public void testDownload()
	{
		WebElement downloadBtn = driver.findElement(By.linkText("fillable_text.pdf"));
		downloadBtn.click();
		
	}
	

	@Test(enabled = true)
	public void testDownloadAgain()
	{
		driver.findElement(downloadBtn).click();
	}

	
	
	

	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
