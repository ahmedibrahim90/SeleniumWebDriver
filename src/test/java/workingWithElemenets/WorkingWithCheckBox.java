package workingWithElemenets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithCheckBox {

	ChromeDriver driver;
	private By checkbox1 = By.xpath("//*[@id=\"checkboxes\"]/input[1]");
	private By checkbox2 = By.xpath("//*[@id=\"checkboxes\"]/input[2]");

	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");


	}

	@Test(enabled=false)
	public void testCheckbox() 
	{

		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		checkbox1.click();

		if (checkbox2.isSelected()) {

			checkbox2.click();
		}
		Assert.assertTrue(checkbox1.isSelected());
		Assert.assertFalse(checkbox2.isSelected());

	}

	@Test(enabled=true)
	public void testCheckboxAgain() 
	{
		checkbox1.findElement(driver).click();
		
		if(checkbox2.findElement(driver).isSelected())
		{
			checkbox2.findElement(driver).click();
		}
		
		Assert.assertTrue(checkbox1.findElement(driver).isSelected());
		Assert.assertFalse(checkbox2.findElement(driver).isSelected());
	}

	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
