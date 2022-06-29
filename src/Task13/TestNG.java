package Task13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG {
	WebDriver driver;

	@BeforeTest
	public void usrlSetUp() {
//		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/driver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void urlTest() throws InterruptedException {
		driver.get("https://www.verizon.com/");
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
