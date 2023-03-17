package selenium_basics;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Learn_Frames 

{
	public static void main(String[] args) {
		
	
	System.setProperty("webdriver.chrome.driver",
			  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
	
	ChromeOptions ops = new ChromeOptions();
	ops.addArguments("--remote-allow-origins=*");

	//Just pass this 'ops' object to ChromeDriver() as argument

	ChromeDriver driver= new ChromeDriver(ops) ;
	
	driver.manage().window().maximize();

	driver.get("https://jqueryui.com/droppable/");
	
	System.out.println(driver.findElements(By.tagName("iframe")).size());
	
	//if you know the frame index
	driver.switchTo().frame(0);
	
	
	//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class ='demo-frame']")));
	
	WebElement src = driver.findElement(By.id("draggable"));
	
	WebElement des = driver.findElement(By.id("droppable"));
	
	Actions act = new Actions(driver);
	
	act.dragAndDrop(src, des).build().perform();
	
	driver.switchTo().defaultContent();
	driver.close();
	
	
	}
}
