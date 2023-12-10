package findingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementByCSSSelector {

	ChromeDriver driver;
	
	private By usernametxt = By.cssSelector("input[id='username']");
	private By passwordtxt = By.cssSelector("input[name='password']");
	private By loginBtn = By.cssSelector(".radius");
	
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
	public void findElementByName()
	{
		
		//WebElement usernametxt = driver.findElement(By.cssSelector("input#username"));
		//WebElement passwordtxt = driver.findElement(By.cssSelector("input#password"));
		//WebElement loginBtn = driver.findElement(By.cssSelector("button.radius"));
		
		//System.out.println(usernametxt.getTagName());
		//System.out.println(passwordtxt.getTagName());
		//System.out.println(loginBtn.getText());
		

		
		WebElement user = driver.findElement(usernametxt);
		WebElement pass = driver.findElement(passwordtxt);
		WebElement btn = driver.findElement(loginBtn);
		
		System.out.println(user.getTagName());
		System.out.println(pass.getTagName());
		System.out.println(btn.getText());
	}
	
	
	
	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
