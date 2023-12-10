package workingWithElemenets;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithTextBoxAndButtons1 {

	ChromeDriver driver;

	private By unsernametxt = By.cssSelector("input[id='username']");
	private By passwordTxt = By.xpath("//input[@name='password']");
	private By loginBtn = By.xpath("//button[@type='submit']");
	private By loginSuccessMsg = By.id("flash");

	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/login");


	}

	@Test
	public void pharmacyLogin() throws InterruptedException
	{
		unsernametxt.findElement(driver).clear();
		unsernametxt.findElement(driver).sendKeys("tomsmith");
		passwordTxt.findElement(driver).clear();
		passwordTxt.findElement(driver).sendKeys("SuperSecretPassword!");
		loginBtn.findElement(driver).click();
	
		loginSuccessMsg.findElement(driver);
		Assert.assertTrue(loginSuccessMsg.findElement(driver).getText().contains("You logged into a secure area"));
		
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
