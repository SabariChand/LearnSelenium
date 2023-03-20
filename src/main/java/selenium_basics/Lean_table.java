package selenium_basics;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Lean_table 

{
public static void main(String[] args) 
{
	
	System.setProperty("webdriver.chrome.driver",
			  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
	//some additional code for chromm 111 version
	ChromeOptions ops = new ChromeOptions();
	ops.addArguments("--remote-allow-origins=*");
	ChromeDriver driver= new ChromeDriver(ops) ;
	
	driver.manage().window().maximize();

	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
	List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
	
	Iterator<WebElement> it = values.iterator();
	
	int sum =0;
	while (it.hasNext())
	{
		sum = sum +Integer.parseInt(it.next().getText());
		
	
	}
	System.out.println(sum);

	int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
	Assert.assertEquals(sum, total);
	
	
	
}

}

