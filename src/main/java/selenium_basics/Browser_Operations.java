package selenium_basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Browser_Operations {

	static WebDriver driver;
	@Test
	public static void Browser_Operations()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
		 
		 driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.get("https://www.amazon.in/");
		 driver.findElement(By.linkText("Amazon miniTV")).click();
		 
		 driver.navigate().back();
		 //driver.navigate().forward();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.navigate().refresh();
		 driver.close();
	}
}
