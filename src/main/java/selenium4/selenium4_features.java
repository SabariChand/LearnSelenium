package selenium4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class selenium4_features {

	
	 @Test static void Relative_Locators() { //Driver Setup
	  System.setProperty("webdriver.chrome.driver",
	  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe"
	  ); WebDriver driver = new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
	  driver.get("https://demowebshop.tricentis.com/");
	  
	  WebElement edit = driver.findElement(By.cssSelector("#small-searchterms"));
	  
	  String text =
	  driver.findElement(with(By.tagName("a")).above(edit)).getText();
	  
	  System.out.println(text); }
	 
	
	
	
		@Test
		public void InvokingMultipplewindows() throws InterruptedException
		{
		 //Driver Setup
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();

		 driver.manage().window().maximize();
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//invoking a new tab
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		//invoking a new Window
		//driver.switchTo().newWindow(WindowType.WINDOW);
		
		 Set<String> whandles = driver.getWindowHandles();
		 Iterator<String > it = whandles.iterator();
		 String parentWindowId = it.next();
		 String child =it.next();
		 driver.switchTo().window(child);
		 driver.get("https://rahulshettyacademy.com");
		 String text = driver.findElements(By.cssSelector("a[href ='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		 System.out.println(text);
		 driver.switchTo().window(parentWindowId);
		 driver.findElement(By.cssSelector("input[name='name']")).sendKeys(text);
		 Thread.sleep(1000);
		 driver.quit();
		}
		
		@Test
		public static void WebElemtnScreenshot() throws InterruptedException, IOException
		{
			 //Driver Setup
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
			 WebDriver driver = new ChromeDriver();

			 driver.manage().window().maximize();
			 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://rahulshettyacademy.com/angularpractice/");
			//invoking a new tab
			
			driver.switchTo().newWindow(WindowType.TAB);
			
			//invoking a new Window
			//driver.switchTo().newWindow(WindowType.WINDOW);
			
			 Set<String> whandles = driver.getWindowHandles();
			 Iterator<String > it = whandles.iterator();
			 String parentWindowId = it.next();
			 String child =it.next();
			 driver.switchTo().window(child);
			 driver.get("https://rahulshettyacademy.com");
			 String text = driver.findElements(By.cssSelector("a[href ='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
			 System.out.println(text);
			 driver.switchTo().window(parentWindowId);
			 WebElement namebox = driver.findElement(By.cssSelector("input[name='name']"));
			 namebox.sendKeys(text);
			 File filename = namebox.getScreenshotAs(OutputType.FILE);
			 
			 FileUtils.copyFile(filename, new File("C:\\\\Users\\\\Sabari Nathan\\\\Documents\\\\Eclipses_Storage\\\\Selenium\\\\LearnSelenium\\\\screenshots\\\\elementlogo.png"));
			 Thread.sleep(1000);
			 driver.quit();
			 
		}
		
		@Test
		public static void getDimensions() throws InterruptedException, IOException
		{
			 //Driver Setup
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
			 WebDriver driver = new ChromeDriver();

			 driver.manage().window().maximize();
			 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://rahulshettyacademy.com/angularpractice/");
			//invoking a new tab
			
			driver.switchTo().newWindow(WindowType.TAB);
			
			//invoking a new Window
			//driver.switchTo().newWindow(WindowType.WINDOW);
			
			 Set<String> whandles = driver.getWindowHandles();
			 Iterator<String > it = whandles.iterator();
			 String parentWindowId = it.next();
			 String child =it.next();
			 driver.switchTo().window(child);
			 driver.get("https://rahulshettyacademy.com");
			 String text = driver.findElements(By.cssSelector("a[href ='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
			 System.out.println(text);
			 driver.switchTo().window(parentWindowId);
			 WebElement namebox = driver.findElement(By.cssSelector("input[name='name']"));
			 namebox.sendKeys(text);
			 Thread.sleep(1000);
			 int height = namebox.getRect().height;
			 int width = namebox.getRect().width; 
			 System.out.println("Height of the textbox :"+height);
			 System.out.println("Width of the textbox : "+width);
			 driver.quit();
			 
			 
			 
		}
}
