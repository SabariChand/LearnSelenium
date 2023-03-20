package selenium_basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Learn_tables_assign {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
		//some additional code for chromm 111 version
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		ChromeDriver driver= new ChromeDriver(ops) ;
		
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> tr = driver.findElements(By.cssSelector("[class = 'table-display'] tr"));
		
		
		System.out.println("The Row count of the table is "+ tr.size());
		
		List<WebElement> col = driver.findElements(By.cssSelector("[class = 'table-display'] th"));
		
		System.out.println("The Column count of the table is "+ col.size());
		
		
		System.out.println("The second row data is : "+driver.findElement(By.cssSelector("[class = 'table-display'] tr:nth-child(3)")).getText());
		
		driver.quit();
		
		
	}
	
}
