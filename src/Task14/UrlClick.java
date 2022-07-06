package Task14;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UrlClick {
	WebDriver driver;

	@BeforeTest
	public void urlSetting() {
		// System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
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
		// Not Working

//driver.findElement(By.cssSelector("span[class='v-p-right-xxs.line-clamp']")).click();

		// not working
//		driver.findElement(By.className("c-button-unstyled hamburger-menu-button")).click();

		// working
//		driver.findElement(By.xpath("//button[@class='c-button-unstyled hamburger-menu-button']")).click();
		
		//working
//	driver.findElement(By.cssSelector("span.v-p-right-xxs.line-clamp")).click();
	
	//driver.findElement(By.name("Menu")).click(); //didn't work 
		driver.findElement(By.linkText("Saved Items")).click();
	
		Thread.sleep(10000);
	}
	

	
	

	@AfterTest
	public void tearTest() {
		driver.quit();
	}

}
