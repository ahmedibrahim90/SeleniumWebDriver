package workingWithElemenets;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithUploadingFileWithROBOT {

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
		//driver.navigate().to("https://stag.4eshopping.com/ar/");
		driver.navigate().to("https://the-internet.herokuapp.com/upload");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(enabled = false)
	public void testUploadFile() throws AWTException
	{
		String imageName = "avatar.png";
		String imagePath = System.getProperty("user.dir")+"\\Uploads\\"+imageName;

		WebElement uploader = driver.findElement(By.id("file-upload"));
		Actions action = new Actions(driver);
		action.moveToElement(uploader).click().perform();


		Robot robot = new Robot();
		//CTRL C (Copy imagePath)
		StringSelection selection = new StringSelection(imagePath);
		System.out.println(imagePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, null);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		// Click on CTRL V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		WebElement uploadBtn = driver.findElement(By.id("file-submit"));
		uploadBtn.click();

		WebElement uploadedMsg = driver.findElement(By.id("uploaded-files"));
		System.out.println(uploadedMsg.getText());
		org.testng.Assert.assertEquals(imageName, uploadedMsg.getText());

	}


	@Test(enabled = true)
	public void testUploadFileAgain() throws AWTException, InterruptedException 
	{
		String imageName = "avatar.png";
		String imagePath = System.getProperty("user.dir")+"\\Uploads\\"+imageName;

		driver.findElement(uploader);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(uploader)).click().build().perform();

		Robot robot = new Robot();
		//CTRL C (Copy imagePath)
		StringSelection selection = new StringSelection(imagePath);
		System.out.println(imagePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, null);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		// Click on CTRL V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(3000);
		// Click on CTRL V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		//driver.findElement(uploadBtn).submit();
		driver.findElement(uploadBtn).click();
		System.out.println(driver.findElement(uploadedMsg).getText());
		org.testng.Assert.assertEquals(imageName, driver.findElement(uploadedMsg).getText());

	}





	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
