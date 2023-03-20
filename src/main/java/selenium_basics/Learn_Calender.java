package selenium_basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Learn_Calender 
{

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
		//some additional code for chromm 111 version
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		ChromeDriver driver= new ChromeDriver(ops) ;
		
		driver.manage().window().maximize();

		driver.get("https://www.path2usa.com/travel-companion/");
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		driver.findElement(By.cssSelector("#form-field-travel_comp_date")).click();

		
		while(!driver.findElement(By.cssSelector("[class ='flatpickr-current-month'] [class ='cur-month']")).getText().contains("August")) 
		
		{
			System.out.println(driver.findElement(By.cssSelector("[class ='flatpickr-current-month'] [class ='cur-month']")).getText());
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']//*[name()='svg']")).click();
		}
		
		
		List<WebElement> findElements = driver.findElements(By.className("flatpickr-day"));
		
		int n = driver.findElements(By.className("flatpickr-day")).size();
		
		for (int i = 0; i <n ; i++) 
		
			
		{
			String text = driver.findElements(By.className("flatpickr-day")).get(i).getText();
			
			
			if(text.equalsIgnoreCase("23"))
					{
				driver.findElements(By.className("flatpickr-day")).get(i).click();
				break;
					}
			
			
			
		}
			
		//span[@class = 'flatpickr-next-month']
			
		
	}
}
