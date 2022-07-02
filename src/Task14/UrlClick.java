package Task14;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UrlClick {
WebDriver driver; 
@BeforeTest
public void urlSetting() {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://www.bestbuy.com/");
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	

}

@Test
public void urlTest() throws InterruptedException {
driver.findElement(By.cssSelector("span[class='v-p-right-xxs.line-clamp']")).click();
//	driver.findElement(By.cssSelector("span.v-p-right-xxs.line-clamp")).click();
	Thread.sleep(5000);
}

@AfterTest
public void tearTest() {
	driver.quit();
}

	
}
