package selenium_basics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Learn_Window_Handling 
{
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver",
			  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
	
	ChromeOptions ops = new ChromeOptions();
	ops.addArguments("--remote-allow-origins=*");

	//Just pass this 'ops' object to ChromeDriver() as argument

	ChromeDriver driver= new ChromeDriver(ops) ;
	
	driver.manage().window().maximize();

	driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	
	driver.findElement(By.cssSelector(".blinkingText")).click();
	
	Set<String> windowHandles = driver.getWindowHandles();
	
	 Iterator<String>  itr  = windowHandles.iterator();
	String parentId = itr.next();
	String childId = itr.next();
	driver.switchTo().window(childId);
	
	String text = driver.findElement(By.cssSelector(".im-para.red")).getText();
	String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
	
	driver.switchTo().window(parentId);
	driver.findElement(By.cssSelector("#username")).sendKeys(emailId);

	
	
}
}
