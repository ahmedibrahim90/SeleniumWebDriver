package workingWithElemenets;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithTextBoxAndButtons {

	ChromeDriver driver;

	private By emailtxt = By.cssSelector("input[id='email']");
	private By passwordTxt = By.xpath("//input[@name='password']");
	private By loginBtn = By.cssSelector("button[type='submit']");
	private By pharName = By.id("nav-link-accountList-nav-line-1");

	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://4eshopping.com/ar/login");


	}

	@Test
	public void pharmacyLogin() throws InterruptedException
	{
		emailtxt.findElement(driver).clear();
		emailtxt.findElement(driver).sendKeys("ahmed.ibrahim@rubikans.com");
		passwordTxt.findElement(driver).clear();
		passwordTxt.findElement(driver).sendKeys("123456789");
		loginBtn.findElement(driver).click();
		Thread.sleep(3000);
		System.out.println(pharName.findElement(driver).getText());
		Assert.assertTrue(pharName.findElement(driver).getText().contains("Android"));
		
		//WebElement emailTxt = driver.findElement(By.xpath("//input[@id='email']"));
		//WebElement passwordTxt = driver.findElement(By.xpath("//input[@name='password']"));
		//WebElement loginBtn = driver.findElement(By.cssSelector("button.btn.btn-solid"));
		//WebElement pharName = driver.findElement(By.id("nav-link-accountList-nav-line-1"));

		//emailTxt.clear();
		//emailTxt.sendKeys("ahmed.ibrahim@rubikans.com");
		//passwordTxt.clear();
		//passwordTxt.sendKeys("123456789");
		//loginBtn.click();
		//System.out.println(pharName.getText());
		//Assert.assertTrue(pharName.getText().contains("Android"));

//		driver.findElement(emailTxt).clear();
//		driver.findElement(emailTxt).sendKeys("ahmed.ibrahim@rubikans.com");
//		driver.findElement(passwordTxt).clear();
//		driver.findElement(passwordTxt).sendKeys("123456789");
//		driver.findElement(loginBtn).click();
//		Thread.sleep(2000);
//		System.out.println(driver.findElement(pharName).getText());
//		Assert.assertTrue(driver.findElement(pharName).getText().contains("Android"));

	}


	@AfterTest
	public void closeDriver()
	{
		//driver.quit();
	}
}
