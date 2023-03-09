package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Learn_Alert

{
	@Test
	public static void Learn_Alert()
	{
	WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
	 
	 driver = new ChromeDriver();
	 
	 driver.manage().window().maximize();
	 driver.get("http://the-internet.herokuapp.com/");
	 driver.findElement(By.linkText("JavaScript Alerts")).click();
	 driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
	 driver.switchTo().alert().accept();
	 
	}
}
