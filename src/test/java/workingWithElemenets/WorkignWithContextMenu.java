package workingWithElemenets;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkignWithContextMenu {

	ChromeDriver driver;
	private By Rclick = By.cssSelector("span.context-menu-one.btn.btn-neutral");
	private By CopyBtn = By.cssSelector("li.context-menu-item.context-menu-icon.context-menu-icon-copy");

	//@SuppressWarnings("deprecation")
	@BeforeTest
	public void openURL()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


	}



	@Test(enabled=false)
	public void testContextMenu() 
	{
		WebElement Rclick = driver.findElement(By.cssSelector("span.context-menu-one.btn.btn-neutral"));
		WebElement edited = driver.findElement(By.cssSelector("li.context-menu-item.context-menu-icon.context-menu-icon-edit"));
		Actions action = new Actions(driver);
		action.contextClick(Rclick).moveToElement(edited).click().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		Assert.assertEquals("clicked: edit", alert.getText());
		alert.accept();
	}

	@Test(enabled=true)
	public void testContextMenuAgain() 
	{
//		driver.findElement(Rclick);
//		driver.findElement(edited);
//		Actions action = new Actions(driver);
//		action.contextClick(driver.findElement(Rclick)).moveToElement(driver.findElement(edited)).click().perform();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		System.out.println(alert.getText());
//		Assert.assertEquals("clicked: edit", alert.getText());
//		alert.accept();
		Actions action = new Actions(driver);
		action.contextClick(Rclick.findElement(driver));
		action.moveToElement(CopyBtn.findElement(driver));
		action.click().build().perform();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("clicked: copy", alert.getText());
		alert.accept();
	}

	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
