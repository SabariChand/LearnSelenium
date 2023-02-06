package selenium_basics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;


public class Learn_Screen_shot 
{
	static WebDriver driver;
	@Test(priority = 1)
public static void Learn_Screen_shot() 
	{
	

	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
	 
	 driver = new ChromeDriver();
	 
	 driver.manage().window().maximize();
	 
	 driver.get("https://www.amazon.in/");
	 
	 
	 //to get the visible page screenshot using TakeScreenshot Interface
	 
	 File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 
	 try {
		FileUtils.copyFile(screenshotAs, new File ("C:\\Users\\Sabari Nathan\\Documents\\Eclipses_Storage\\Selenium\\LearnSelenium\\screenshots\\window_1.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	 
	 driver.close();
	 
}
	 @Test(priority = 2)
	 public static void Learn_Element_Screenshot()
	 {
		 
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
		 
		 driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 
		 driver.get("https://www.amazon.in/");
		
		 
		 
		 WebElement amazonlogo = driver.findElement(By.cssSelector("#nav-logo-sprites"));
		 
		 //to get the specific web element  screenshot using 
		 
		 File src = amazonlogo.getScreenshotAs(OutputType.FILE);
		 
		 File dest = new File("C:\\\\Users\\\\Sabari Nathan\\\\Documents\\\\Eclipses_Storage\\\\Selenium\\\\LearnSelenium\\\\screenshots\\\\amazonlogo_.png");
		 
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	 }
	
	 
	 @Test(priority = 3)
	 public static void Learn_Full_Page_Screenshot()
	 {
		 
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
		 
		 driver = new FirefoxDriver();
		 
		 driver.manage().window().maximize();
		 
		 driver.get("https://www.amazon.in/");
		
		 
		 File src = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
		 

		 
		 File dest = new File("C:\\\\Users\\\\Sabari Nathan\\\\Documents\\\\Eclipses_Storage\\\\Selenium\\\\LearnSelenium\\\\screenshots\\\\amazonfullpage_.png");
		 
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	 }
	
}
