package task15;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DifferentMethods {
	WebDriver driver;
@BeforeTest
public void urlSetting() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	driver.get("https://www.bestbuy.com/");
	 
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}

@Test
public void urlTest() throws InterruptedException {
//	driver.findElement(By.xpath("//button[@class='c-button-unstyled hamburger-menu-button']")).click();
//	Thread.sleep(5000);
	
	boolean CurbSidePickUp = driver.findElement(By.xpath("//img[@class='img-responsive' and @alt='Curbside Pickup']")).isDisplayed();
	Thread.sleep(5000);
	System.out.println("Curb Side PickUp: "+ CurbSidePickUp);
	
	boolean MenuButtonEnable = driver.findElement(By.xpath("//button[@class='c-button-unstyled hamburger-menu-button']")).isEnabled();
	Thread.sleep(5000);
	System.out.println("Menu Button Enable "+ MenuButtonEnable);
	
	
	
	
}

@AfterTest
public void tearUp() {
	driver.quit();
}

	
}
