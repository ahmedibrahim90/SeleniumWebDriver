package workingWithElemenets;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithDropDownList {

	ChromeDriver driver;
	private By dropdownList = By.id("dropdown");

	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/dropdown");


	}

	@Test
	public void testDropDownList() 
	{

		//dropdownList.findElement(driver);
		Select selectoptions = new Select(dropdownList.findElement(driver));
		selectoptions.selectByIndex(2);
		Assert.assertFalse(selectoptions.isMultiple());
		System.out.println(selectoptions.getOptions().get(2).getText());
		Assert.assertEquals(3, selectoptions.getOptions().size());
		//WebElement dropdownList = driver.findElement(By.id("dropdown"));
		//Select selectoptions = new Select(dropdownList);
		//Select selectoptions = new Select(driver.findElement(dropdownList));
		//selectoptions.selectByVisibleText("Option 2");
		//selectoptions.selectByValue("2");
		
		
		
//		selectoptions.selectByIndex(2);
//		Assert.assertFalse(selectoptions.isMultiple());
//		System.out.println(selectoptions.getOptions().get(2).getText());
//		Assert.assertEquals(3, selectoptions.getOptions().size());
				}


	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
