package selenium_basics;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Frames_assign 

{


		public static void main(String[] args) {
			
			
			System.setProperty("webdriver.chrome.driver",
					  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
			
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");

			//Just pass this 'ops' object to ChromeDriver() as argument

			ChromeDriver driver= new ChromeDriver(ops) ;
			
			driver.manage().window().maximize();

			driver.get("https://the-internet.herokuapp.com/");
			

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			
			driver.findElement(By.linkText("Nested Frames")).click();
				driver.switchTo().frame("frame-top");
				
				driver.switchTo().frame("frame-middle");
		 
			 System.out.println(driver.findElement(By.id("content")).getText());
			
				
			}
			 
	}
