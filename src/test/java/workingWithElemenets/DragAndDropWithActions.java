package workingWithElemenets;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropWithActions {

	ChromeDriver driver;
	private By drag = By.id("draggable");
	private By drop = By.id("droppable");

	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://cookbook.seleniumacademy.com/DragDropDemo.html");


	}

	@Test(enabled=false)
	public void testdragAndDrop() 
	{
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).perform();
		Assert.assertEquals("Dropped!", drop.getText());
		Assert.assertTrue(drop.getText().equals("Dropped!"));
	}

	@Test
	public void testdragAndDrop2() 
	{
//		Actions action = new Actions(driver);
//		action.dragAndDrop(driver.findElement(drag), driver.findElement(drop)).perform();
//		Assert.assertEquals("Dropped!", driver.findElement(drop).getText());
//		Assert.assertTrue(driver.findElement(drop).getText().equals("Dropped!"));
		Actions action = new Actions(driver);
		action.dragAndDrop(drag.findElement(driver), drop.findElement(driver)).build().perform();
		Assert.assertEquals("Dropped!", drop.findElement(driver).getText());
	}


	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
