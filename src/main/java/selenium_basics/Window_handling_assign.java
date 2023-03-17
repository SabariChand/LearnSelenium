package selenium_basics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Window_handling_assign {

	public static void main(String[] args) throws InterruptedException 
	
	{
		System.setProperty("webdriver.chrome.driver",
				  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		ChromeDriver driver= new ChromeDriver(ops) ;
		
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		
		driver.findElement(By.linkText("Multiple Windows")).click();
		
		driver.findElement(By.cssSelector("div[class='example'] a")).click();
		
		Set<String> winds   = driver.getWindowHandles();
		
		Iterator<String> iterator = winds.iterator();
		
		String Parentid = iterator.next();
		
		String childid = iterator.next();
		
		driver.switchTo().window(childid);
		
		System.out.println(driver.findElement(By.cssSelector("div[class ='example'] h3")).getText());
		
		driver.switchTo().window(Parentid);
		
		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
		
		driver.quit();	
		
	}
}
