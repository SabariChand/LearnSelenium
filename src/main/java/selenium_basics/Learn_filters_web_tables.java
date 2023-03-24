package selenium_basics;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Learn_filters_web_tables {

	public static void main(String[] args) {
		
	
	System.setProperty("webdriver.chrome.driver",
			  "C:\\Users\\Sabari Nathan\\Documents\\JAVA-SELNIUM\\drivers\\chromedriver.exe");
	//some additional code for chromm 111 version
	ChromeOptions ops = new ChromeOptions();
	ops.addArguments("--remote-allow-origins=*");
	ChromeDriver driver= new ChromeDriver(ops) ;
	
	driver.manage().window().maximize();
	
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

	driver.findElement(By.cssSelector("#search-field")).sendKeys("Rice");
	//1webelement
	List<WebElement> prods = driver.findElements(By.xpath("//tr//td[1]"));
	
	//1 web element
	List<WebElement> filterredprods = prods.stream().filter(s-> s.getText().contains("Rice"))
			.collect(Collectors.toList());
	Assert.assertEquals(prods.size(), filterredprods.size());
	
	
	
	
}
}
