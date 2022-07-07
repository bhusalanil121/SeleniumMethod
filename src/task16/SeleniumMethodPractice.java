package task16;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.Dimension;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumMethodPractice {
	WebDriver driver;

	@BeforeTest
	public void UrlTest() {
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.bestbuy.com/");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test(enabled = false, priority = 1)
	public void navigateTesting() throws InterruptedException {
		driver.navigate().to("https://www.amazon.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Shoes", Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Ball");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		Thread.sleep(3000);
		driver.navigate().to("https://www.bestbuy.com/");
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		Dimension dem = new Dimension(750, 450);
		driver.manage().window().setSize(dem);
		Thread.sleep(3000);
		System.out.println("Size of the Screen is : " + driver.manage().window().getSize());
		Thread.sleep(3000);
	}

	@Test(enabled = false, priority = 2)
	public void dropdownTest() throws InterruptedException {
		driver.navigate().to("https://www.amazon.com/");
		Thread.sleep(3000);
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		Select select = new Select(dropDown);
		select.selectByIndex(1);
		Thread.sleep(3000);
		select.selectByValue("search-alias=fashion-mens");
		Thread.sleep(3000);
		select.selectByVisibleText("Baby");
		Thread.sleep(3000);
		select.selectByVisibleText("   Boys");
		Thread.sleep(3000);
	}

	@Test(enabled = false, priority = 3)
	public void hoverTesting() throws InterruptedException {
		driver.navigate().to("https://www.amazon.com/");
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		WebElement prime = driver.findElement(By.xpath("//span[text()='Prime']"));
		actions.moveToElement(prime).build().perform();
		Thread.sleep(3000);	
	}
	@Test(enabled = true, priority = 4)
	
	public void alertTesting() throws InterruptedException {driver.navigate().to("http://softwaretestingplace.blogspot.com/2017/03/javascript-alert-test-page.html");
	Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(4000);
		Alert alert = driver.switchTo().alert(); // important
		Thread.sleep(4000);
		System.out.println("The text of the Alert is: "+alert.getText()); 
		// line 37, not part of the function, we just added to know about, the text is present in the alert or not
		alert.accept();	
	}
	

	@AfterTest
	public void tearUp() {
		driver.quit();
	}
}
