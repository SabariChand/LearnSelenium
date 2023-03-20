package selenium_basics;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Learn_auto_dropdown_assign {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub


		System.setProperty("webdriver.chrome.driver",
				  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
		//some additional code for chromm 111 version
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		ChromeDriver driver= new ChromeDriver(ops) ;
		
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		
		driver.findElement(By.cssSelector(".ui-autocomplete-input")).sendKeys("United");
		
		Thread.sleep(2000);
		
		List<WebElement> ite = driver.findElements(By.cssSelector(".ui-menu-item"));

		Actions act = new Actions(driver);
		
		
		for(WebElement it: ite)
		{
			if(it.getText().contains("United Kingdom"))
			{
				act.keyDown(Keys.ARROW_DOWN).perform();
				act.keyDown(Keys.ARROW_DOWN).perform();
				act.keyDown(Keys.ARROW_DOWN).perform();
			}
		
		}
		
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value")); 
		
	}

}
