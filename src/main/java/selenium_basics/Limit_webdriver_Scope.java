package selenium_basics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Limit_webdriver_Scope 

{
 public static void main(String[] args) throws InterruptedException {
	
	 //1.get the count of links in a page
	 //a, every link will have the tag name a
		System.setProperty("webdriver.chrome.driver",
				  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		ChromeDriver driver= new ChromeDriver(ops) ;
		
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElements(By.tagName("a")).size());

 //2.get the number of links in the footer
//limit the web driver page to a particular section
		//for limitng the scope always use the find element and not fin elements
		
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		
		System.out.println(footerdriver.findElements(By.tagName("a")).size());	

		//3.get the first column links
		
		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		System.out.println(columndriver.findElements(By.tagName("a")).size());	
 
		//click on each link in the particular column
		for (int i = 1; i < columndriver.findElements(By.tagName("a")).size(); i++)
		{
			
			//to send multiple keys at same time
			//in situtations like opening a link on staying on the same page
			String keyclub = Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(keyclub);
			//4.get the title of each page;
			
			Thread.sleep(5000L);
			
		}
			
		
		//move to each tab and get the title
			Set<String> whandles = driver.getWindowHandles();
			Iterator<String> it  =whandles.iterator();
			
			
			
			while (it.hasNext()) 
			
			{
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
				
				
				
			}
			
			
			
		driver.close();
		
		
 }
}
