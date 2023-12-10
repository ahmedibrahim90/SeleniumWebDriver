package workingWithElemenets;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithUploadingFile {

	ChromeDriver driver;
	private By uploader = By.id("file-upload");
	private By uploadBtn = By.id("file-submit");
	private By uploadedMsg = By.id("uploaded-files");
	

	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/upload");
	}


	@Test(enabled = false)
	public void testUploadFileAgain() 
	{
		String imageName = "avatar.png";
		String imagePath = System.getProperty("user.dir")+"/Uploads/"+imageName;

		driver.findElement(uploader).sendKeys(imagePath);
		driver.findElement(uploadBtn).submit();
		System.out.println(driver.findElement(uploadedMsg).getText());
		org.testng.Assert.assertEquals(imageName, driver.findElement(uploadedMsg).getText());

	}

	@Test
	public void testUploadd()
	{
		String imageName = "Photo.jpg";
		String imagePath = System.getProperty("user.dir")+ "/Uploads/" + imageName;
		driver.findElement(uploader).sendKeys(imagePath);
		driver.findElement(uploadBtn).click();
		Assert.assertEquals(imageName, driver.findElement(uploadedMsg).getText());
	}

	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}

}
