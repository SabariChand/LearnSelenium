package learn_web_tables;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class WebTables 

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
	
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

	driver.findElement(By.xpath("//tr//th[1]")).click();
	
	//1.capture all the webelemrnt to a list
	//2.capture all the text of web elements into new list
	//sort the list of steps 2   ->sorted list
	//3. compare original vs expected
	
	List<WebElement> element_list = driver.findElements(By.xpath("//tr//td[1]"));
	
	List<String> original_list = element_list.stream().map(s->s.getText()).collect(Collectors.toList());
	
	List<String> sorted_list = original_list.stream().sorted().collect(Collectors.toList());
	
	Assert.assertTrue(original_list.equals(sorted_list));
	
	
	//Scenario - get the price of each vegetable
	
	//scan the name of the column get text -Rice -print the price of list
	
	List<String > price;
	do
	{
	List<WebElement> element_list1 = driver.findElements(By.xpath("//tr//td[1]"));
	price = element_list1.stream().filter(s->s.getText().contains("Rice"))
	.map(s->getPriceofVeggies(s)).collect(Collectors.toList());
	
	price.forEach(a->System.out.println(a));
		

	//pagination - to check the particular element on all the pages
	
	if(price.size()<1)
	{
		driver.findElement(By.cssSelector("[aria-label='Next']")).click();
	}
	}while(price.size()<1);
}
private static String getPriceofVeggies(WebElement s) {
	// TODO Auto-generated method stub
	
	String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
	return pricevalue;
}
}
