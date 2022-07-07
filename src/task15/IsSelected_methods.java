package task15;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IsSelected_methods {

	WebDriver driver;
@BeforeTest
public void urlSetting() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	driver.get("https://enthrallit.com/selenium/");
	 
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}




@Test
public void urlTest() throws InterruptedException {
boolean buttonSelected = driver.findElement(By.xpath("//label[@class='form-check-label' and @for= 'flexCheckDefault2' and normalize-space(text())='Windows']")).isEnabled();
Thread.sleep(3000);


//driver.findElement(By.xpath("//label[@class='form-check-label' and @for= 'flexCheckChecked2' and normalize-space(text())='Linux']")).click();
//Thread.sleep(3000);


boolean buttonSelected2 = driver.findElement(By.xpath("//input[@class='form-check-input' and  @id = 'flexCheckChecked2']")).isSelected();
Thread.sleep(3000);

System.out.println("button Selected: "+ buttonSelected);
System.out.println("button Selected2: "+ buttonSelected2);
}

@AfterTest
public void tearUp() {
	driver.quit();
}


}
