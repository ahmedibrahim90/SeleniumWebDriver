package findingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementByXpath {

	ChromeDriver driver;

	

	private By usernametxt = By.xpath("//input[@id='username']");
	private By passwordtxt = By.xpath("//input[@type='password']");
	private By loginBtn = By.xpath("//button[@type='submit']");


	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
		driver.manage().window().maximize();
	}

	@Test
	public void findElementByXpath()
	{
		//WebElement usernametxt = driver.findElement(By.xpath("//input[@id='username']"));
		//WebElement passwordtxt = driver.findElement(By.xpath("//input[@type='password']"));
		//WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));

		//System.out.println(usernametxt.getTagName());
		//System.out.println(passwordtxt.getTagName());
		//System.out.println(loginBtn.getText());

		usernametxt.findElement(driver).sendKeys("user");
		System.out.println(usernametxt.findElement(driver).getTagName());
		passwordtxt.findElement(driver).sendKeys("pass");
		System.out.println(passwordtxt.findElement(driver).getTagName());
		loginBtn.findElement(driver).click();
		System.out.println(loginBtn.findElement(driver).getText());
	}



	@AfterTest
	public void closeDriver()
	{
		//driver.quit();
	}
}
