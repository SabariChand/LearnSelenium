package selenium_basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial;

public class Learn_Dropdown 
{
	static WebDriver driver;
	@Test
	public static void staticDropdown()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
		 
		 driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		 WebElement dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		 
		 //These methods are only applicable if the tag is select or id=f any other tag it wont work
		 Select dl = new Select(dropdown);
		 //dl.selectByIndex(3);
		 //dl.selectByValue("AED");
		 dl.selectByValue("INR");
		 //String text = dl.getFirstSelectedOption().getText();
		 //System.out.println(text);
		 
		 
	}
	
	@Test
	public static void latest_dropdown()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
		 
		 driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		 String Initialvalue = driver.findElement(By.xpath("//Label[normalize-space()='PASSENGERS']//following::div[@id ='divpaxinfo']")).getText();
		 driver.findElement(By.xpath("//Label[normalize-space()='PASSENGERS']//following::div[@id ='divpaxinfo']")).click();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 int i=1;
		 while(i<5)
		 {
			 driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();//click 5 times
			 i++;
		 } 
		 
		 //		 for(int j =1; j<5; j++) {
			//driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();//click 5 times
		//}
		 
		 
		 driver.findElement(By.cssSelector("#btnclosepaxoption")).click();
		 String finalvalue = driver.findElement(By.xpath("//Label[normalize-space()='PASSENGERS']//following::div[@id ='divpaxinfo']")).getText();
		 
		 System.out.println("Before: " +Initialvalue);
		 System.out.println("After: " +finalvalue);
		 driver.quit();
	}
	
	@Test
	public static void DynamicDropdown()
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
		 
		 driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		 driver.findElement(By.xpath("//input[@id ='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		
		 //with Indexing 
		 driver.findElement(By.xpath("//a[@value='BLR']")).click();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.findElement(By.xpath("//a[@value='MAA'][2]")).click();
		 
		 //without Indexing using PARENT CHILD RELATIONSHIP
		 
		 //DEPATURE
		 //Xpath: //div[@id ='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR']
		 
		 //DESTINATION
		//div[@id ='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='MAA']
	}
	
	@Test
	public static void AutosuggetiveDropdown() throws InterruptedException
	{
		
		//inspect the text field and send the keys
		//grab a genereic xpath for the list of items
		//in a for loop using if condition check for you desired option and clickS
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
		 
		 driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		 driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		 Thread.sleep(3000);
		 List<WebElement> options = driver.findElements(By.cssSelector("li[class ='ui-menu-item'] a"));
		 
		for(WebElement option: options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}
				
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		driver.quit();

		 
		
	}
}
