package task15;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class get_and_send_methods {

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




@Test(enabled = false, priority = 1)
public void titleTest() throws InterruptedException {
	System.out.println("Title of the Page is: "+ driver.getTitle());
	Thread.sleep(3000);
	System.out.println("Url of the page is : "+ driver.getCurrentUrl());
	driver.findElement(By.xpath("//a[@class='bottom-left-links ' and @data-lid='hdr_td_topdeals']")).click();
	Thread.sleep(3000);
	System.out.println("Url of the page is : "+ driver.getCurrentUrl()); 
	Thread.sleep(3000);
}
@Test(enabled = false, priority = 2)
public void getText_Attribute() throws InterruptedException {
	String Menu_Text = driver.findElement(By.cssSelector("button.c-button-unstyled.hamburger-menu-button")).getText();
	Thread.sleep(3000);
	System.out.println("Text is: "+ Menu_Text);
	
	String Menu_Attribute = driver.findElement(By.cssSelector("button.c-button-unstyled.hamburger-menu-button")).getAttribute("class");
	Thread.sleep(3000);
	System.out.println("Attribute is: "+ Menu_Attribute);
}

@Test(enabled = true, priority = 3)
public void send_keys() throws InterruptedException {
	driver.findElement(By.xpath("//input[@id='gh-search-input']")).sendKeys("Bag", Keys.ENTER);
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@id='gh-search-input']")).clear(); // Not working 
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@id='gh-search-input']")).sendKeys("Ball", Keys.RETURN);
	Thread.sleep(5000);
	
	
//	driver.get("https://www.amazon.com");
//	//copied
//	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Laptop");
//	Thread.sleep(3000);
//	driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
//	Thread.sleep(3000);
//	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear(); 
//	Thread.sleep(3000);
//	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("T Shirt");
//	Thread.sleep(3000);
//	driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
//	Thread.sleep(3000);
//	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();		
//	Thread.sleep(3000);

}
//Copied
@Test(enabled = false, priority = 4)
public void searchingProductsTest() throws InterruptedException {
	driver.get("https://www.amazon.com");
	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("SOCCER BALL", Keys.ENTER);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Basketball", Keys.RETURN);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();		
	Thread.sleep(3000);
}

@AfterTest
public void tearUp() {
	driver.quit();
}


}
